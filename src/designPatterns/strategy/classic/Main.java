package designPatterns.strategy.classic;

public class Main {
    public static void main(String[] args) {
        Boolean input = new Boolean(true);

        Context context = new Context(new ConcreteStrategyA());
        System.out.println(context.method(input));

        context.setStrategy(new ConcreteStrategyB());
        System.out.println(context.method(input));

        context.setStrategy(new ConcreteStrategyC());
        System.out.println(context.method(input));
    }
}