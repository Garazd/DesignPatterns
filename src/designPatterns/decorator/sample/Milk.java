package designPatterns.decorator.sample;

public class Milk extends Additive {

    public Milk(Beverage component) {
        super(component);
    }

    @Override
    public int cost() {
        return super.cost() + 3;
    }

    @Override
    public String description() {
        return super.description() + "Milk";
    }
}