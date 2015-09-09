package designPatterns.decorator.example;

public class CarDecorator implements Car {

    Car car;

    public CarDecorator(Car c){
        this.car = c;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}