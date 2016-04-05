package designPatterns.factoryMethod.classic.case1_interfaces;

// абстракция фабрики

// тут может быть и абстрактный класс,
// если нам надо со всеми продуктами что-то однотипное делать (case2)
public interface Creator {

    // каждая фабрика должна реализовать это
    // вообще хороший конвеншен, когда метод называется
    // Product createProduct();
    Product factoryMethod();
}