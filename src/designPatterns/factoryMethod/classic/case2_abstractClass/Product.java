package designPatterns.factoryMethod.classic.case2_abstractClass;

// а это абстракция продукта
// тут может быть и абстрактный класс
public interface Product {

    // метод для работы клиента
    String process(String data);

    // метод настройки продукта
    void setup(String config);
}