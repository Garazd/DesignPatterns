package designPatterns.factoryMethod.classic.case2_abstractClass;

// конкретный продукт B
public class ConcreteProductB implements Product {

    private String config;

    @Override
    public String process(String data) {
        return String.format("ConcreteProductB[%s]: %s", config, data);
    }

    @Override
    public void setup(String config) {
        this.config = config;
    }
}