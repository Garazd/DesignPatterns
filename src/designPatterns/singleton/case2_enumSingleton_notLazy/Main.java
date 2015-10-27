package designPatterns.singleton.case2_enumSingleton_notLazy;

public class Main {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        Singleton singleton3 = Singleton.INSTANCE;

        if (singleton1 == singleton2 && singleton2 == singleton3) {
            System.out.println("Успех! Только один экземпляр был создан.");
        } else {
            System.out.println("Йойкс! Что-то пошло не так, у нас разные экземпляры.");
        }
    }
}