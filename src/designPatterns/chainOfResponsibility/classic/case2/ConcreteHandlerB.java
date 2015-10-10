package designPatterns.chainOfResponsibility.classic.case2;

// этот у нас эксперт по String
public class ConcreteHandlerB extends Handler {

    @Override
    protected boolean handle(Request request){
        boolean canProcess = request.getMessage() instanceof String;
        if (canProcess) {
            System.out.printf("Request %s processed by ConcreteHandlerB\n", request);
        }
        return canProcess;
    }
}