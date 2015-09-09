package designPatterns.decorator.classic;

public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public Object operation(Object input) {
        System.out.printf("Call ConcreteDecoratorB.operation('%s')\n", input);

        Object result = "[before]" + addedBehaviour(input) + "[after]";

        System.out.printf("Exit ConcreteDecoratorB.operation() with '%s'\n", result);
        return result;
    }

    public Object addedBehaviour(Object input) {
        System.out.printf("Call ConcreteDecoratorB.addedBehaviour('%s')\n", input);

        String result = super.operation(input).toString().toUpperCase();

        System.out.printf("Exit ConcreteDecoratorB.addedBehaviour() with '%s'\n", result);
        return result;
    }
}