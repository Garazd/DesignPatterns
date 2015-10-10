package designPatterns.chainOfResponsibility.classic.case4;

public class ConcreteHandlerC implements Handler {

    @Override
    public boolean canHandle(Request request) {
        return request.getMessage() instanceof Integer;
    }

    @Override
    public void handle(Request request){
        System.out.printf("Request %s processed by ConcreteHandlerC\n", request);
    }
}