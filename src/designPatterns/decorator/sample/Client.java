package designPatterns.decorator.sample;

public class Client {

    public static void main(String[] args) {
        Beverage saltWater = new Salt(new Water());
        System.out.println("Salt water: " + saltWater);

        Beverage sweetTea = new CoolSugar(new Tea(), 3);
        System.out.println("Sweet tea: " + sweetTea);

        Beverage tea = new Sugar(new Tea());
        System.out.println("Tea: " + tea);

        Beverage cappuccino = new Sugar(new Milk(new Coffee()));
        System.out.println("Cappuccino: " + cappuccino);

        Beverage late = new Sugar(new Milk(new Milk(new Coffee())));
        System.out.println("Late: " + late);

        Beverage water = new Water();
        System.out.println("Water: " + water);
    }
}