package designPatterns.chainOfResponsibility.classic.case3;

// еще более хитрый абстрактнфй хендлер
public abstract class Handler {

    // все так же прячем следующий элемент
    private Handler successor;

    // все так же сетаем его из клиента
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    // все тот же template method (public final, помнишь?)
    public final void handleRequest(Request request) {
        // если текущий может обработать
        if (canHandle(request)) {
            // пусть сделает это!
            handle(request);
        } else {
            // если есть еще обработчик
            if (successor != null) {
                // отдаем запрос ему
                successor.handleRequest(request);
            }
        }
    }
    // правда проще стало?

    // а клиенты пусть реализуют обработчик
    // (заметь тут boolean уже нету)
    protected abstract void handle(Request request);

    // и сами решают, можгут ли они обработать этот запрос
    protected abstract boolean canHandle(Request request);
}