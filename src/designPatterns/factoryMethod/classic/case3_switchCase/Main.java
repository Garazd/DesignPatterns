package designPatterns.factoryMethod.classic.case3_switchCase;

// класс-запускатор
public class Main {

    public static void main(String[] args) {
        // где-то в системе (не на стороне клиента) создается фектори
        Creator creator = new ConcreteCreator();

        // наш клиент
        Client client = new Client();

        // обрабатывает данные и получает на вход creator и тип продукта
        String result = client.process("data", creator, "Product A");  // или "Product B"

        System.out.println(result);
        // Вывод:
        // ConcreteProductA: data
        // или
        // ConcreteProductB: data
    }
}