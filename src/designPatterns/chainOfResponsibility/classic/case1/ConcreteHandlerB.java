package designPatterns.chainOfResponsibility.classic.case1;

// обработчик специализирующийся на String
public class ConcreteHandlerB extends Handler  {

    @Override
    public void handleRequest(Request request){
        if (request.getMessage() instanceof String) {
            System.out.printf("Request %s processed by ConcreteHandlerB\n", request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}