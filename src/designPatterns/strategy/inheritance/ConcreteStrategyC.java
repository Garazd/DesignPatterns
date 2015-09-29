package designPatterns.strategy.inheritance;

public class ConcreteStrategyC extends Strategy {
    @Override
    public Object algorithm(Object input) {
        return String.format("class:%s", input.getClass().getSimpleName());
    }
}