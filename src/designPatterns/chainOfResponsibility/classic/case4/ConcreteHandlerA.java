package designPatterns.chainOfResponsibility.classic.case4;

// теперь тут не extends, а implements
// помнишь я говорил, что можно заменить наследование интерфейсами?
// обычно это приводит к изменению шаблона :)
// нам хорошо, потому как их так легче запомнить
// TemplateMethod <-> Strategy
// ChainOfResponsibility <-> ChainOfCommand
// Это у нас команда - класс инкапсулирующий в себе логику "чё делать"
// А Aggregator - это цепочка команд
// нет четкой грани между шаблонами, они если не перетекают то дополняют друг друга!
public class ConcreteHandlerA implements Handler {

    // могулия?..
    // омнолия?..
    // о! магнолия!
    @Override
    public boolean canHandle(Request request) {
        return request.getMessage() instanceof Boolean;
    }

    // а тут алгоритм "чё делать"
    @Override
    public void handle(Request request){
        System.out.printf("Request %s processed by ConcreteHandlerA\n", request);
    }
}