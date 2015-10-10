package designPatterns.chainOfResponsibility.classic.case2;

// а этот у нас эксперт по Integer
public class ConcreteHandlerC extends Handler {

    @Override
    protected boolean handle(Request request){
        // TODO вот не нравится мне этот дублирующийся везде canProcess
        // есть идеи?
        boolean canProcess = request.getMessage() instanceof Integer;
        if (canProcess) {
            System.out.printf("Request %s processed by ConcreteHandlerC\n", request);
        }
        return canProcess;
    }
}