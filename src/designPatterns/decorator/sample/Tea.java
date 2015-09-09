package designPatterns.decorator.sample;

public class Tea extends Beverage {

    @Override
    public int cost() {
        return 17;
    }

    @Override
    public String description() {
        return "Tea";
    }
}