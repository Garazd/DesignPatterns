package designPatterns.strategy.inheritance;

public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Object method(Object input) {
        return String.format("Object: %s, %s", input, strategy.algorithm(input));
    }
}