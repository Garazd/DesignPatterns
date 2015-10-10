package designPatterns.chainOfResponsibility.sample.atm;

// а это наш менятор
// он несколько отличается от классики
// тут роли Handler и ConcreteHandler объеденены
public class MoneyStack {

// для начала абстракция - то что унес бы Handler, если бы мы разделили классы по-классике

    // он в себе содержит следующий в цепочке
    private MoneyStack next;

    // и кастомизируется суммой размена
    private final int billSize;

    // ... через конструктор
    public MoneyStack(int billSize) {
        this.billSize = billSize;
    }

    // а следующий "менятор" передается сеттером
    public void setNextStack(MoneyStack next) {
        this.next = next;
    }

    // то есть MoneyStack - композит из billSize
    // и всего лишь агрегат для next
    // или другими словами next изменить можно, а billSize нельзя

// теперь к конкретике, что обычно реализует ConcreteHandler

    // тадам! алгоритм размена
    public void withdraw(int amount) {
        // узнаем сколько целых купюр получается
        int numOfBills = Math.round(amount / billSize);

        // если их больше 0
        if (numOfBills > 0) {
            // снимаем денежки
            ejectMoney(numOfBills);
            amount = amount - (billSize * numOfBills);
        }

        // если есть еще что снимать и есть кому передавать по цепочке дальше
        if (amount > 0 && next != null) {
            // передаем остаток по цепочке
            next.withdraw(amount);
        }
    }

    // это муляж :) не пугайся - он только на экран выводит
    private void ejectMoney(int numOfBills) {
        System.out.println(numOfBills + " x $" + billSize);
    }
}