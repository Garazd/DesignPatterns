package designPatterns.strategy.inheritance;

public class ConcreteStrategyB extends Strategy {
    @Override
    public Object algorithm(Object input) {
        return String.format("length:%s", input.toString().length());
    }
}