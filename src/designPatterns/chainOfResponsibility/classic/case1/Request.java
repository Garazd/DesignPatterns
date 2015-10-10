package designPatterns.chainOfResponsibility.classic.case1;

// Просто объект обертка
// вообще, мы могли посылать "по проводам" сразу Object, но так прикольнее
public class Request {
    private Object message;

    public Request(Object message) {
        this.message = message;
    }

    public Object getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message.getClass().getSimpleName() + ":" + message;
    }
}