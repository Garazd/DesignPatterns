package testPatterns.testChainOfResponsibility.classic.case2;

import designPatterns.chainOfResponsibility.classic.case2.Handler;
import designPatterns.chainOfResponsibility.classic.case2.Request;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static junit.framework.TestCase.assertSame;

public class HandlerTest {

    // тут будем хранить те риквесты, что дойдут до обработчиков
    // если дойдут конечно :)
    private Request processedByOne = null;
    private Request processedByAnother = null;

    @Test
    public void shouldSendRequestToAccessor_whenNotProcessing() {
        // given
        // наш первый обработчик
        Handler handler = new Handler() {
            @Override
            protected boolean handle(Request request) {
                // смотрим, что риквест дошел
                processedByOne = request;

                // но текущий обработчик настроен передать все следующему
                return false;
            }
        };

        // его второй обработчик
        handler.setSuccessor(new Handler() {
            @Override
            public boolean handle(Request request) {
                // сохранит риквест в поле
                processedByAnother = request;

                // и оборвет цепочку
                return true;
            }
        });

        // наш риквест
        Request givenRequest = new Request("request");

        // when
        // послели по цепочке
        handler.handleRequest(givenRequest);

        // then
        // проверили, что риквест дошел до первого и второго
        assertSame(givenRequest, processedByOne);
        assertSame(givenRequest, processedByAnother);
    }

    @Test
    public void shouldNotSendRequestToAccessor_whenProcessing() {
        // given
        // наш первый обработчик
        Handler handler = new Handler() {
            @Override
            protected boolean handle(Request request) {
                // смотрим, что риквест дошел
                processedByOne = request;

                // но текущий обработчик сказал что сам все порешал
                return true;
            }
        };

        // его второй обработчик
        handler.setSuccessor(new Handler() {
            @Override
            public boolean handle(Request request) {
                // сохранит риквест в поле
                processedByAnother = request;

                // если дойдем сюда то оборвем цепочку
                return true;
            }
        });

        // наш риквест
        Request givenRequest = new Request("request");

        // when
        // послели по цепочке
        handler.handleRequest(givenRequest);

        // then
        // проверили, что риквест дошел до первого
        assertSame(givenRequest, processedByOne);

        // а до второго нет
        assertNull(processedByAnother);
    }
}