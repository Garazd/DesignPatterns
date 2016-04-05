package designPatterns.factoryMethod.classic.case3_switchCase;

// эта фабрика умеет создавать любые типа объектов по параметру передаваемому на вход
public class ConcreteCreator implements Creator {

    @Override
    public Product createProduct(String productName) {
        if (productName.equals("Product A")) {
            return new ConcreteProductA();
        }

        if (productName.equals("Product B")) {
            return new ConcreteProductB();
        }

        throw new UnsupportedOperationException("Unexpected product: " + productName);
    }
}