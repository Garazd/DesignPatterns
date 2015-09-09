package designPatterns.decorator.interfaces;

public class Client {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();

        System.out.println(component.operation("component"));
        System.out.println("------------------------------------------");

        Component case1 = new ConcreteDecoratorA(component, "qwe");
        System.out.println(case1.operation("decorated with A"));
        System.out.println("------------------------------------------");

        Component case2 = new ConcreteDecoratorB(component);
        System.out.println(case2.operation("decorated with B"));
        System.out.println("------------------------------------------");

        Component case3 = new ConcreteDecoratorA(new ConcreteDecoratorB(component), "qwe");
        System.out.println(case3.operation("decorated with A and then B"));
        System.out.println("------------------------------------------");

        Component case4 = new ConcreteDecoratorB(new ConcreteDecoratorA(component, "qwe"));
        System.out.println(case4.operation("decorated with B and then A"));
        System.out.println("------------------------------------------");
    }
}