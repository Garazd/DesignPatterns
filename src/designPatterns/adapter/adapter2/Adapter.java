package designPatterns.adapter.adapter2;

public class Adapter extends Adaptee implements Target {

    public Object request(Object input) {
        return super.specificRequest(input);
    }
}