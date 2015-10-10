package designPatterns.chainOfResponsibility.sample.atm;

import java.util.Arrays;

// спасибо за http://www.joezimjs.com/javascript/javascript-design-patterns-chain-of-responsibility/
// это наш банкомат
public class Atm {

    // он содержит в себе серию "меняторов",
    // каждый из которых может менять деньги определенной купюрой
    private MoneyStack first;

    // в конструкторе по-умолчанию настроена цепочка "меняторов"
    // номиналами 100, 50, 20, 10, 5 и 1
    public Atm () {
        // настраиваем все "меняторы"
        MoneyStack stack100 = new MoneyStack(100);
        MoneyStack stack50 = new MoneyStack(50);
        MoneyStack stack20 = new MoneyStack(20);
        MoneyStack stack10 = new MoneyStack(10);
        MoneyStack stack5 = new MoneyStack(5);
        MoneyStack stack1 = new MoneyStack(1);

        // выстраиваем в цепочку
        stack100.setNextStack(stack50);
        stack50.setNextStack(stack20);
        stack20.setNextStack(stack10);
        stack10.setNextStack(stack5);
        stack5.setNextStack(stack1);

        // фиксируем главного из них (голову)
        first = stack100;
    }

    // но есть гипер-супер умный конструктор, которому можно передать
    // серию из любых купюр (мало ли)
    public Atm (int... billsSizes) {
        // работает он просто - вначале сортируем все номиналы
        // сортировка будет от 1 до N
        Arrays.sort(billsSizes);

        // пробегаемся по ним
        for (int size : billsSizes) {
            // конструируем "менятор" на этот номинал
            MoneyStack node = new MoneyStack(size);
            // если "первый" в цепочке уже существует
            if (first != null) {
                // просто добавляем его как следующий
                node.setNextStack(first); 
            }
            // и делаем его первым
            first = node;
        }
        // самый последний номинал в цепочке будет 1
        // а самый первый - first настроен на номинал N
    }

    // это запуск размена
    public void withdraw(int amount) {
        // мы его делегируем первому в цепочке и не переживаем :)
        System.out.println(amount + " =");
        first.withdraw(amount);
        System.out.println("--------");
    }
}