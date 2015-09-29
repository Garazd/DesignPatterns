package designPatterns.strategy.classic;

public class ConcreteStrategyA implements Strategy {
    @Override
    public Object algorithm(Object input) {
        return String.format("toString:'%s'", input);
    }
}