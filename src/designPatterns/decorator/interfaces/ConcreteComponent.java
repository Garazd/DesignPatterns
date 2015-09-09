package designPatterns.decorator.interfaces;

public class ConcreteComponent implements Component {

    @Override
    public Object operation(Object input) {
        System.out.printf("Call ConcreteComponent.operation('%s')\n", input);

        Object result = input;

        System.out.printf("Exit ConcreteComponent.operation() with '%s'\n", result);
        return result;
    }
}