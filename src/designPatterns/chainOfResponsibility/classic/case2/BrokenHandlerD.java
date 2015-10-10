package designPatterns.chainOfResponsibility.classic.case2;

// вот наш ленивый Character-друг из прошлой серии
public class BrokenHandlerD extends Handler {

    @Override
    protected boolean handle(Request request){
        if (request.getMessage() instanceof Character) {
            System.out.printf("Request %s processed by BrokenHandlerD\n", request);
        }
        // теперь-nj он не забудет!
        // клиенту надо вернуть boolean в любом случае (ибо компилятор!),
        // а раз так - он задумается
        // этого старого кода уже не надо
        // else if (successor != null) {
        //     successor.handleRequest(request);
        // }
        return true; // or return false TODO think about it :)
    }
}