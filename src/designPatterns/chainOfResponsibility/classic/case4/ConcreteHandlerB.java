package designPatterns.chainOfResponsibility.classic.case4;

public class ConcreteHandlerB implements Handler {

    @Override
    public boolean canHandle(Request request) {
        return request.getMessage() instanceof String;
    }

    @Override
    public void handle(Request request){
        System.out.printf("Request %s processed by ConcreteHandlerB\n", request);
    }
}