package designPatterns.factoryMethod.classic.case3_switchCase;

// наш клиент
public class Client {

    // заметь, что клиент ничего не знает ни про реализацию Creator
    // ни про реализацию Product - кругом одни абстракции
    public String process(String data, Creator creator, String projectName) {
        Product product = creator.createProduct(projectName);

        // тут может быть что угодно

        return product.process(data);
    }
}