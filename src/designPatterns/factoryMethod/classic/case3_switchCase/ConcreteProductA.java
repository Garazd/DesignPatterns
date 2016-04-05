package designPatterns.factoryMethod.classic.case3_switchCase;

// конкретный продукт А
public class ConcreteProductA implements Product {

    @Override
    public String process(String data) {
        return String.format("ConcreteProductA: %s", data);
    }
}