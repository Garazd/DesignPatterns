package designPatterns.strategy.classic;

public class ConcreteStrategyB implements Strategy {
    @Override
    public Object algorithm(Object input) {
        return String.format("length:%s", input.toString().length());
    }
}