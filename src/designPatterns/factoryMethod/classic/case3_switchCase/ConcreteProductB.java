package designPatterns.factoryMethod.classic.case3_switchCase;

// конкретный продукт B
public class ConcreteProductB implements Product {

    @Override
    public String process(String data) {
        return String.format("ConcreteProductB: %s", data);
    }
}