package designPatterns.decorator.sample;

public abstract class Additive extends Beverage {

    private Beverage beverage;

    public Additive(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost();
    }

    @Override
    public String description() {
        return beverage.description() + " + ";
    }
}