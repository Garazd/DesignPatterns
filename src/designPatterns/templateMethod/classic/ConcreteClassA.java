package designPatterns.templateMethod.classic;

public class ConcreteClassA extends AbstractClass {

    // Хоть этот метод и реализован по-умолчанию в родителе,
    // мы все же решили его переопределить
    @Override
    public Object algorithm1() {
        return "algorithm1A";
    }

    @Override
    public void algorithm2(Object input) {
        System.out.println("algorithm2A prints " + input);
    }

    @Override
    public void algorithm3() {
        System.out.println("algorithm3A prints smth");
    }

    @Override
    public Object algorithm4(Object input) {
        return "algorithm4A " + input;
    }
}