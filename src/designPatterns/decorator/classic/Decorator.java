package designPatterns.decorator.classic;

public abstract class Decorator extends Component {

    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public Object operation(Object input) {
        return component.operation(input);
    }
}