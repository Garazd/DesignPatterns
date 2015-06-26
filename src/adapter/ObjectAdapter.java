package adapter;

public class ObjectAdapter extends Adaptee implements TargetInterface {

    @Override
    public void targetMethod() {
        method();
    }
}