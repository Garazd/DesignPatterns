package designPatterns.chainOfResponsibility.classic.case4;

// риквест подозрительно консервативен!
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