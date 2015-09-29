package designPatterns.strategy.inheritance;

public class ConcreteStrategyA extends Strategy {
    @Override
    public Object algorithm(Object input) {
        return String.format("toString:'%s'", input);
    }
}