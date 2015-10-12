package testPatterns.testChainOfResponsibility.classic.case2;

import designPatterns.chainOfResponsibility.classic.case2.ConcreteHandlerC;
import designPatterns.chainOfResponsibility.classic.case2.Handler;
import designPatterns.chainOfResponsibility.classic.case2.Request;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// тут все так же как и в ConcreteHandlerATest
public class ConcreteHandlerCTest extends ConcreteHandlerTest {

    @Override
    protected Handler getHandler() {
        return new ConcreteHandlerC();
    }

    @Test
    public void shouldProcess_whenInteger() {
        // when
        // отправляем Integer (наш) запрос
        handler.handleRequest(new Request(new Integer(24)));

        // then
        // видим что сигнал не пошел дальше
        assertNull(processed);

        // и при этом напечаталось в консоли
        assertEquals("Request Integer:24 processed by ConcreteHandlerC\n", out.toString());
    }

    @Test
    public void shouldDelegateProcessing_whenNotInteger() {
        // тут у нас уже все настроено в методе setup()

        // when
        // отправляем String (не наш) запрос
        handler.handleRequest(new Request(new String("24")));

        // then
        // запрос пошел дальше
        assertEquals("24", processed.getMessage());

        // а консоль пуста
        assertEquals("", out.toString());
    }
}