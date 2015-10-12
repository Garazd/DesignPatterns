package testPatterns.testChainOfResponsibility.classic.case0;

import designPatterns.chainOfResponsibility.classic.case0.Handler;
import designPatterns.chainOfResponsibility.classic.case0.Request;
import org.junit.Test;

import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertNull;

public class HandlerTest {

    // тут будем хранить тот риквест, что дойдет до второго обработчика
    // если дойдет конечно :)
    private Request processed = null;

    @Test
    public void shouldSendRequestToAccessor_whenNoProcessing() {
        // given
        // наш первый обработчик
        Handler handler = new Handler(String.class);

        // его второй обработчик
        handler.setSuccessor(new Handler(Class.class) {
            @Override
            public void handleRequest(Request request) {
                // сохранит риквест в поле
                processed = request;
            }
        });

        // наш риквест
        Request givenRequest = new Request(24);

        // when
        // послели по цепочке
        handler.handleRequest(givenRequest);

        // then
        // проверили, что риквест дошел до второго
        assertSame(givenRequest, processed);
    }

    @Test
    public void shouldProcessRequestWithoutSendingToAccessor_whenProcessing() {
        // given
        // наш первый обработчик
        Handler handler = new Handler(String.class);

        // его второй обработчик
        handler.setSuccessor(new Handler(Class.class) {
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
        // проверили, что риквест не дошел до второго
        assertNull(processed);
    }
}