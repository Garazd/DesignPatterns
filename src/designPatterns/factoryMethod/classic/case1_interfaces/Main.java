package designPatterns.factoryMethod.classic.case1_interfaces;

// класс-запускатор
public class Main {

    public static void main(String[] args) {
        // где-то в системе (не на стороне клиента) создается фектори
        Creator creator = new ConcreteCreatorA();
        // Creator creator = new ConcreteCreatorB();

        // наш клиент
        Client client = new Client();

        // обрабатывает данные и получает на вход creator
        String result = client.process("data", creator);

        System.out.println(result);
        // Вывод:
        // ConcreteProductA: data
        // или
        // ConcreteProductB: data
    }
}