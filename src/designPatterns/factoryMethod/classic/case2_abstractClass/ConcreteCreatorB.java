package designPatterns.factoryMethod.classic.case2_abstractClass;

// а эта - свой
public class ConcreteCreatorB extends Creator {

    @Override
    protected Product factoryMethod() {
        return new ConcreteProductB();
    }
}