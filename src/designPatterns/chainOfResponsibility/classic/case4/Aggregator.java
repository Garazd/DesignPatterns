package designPatterns.chainOfResponsibility.classic.case4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// а это уже простой обработчик-агрегатор других обработчиков
// он тоже может быть обработчиком (Handler), что впрочем не обязательно
public final class Aggregator implements Handler {

    // тут мы будем накапливать нашу цепочку
    private List<Handler> successors = new LinkedList<Handler>();

    // можем через конструктор добавить сразу все обработчики
    public Aggregator(Handler... handlers) {
        successors.addAll(Arrays.asList(handlers));
    }

    // или добавляем новый обработчик в хвост цепочки
    public void addSuccessor(Handler successor) {
        successors.add(successor);
    }

    // точка входа
    @Override
    public void handle(Request request) {
        // идем по всей цепочке
        for (Handler handler : successors) {
            // если текущий может обработать
            if (handler.canHandle(request)) {
                // пусть сделает это!
                handler.handle(request);

                // хотим ли мы передавать дальше уже обработанный сигнал по цепочке?
                // break;
            }
        }
    }

    // так как агрегатор - тоже обработчик
    // то он может обработать запрос, если есть хоть один обработчик
    @Override
    public boolean canHandle(Request request) {
        return !successors.isEmpty();
    }

    // вау! так мы можем строить деревья обработчиков
    // да, можешь придумать задачку где такое пригодится...

    // помнишь тут были два абстрактных метода? Куда они делись?
    // идем в интерфейс Handler
}