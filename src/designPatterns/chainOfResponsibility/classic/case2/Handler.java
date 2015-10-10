package designPatterns.chainOfResponsibility.classic.case2;

// а вот тут немного поменяли логику, теперь эта абстрактная половинка обработчика
// взяла на себя ответственность за передачу сигнала дальше
public abstract class Handler {

    // тут следующий элемент
    // и мы его прячем, не открывая наследникам
    private Handler successor;

    // это сеттер, как обычно
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    // наружу выглядывает такой себе template method (public final, помнишь?)
    // в нем вся логика делегирования
    public final void handleRequest(Request request) {
        // если запрос текущим не обработан и есть еще обработчик
        if (!handle(request) && successor != null) {
            // отдаем запрос ему
            successor.handleRequest(request);
        }
    }

    // а клиенты пусть реализуют обработчик
    // который возвращает boolean
    // в котором обработчик решает передавать ли сигнал дальше
    protected abstract boolean handle(Request request);
}