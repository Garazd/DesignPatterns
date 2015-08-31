package designPatterns.adapter.adapter3;

public class Target {

    public Object request(Object input) {
        System.out.println("Call Target.request(" + input + ")");
        return "Hello from Target!";
    }
}