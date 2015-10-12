package testPatterns.testChainOfResponsibility.classic.case1;

import designPatterns.chainOfResponsibility.classic.case1.ConcreteHandlerB;
import designPatterns.chainOfResponsibility.classic.case1.Handler;
import designPatterns.chainOfResponsibility.classic.case1.Request;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// тут все так же как и в ConcreteHandlerATest
// (прям в абстрактный класс выноси)
// на домашку тебе, примени тут TemplateMethod для setup() и все общее унеси в абстрактный класс
public class ConcreteHandlerBTest {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    private Request processed;

    private Handler handler;

    @Before
    public void setup() {
        System.setOut(new PrintStream(out));

        // given
        // отличия только тут ведь а все остальное (кроме самих тестов) одинаков
        handler = new ConcreteHandlerB();

        handler.setSuccessor(new Handler() {
            @Override
            public void handleRequest(Request request) {
                processed = request;
            }
        });
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