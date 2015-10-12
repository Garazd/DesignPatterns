package testPatterns.testChainOfResponsibility.classic.case1;

import designPatterns.chainOfResponsibility.classic.case1.Handler;
import designPatterns.chainOfResponsibility.classic.case1.Request;
import org.junit.Test;

import static junit.framework.TestCase.assertSame;

public class HandlerTest {

    // тут будем хранить тот риквест, что дойдет до второго обработчика
    // если дойдет конечно :)
    private Request processed = null;

    @Test
    public void shouldSendRequestToAccessor() {
        // given
        // наш первый обработчик
        Handler handler = new Handler() {
            @Override
            public void handleRequest(Request request) {
                // настроен передать все следующему
                successor.handleRequest(request);
            }
        };

        // его второй обработчик
        handler.setSuccessor(new Handler() {
            @Override
            public void handleRequest(Request request) {
                // сохранит риквест в поле
                processed = request;
            }
        });

        // наш риквест
        Request givenRequest = new Request("request");

        // when
        // послели по цепочке
        handler.handleRequest(givenRequest);

        // then
        // проверили, что риквест дошел
        assertSame(givenRequest, processed);
    }
}