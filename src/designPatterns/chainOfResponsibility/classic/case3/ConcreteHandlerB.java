package designPatterns.chainOfResponsibility.classic.case3;

public class ConcreteHandlerB extends Handler {

    @Override
    protected boolean canHandle(Request request) {
        return request.getMessage() instanceof String;
    }

    @Override
    protected void handle(Request request){
        System.out.printf("Request %s processed by ConcreteHandlerB\n", request);
    }
}