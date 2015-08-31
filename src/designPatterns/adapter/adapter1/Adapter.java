package designPatterns.adapter.adapter1;

public class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public Object request(Object input) {
        return adaptee.specificRequest(input);
    }
}