package designPatterns.chainOfResponsibility.classic.case4;

public class Main {

    public static void main(String[] args) {
        // создали обработчики
        Handler h1 = new ConcreteHandlerA();
        Handler h2 = new ConcreteHandlerB();
        Handler h3 = new ConcreteHandlerC();

        // настроили их в очередь
        Aggregator aggregator = new Aggregator();
        aggregator.addSuccessor(h1);
        aggregator.addSuccessor(h2);
        aggregator.addSuccessor(h3);
        // а ведь можно было и так
        // Aggregator aggregator = new Aggregator(h1, h2, h3);

        // пошли обрабатывать
        aggregator.handle(new Request("qwe"));
        aggregator.handle(new Request(true));
        aggregator.handle(new Request(15));

        // теперь с порядком сложнее ошибиться

        // Вывод
        // Request String:qwe processed by ConcreteHandlerB
        // Request Boolean:true processed by ConcreteHandlerA
        // Request Integer:15 processed by ConcreteHandlerC
    }
}