package designPatterns.chainOfResponsibility.classic.case2;

public class Main {

    // тут без изменений
    public static void main(String[] args) {
        // создали обработчики
        Handler h1 = new ConcreteHandlerA();
        Handler h2 = new ConcreteHandlerB();
        Handler h3 = new ConcreteHandlerC();

        // настроили их в очередь
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        // пошли обрабатывать
        h1.handleRequest(new Request("qwe"));
        h1.handleRequest(new Request(true));
        h1.handleRequest(new Request(15));

        // Вывод
        // Request String:qwe processed by ConcreteHandlerB
        // Request Boolean:true processed by ConcreteHandlerA
        // Request Integer:15 processed by ConcreteHandlerC
    }
}