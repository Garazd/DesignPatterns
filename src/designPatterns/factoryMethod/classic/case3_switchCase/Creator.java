package designPatterns.factoryMethod.classic.case3_switchCase;

// абстракция фабрики
// опять же могут быть несколько реализаций, но у нас тут одна
public interface Creator {

    // обрати внимание, появился параметр productName -
    // по нему фектори определит какой продукт клиенту надо

    // и наконец-то мы переименовали, теперь оно
    // звучит, а не то что раньше factoryMethod!
    Product createProduct(String productName);
}