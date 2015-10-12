package testPatterns.testChainOfResponsibility.classic.case3;

import designPatterns.chainOfResponsibility.classic.case3.ConcreteHandlerA;
import designPatterns.chainOfResponsibility.classic.case3.Handler;
import designPatterns.chainOfResponsibility.classic.case3.Request;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// применил template method
public class ConcreteHandlerATest extends ConcreteHandlerTest {

    // указываем что тестировать
    @Override
    protected Handler getHandler() {
        return new ConcreteHandlerA();
    }

    // а дальше как тестировать
    @Test
    public void shouldProcess_whenBoolean() {
        // тут у нас уже все настроено в методе setup() родителя

        // when
        // отправляем Boolean (наш) запрос
        handler.handleRequest(new Request(Boolean.FALSE));

        // then
        // видим что сигнал не пошел дальше
        assertNull(processed);

        // и при этом напечаталось в консоли
        Assert.assertEquals("Request Boolean:false processed by ConcreteHandlerA\n", out.toString());
    }

    @Test
    public void shouldDelegateProcessing_whenNotBoolean() {

        // when
        // отправляем String (не наш) запрос
        handler.handleRequest(new Request(new String("request")));

        // then
        // запрос пошел дальше
        assertEquals("request", processed.getMessage());

        // а консоль пуста
        Assert.assertEquals("", out.toString());
    }
}