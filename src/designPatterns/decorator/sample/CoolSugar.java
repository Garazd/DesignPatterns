package designPatterns.decorator.sample;

public class CoolSugar extends Additive {

    private int count;

    public CoolSugar(Beverage beverage, int count) {
        super(beverage);
        this.count = count;
    }

    @Override
    public int cost() {
        return super.cost() + 2*count;
    }

    @Override
    public String description() {
        return super.description() + count + " x Sugar";
    }
}