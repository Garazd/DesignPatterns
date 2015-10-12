package testPatterns.testChainOfResponsibility.classic.case4;

import designPatterns.chainOfResponsibility.classic.case4.ConcreteHandlerA;
import designPatterns.chainOfResponsibility.classic.case4.Handler;
import designPatterns.chainOfResponsibility.classic.case4.Request;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConcreteHandlerATest extends ConcreteHandlerTest {

    @Override
    protected Handler getHandler() {
        return new ConcreteHandlerA();
    }

    @Test
    public void shouldCanProcess_whenBoolean() {
        // given
        // Boolean (наш) запрос
        Request request = new Request(Boolean.FALSE);

        // when then
        // мы его можем обработать
        assertTrue(handler.canHandle(request));
    }

    @Test
    public void shouldProcess_whenBoolean() {
        // given
        // Boolean (наш) запрос
        Request request = new Request(Boolean.FALSE);

        // when
        // отправляем
        handler.handle(request);

        // и при этом напечаталось в консоли
        assertEquals("Request Boolean:false processed by ConcreteHandlerA\n", out.toString());
    }

    @Test
    public void shouldDelegateProcessing_whenNotBoolean() {
        // given
        // String (не наш) запрос
        Request request = new Request(new Request(new String("request")));

        // when then
        // запрос не может быть обработан
        assertFalse(handler.canHandle(request));

        // дальше ничего больше нет смысла тестить
    }
}