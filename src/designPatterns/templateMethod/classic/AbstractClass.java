package designPatterns.templateMethod.classic;

// класс должен быть помечен как абстратный
public abstract class AbstractClass {

    // это шаблонный метод, в нем закодирована общая идея взаимодействия алгоритмов
    // если мы не хотим, чтобы наследник переопределял его - ставим final
    public final Object templateMethod(Object input) {
        Object data1 = algorithm1();
        algorithm2(input);
        algorithm3();
        Object data2 = algorithm4(input);

        return data1.toString() + " plus " + data2.toString();
    }

    // реализация алгоритма 1 по-умолчанию
    // наследники реализуют ее только, если захотят
    public Object algorithm1() {
        return "default_algorithm1";
    }

    // все последующие методы-алгоритмы должны быть реализованы наследниками
    public abstract void algorithm2(Object input);

    public abstract void algorithm3();

    public abstract Object algorithm4(Object input);
}