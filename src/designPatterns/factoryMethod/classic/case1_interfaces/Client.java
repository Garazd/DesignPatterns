package designPatterns.factoryMethod.classic.case1_interfaces;

// наш клиент
public class Client {

    // заметь, что клиент ничего не знает ни про реализацию Creator
    // ни про реализацию Product - кругом одни абстракции
    public String process(String data, Creator creator) {
        Product product = creator.factoryMethod();

        // тут может быть что угодно

        return product.process(data);
    }
}