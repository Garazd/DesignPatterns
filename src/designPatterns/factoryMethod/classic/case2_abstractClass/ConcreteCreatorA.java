package designPatterns.factoryMethod.classic.case2_abstractClass;

// эта фабрика создает свой продукт
public class ConcreteCreatorA extends Creator {

    @Override
    protected Product factoryMethod() {
        return new ConcreteProductA();
    }
}