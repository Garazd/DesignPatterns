package designPatterns.adapter.example;

public class ObjectAdapter extends Adaptee implements TargetInterface {

    @Override
    public void targetMethod() {
        method();
    }
}