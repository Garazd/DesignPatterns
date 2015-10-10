package designPatterns.chainOfResponsibility.classic.case3;

public class Main {

    public static void main(String[] args) {
        // создали обработчики
        Handler h1 = new ConcreteHandlerA();
        Handler h2 = new ConcreteHandlerB();
        Handler h3 = new ConcreteHandlerC();

        // настроили их в очередь
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        // TODO но тут есть другая беда, что если неправильно выстроим очередь?

        // пошли обрабатывать
        h1.handleRequest(new Request("qwe"));
        h1.handleRequest(new Request(true));
        h1.handleRequest(new Request(15));
        // TODO или тут дернем не h1 а h3?
        // есть идеи?
        // идем в case4.Handler

        // Вывод
        // Request String:qwe processed by ConcreteHandlerB
        // Request Boolean:true processed by ConcreteHandlerA
        // Request Integer:15 processed by ConcreteHandlerC
    }
}