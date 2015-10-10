package designPatterns.chainOfResponsibility.classic.case1;

// обработчик специализирующийся на Boolean
public class ConcreteHandlerA extends Handler  {

    @Override
    public void handleRequest(Request request){
        if (request.getMessage() instanceof Boolean) {
            System.out.printf("Request %s processed by ConcreteHandlerA\n", request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}