package designPatterns.factoryMethod.classic.case2_abstractClass;

// эта фабрика создает свой продукт
public class ConcreteCreatorA extends Creator {

    @Override
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}