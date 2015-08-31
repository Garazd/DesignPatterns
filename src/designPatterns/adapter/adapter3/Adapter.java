package designPatterns.adapter.adapter3;

public class Adapter extends Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public Object request(Object input) {
        return adaptee.specificRequest(input);
    }
}