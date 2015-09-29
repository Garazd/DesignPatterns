package designPatterns.strategy.classic;

public class ConcreteStrategyC implements Strategy {
    @Override
    public Object algorithm(Object input) {
        return String.format("class:%s", input.getClass().getSimpleName());
    }
}