package designPatterns.factoryMethod.classic.case1_interfaces;

// а эта - свой
public class ConcreteCreatorB implements Creator {

    @Override
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}