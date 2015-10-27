package designPatterns.singleton.case5_onDemandHolderIdiom_lazy_optimal;

public class Main2 {

    private final Singleton singleton1 = Singleton.getInstance();

    private static final Singleton singleton2 = Singleton.getInstance();

    public static void main(String[] args) {
        Main2 main = new Main2();

        if (main.singleton1 == singleton2) {
            System.out.println("Успех! Только один экземпляр был создан.");
        } else {
            System.out.println("Йойкс! Что-то пошло не так, у нас разные экземпляры.");
        }
    }
}