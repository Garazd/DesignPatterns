package designPatterns.decorator.sample;

public class Coffee extends Beverage {

    @Override
    public int cost() {
        return 10;
    }

    @Override
    public String description() {
        return "Coffee";
    }
}