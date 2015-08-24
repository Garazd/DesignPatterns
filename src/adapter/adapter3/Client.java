package adapter.adapter3;

public class Client {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();

        Target target = new Adapter(adaptee);

        doit(target);
    }

    public static void doit(Target target) {
        System.out.println(target.request("Hello World!"));
    }
}