package adapter.adapter2;

public class Client {
    public static void main(String[] args) {
        Target target = new Adapter();
        Adaptee adaptee = new Adapter();

        doit(target);
    }

    public static void doit(Target target) {
        System.out.println(target.request("Hello World!"));
    }
}