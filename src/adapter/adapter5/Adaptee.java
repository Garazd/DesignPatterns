package adapter.adapter5;

public class Adaptee {

    public Object specificRequest(Object input) {
        System.out.println("Call Adaptee.specificRequest(" + input + ")");
        return "Hello from Adaptee!";
    }
}