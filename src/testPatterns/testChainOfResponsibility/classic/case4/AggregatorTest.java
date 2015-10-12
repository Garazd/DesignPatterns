package testPatterns.testChainOfResponsibility.classic.case4;

import designPatterns.chainOfResponsibility.classic.case4.Aggregator;
import designPatterns.chainOfResponsibility.classic.case4.Handler;
import designPatterns.chainOfResponsibility.classic.case4.Request;
import org.junit.Test;

import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertNull;

// Handler тестить не надо - это интерфейс, а вот агрегатор наш...
public class AggregatorTest {

    // тут будем хранить те риквесты, что дойдут до обработчиков
    // если дойдут конечно :)
    private Request processedByOne = null;
    private Request processedByAnother = null;

    @Test
    public void shouldSendRequestToNextAccessor_whenFirstCantProcess() {
        // given
        // наш первый обработчик
        Handler handler = new Handler() {
            @Override
            public boolean canHandle(Request request) {
                // сам ничего не обрабатывает
                return false;
            }

            @Override
            public void handle(Request request) {
                // по идее этого не должно случиться никогда
                processedByOne = request;
            }
        };

        // первый пусть пойдет через конструктор
        Aggregator aggregator = new Aggregator(handler);

        // его второй обработчик через метод add
        aggregator.addSuccessor(new Handler() {
            @Override
            public boolean canHandle(Request request) {
                // а этот уже может обработать
                return true;
            }
            
            @Override
            public void handle(Request request) {
                // сохранит риквест в поле
                processedByAnother = request;
            }
        });

        // наш риквест
        Request givenRequest = new Request("request");

        // when
        // послели по цепочке
        // обрати внимание мы передаем запрос агрегатору!
        aggregator.handle(givenRequest);

        // then
        // проверили, что риквест дошел до второго
        assertSame(givenRequest, processedByAnother);

        // а до первого нет
        assertNull(processedByOne);
    }

    @Test
    public void shouldNotSendRequestToNextAccessor_whenFirstCanProcess() {
        // given
        // наш первый обработчик
        Handler handler = new Handler() {
            @Override
            public boolean canHandle(Request request) {
                // а теперь он умеет обрабатывать
                return true;
            }

            @Override
            public void handle(Request request) {
                // и это наверняка случится
                processedByOne = request;
            }
        };

        // первый пусть пойдет через конструктор
        Aggregator aggregator = new Aggregator(handler);

        // его второй обработчик через метод add
        aggregator.addSuccessor(new Handler() {
            @Override
            public boolean canHandle(Request request) {
                // а этот тоже может обработать
                return true;
            }

            @Override
            public void handle(Request request) {
                // и даже сохранит риквест в поле
                // но до него не суждено очереди дойти
                processedByAnother = request;
            }
        });

        // наш риквест
        Request givenRequest = new Request("request");

        // when
        // послели по цепочке
        handler.handle(givenRequest);

        // then
        // проверили, что риквест дошел до первого
        assertSame(givenRequest, processedByOne);

        // а до второго нет
        assertNull(processedByAnother);
    }
}