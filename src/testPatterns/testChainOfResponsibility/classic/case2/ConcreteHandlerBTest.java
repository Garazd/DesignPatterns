package testPatterns.testChainOfResponsibility.classic.case2;

import designPatterns.chainOfResponsibility.classic.case2.ConcreteHandlerB;
import designPatterns.chainOfResponsibility.classic.case2.Handler;
import designPatterns.chainOfResponsibility.classic.case2.Request;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ConcreteHandlerBTest extends ConcreteHandlerTest {

    @Override
    protected Handler getHandler() {
        return new ConcreteHandlerB();
    }

    @Test
    public void shouldProcess_whenString() {
        // when
        // отправляем String (наш) запрос
        handler.handleRequest(new Request(new String("request")));

        // then
        // видим что сигнал не пошел дальше
        assertNull(processed);

        // и при этом напечаталось в консоли
        assertEquals("Request String:request processed by ConcreteHandlerB\n", out.toString());
    }

    @Test
    public void shouldDelegateProcessing_whenNotString() {
        // тут у нас уже все настроено в методе setup()

        // when
        // отправляем Integer (не наш) запрос
        handler.handleRequest(new Request(new Integer(24)));

        // then
        // запрос пошел дальше
        assertEquals(24, processed.getMessage());

        // а консоль пуста
        assertEquals("", out.toString());
    }
}