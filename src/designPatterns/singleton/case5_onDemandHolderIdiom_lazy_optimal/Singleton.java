package designPatterns.singleton.case5_onDemandHolderIdiom_lazy_optimal;

// ленивая реализация с оптимальной защитой для многопоточного использования

// сказано, что ею можно пользоваться только для инициализации статических полей (?)
// но я не нашел этому подтверждения
// и она самая быстрая из всех по тестам http://habrahabr.ru/post/129494/

// так же есть проблема с исключениями, которые могут возникнуть в конструкторе
// мы их не сможем обработать
public final class Singleton {

    // внутренний статический класс
    // фокус в том, что его извне не видно, а значит его
    // поле будет инстанциировано только тогда когда впервые им воспользуются
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    // а это случится, когда клиент дернет за метод
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    // все тот же приватный конструктор
    private Singleton() {
        // какие-то сложные вычисления, которые мы хотим, чтобы выполнялись единожды
        System.out.println("Инстанциировали Singleton!");
    }
}