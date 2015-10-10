package designPatterns.chainOfResponsibility.classic.case1;

// это наш абстрактный обработчик
// он вводит понятие цепочки
public abstract class Handler {

    // вот тут хранится следующий элемент
    protected Handler successor;

    // а так мы его устанавливаем
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    // а тут наследники будут заботиться о том, как обрабатывать сигнал
    public abstract void handleRequest(Request request);
}