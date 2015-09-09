package designPatterns.decorator.sample;

public class Salt extends Additive {

    public Salt(Beverage beverage) {
        super(beverage);
    }

    @Override
    public int cost() {
        return super.cost() + 1;
    }

    @Override
    public String description() {
        return super.description() + "Salt";
    }
}