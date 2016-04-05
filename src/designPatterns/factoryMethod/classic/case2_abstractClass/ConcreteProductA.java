package designPatterns.factoryMethod.classic.case2_abstractClass;

// конкретный продукт А
public class ConcreteProductA implements Product {

    private String config;

    @Override
    public String process(String data) {
        return String.format("ConcreteProductA[%s]: %s", config, data);
    }

    @Override
    public void setup(String config) {
        this.config = config;
    }
}