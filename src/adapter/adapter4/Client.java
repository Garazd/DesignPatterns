package adapter.adapter4;

public class Client {
    public static void main(String[] args) {
        Adaptee adaptee = new AdapteeImpl();

        Target target = new Adapter(adaptee);

        doit(target);
    }

    public static void doit(Target target) {
        System.out.println(target.request("Hello World!"));
    }
}