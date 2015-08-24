package adapter.adapter4;

public class AdapteeImpl implements Adaptee {

    public Object specificRequest(Object input) {
        System.out.println("Call Adaptee.specificRequest(" + input + ")");
        return "Hello from Adaptee!";
    }
}