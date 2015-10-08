package designPatterns.templateMethod.classic;

public class Main {
    public static void main(String[] args) {
        // у нас есть общие для всех данные
        Integer input = new Integer(15);

        // рассмотрим первый случай
        AbstractClass case1 = new ConcreteClassA();
        System.out.println("result is: " + case1.templateMethod(input));
        // он напечатает
        // algorithm2A prints 15
        // algorithm3A prints smth
        // result is: algorithm1A plus algorithm4A 15

        System.out.println("--------------------------");

        // рассмотрим второй случай
        AbstractClass case2 = new ConcreteClassB();
        System.out.println("result is: " + case2.templateMethod(input));
        // он напечатает
        // algorithm2B prints 15
        // algorithm3B prints smth
        // result is: default_algorithm1 plus algorithm4B 15
    }
}