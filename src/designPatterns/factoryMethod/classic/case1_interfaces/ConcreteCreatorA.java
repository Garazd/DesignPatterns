package designPatterns.factoryMethod.classic.case1_interfaces;

// эта фабрика создает свой продукт
public class ConcreteCreatorA implements Creator {

    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}