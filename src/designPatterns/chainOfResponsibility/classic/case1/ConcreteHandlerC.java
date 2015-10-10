package designPatterns.chainOfResponsibility.classic.case1;

// обработчик специализирующийся на Integer
public class ConcreteHandlerC extends Handler  {

    @Override
    public void handleRequest(Request request){
        if (request.getMessage() instanceof Integer) {
            System.out.printf("Request %s processed by ConcreteHandlerC\n", request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}