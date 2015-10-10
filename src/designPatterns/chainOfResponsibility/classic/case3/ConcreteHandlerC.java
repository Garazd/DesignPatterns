package designPatterns.chainOfResponsibility.classic.case3;

public class ConcreteHandlerC extends Handler {

    @Override
    protected boolean canHandle(Request request) {
        return request.getMessage() instanceof Integer;
    }

    @Override
    protected void handle(Request request){
        System.out.printf("Request %s processed by ConcreteHandlerC\n", request);
    }
}