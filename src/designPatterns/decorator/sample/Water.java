package designPatterns.decorator.sample;

public class Water extends Beverage {

    @Override
    public int cost() {
        return 1;
    }

    @Override
    public String description() {
        return "Water";
    }
}