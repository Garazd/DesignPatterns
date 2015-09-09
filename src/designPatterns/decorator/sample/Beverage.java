package designPatterns.decorator.sample;

public abstract class Beverage {

    public abstract int cost();

    public abstract String description();

    @Override
    public String toString() {
        return String.format("%s = %s$", description(), cost());
    }

}