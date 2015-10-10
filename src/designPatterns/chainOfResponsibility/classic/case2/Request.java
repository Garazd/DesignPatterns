package designPatterns.chainOfResponsibility.classic.case2;

// тут тоже без изменений
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