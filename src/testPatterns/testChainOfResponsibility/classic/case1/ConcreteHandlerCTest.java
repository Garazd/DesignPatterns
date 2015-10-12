package testPatterns.testChainOfResponsibility.classic.case1;

import designPatterns.chainOfResponsibility.classic.case1.ConcreteHandlerC;
import designPatterns.chainOfResponsibility.classic.case1.Handler;
import designPatterns.chainOfResponsibility.classic.case1.Request;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// тут все так же как и в ConcreteHandlerATest
public class ConcreteHandlerCTest {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    private Request processed;

    private Handler handler;

    @Before
    public void setup() {
        System.setOut(new PrintStream(out));

        // given
        // отличия только тут ведь и в тестах
        handler = new ConcreteHandlerC();

        handler.setSuccessor(new Handler() {
            @Override
            public void handleRequest(Request request) {
                processed = request;
            }
        });
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