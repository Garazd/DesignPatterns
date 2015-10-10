package designPatterns.chainOfResponsibility.classic.case0;

// это наш обработчик он вводит понятие цепочки
// и тут же (в этом же классе) обрабатывает сообщение
public class Handler {

    // вот тут хранится следующий элемент
    protected Handler successor;

    // а это тип обрабатываемого риквеста
    private Class clazz;

    // надо как-то наш хендлер законфигурить
    public Handler(Class clazz) {
        this.clazz = clazz;
    }

    // а так мы его устанавливаем
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    // а тут будет обрабатываться сигнал
    public void handleRequest(Request request) {
        if (request.getMessage().getClass().equals(clazz)) {
            System.out.printf("Request %s processed by Handler#%s\n", request, hashCode());
        } else if (successor != null) {
            System.out.printf("Request %s delegated to Handler#%s\n", request, successor.hashCode());
            successor.handleRequest(request);
        }
    }
}