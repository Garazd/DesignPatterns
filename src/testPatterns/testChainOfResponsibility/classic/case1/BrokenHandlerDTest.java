package testPatterns.testChainOfResponsibility.classic.case1;

import designPatterns.chainOfResponsibility.classic.case1.BrokenHandlerD;
import designPatterns.chainOfResponsibility.classic.case1.Handler;
import designPatterns.chainOfResponsibility.classic.case1.Request;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// тут все так же как и в ConcreteHandlerATest
// ну почти... там жеж бага была
public class BrokenHandlerDTest {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    private Request processed;

    private Handler handler;

    @Before
    public void setup() {
        System.setOut(new PrintStream(out));

        // given
        // отличия только тут ведь и в тестах
        handler = new BrokenHandlerD();

        handler.setSuccessor(new Handler() {
            @Override
            public void handleRequest(Request request) {
                processed = request;
            }
        });
    }

    @Test
    public void shouldProcess_whenCharacter() {
        // when
        // отправляем Character (наш) запрос
        handler.handleRequest(new Request(new Character('!')));

        // then
        // видим что сигнал не пошел дальше
        assertNull(processed);

        // и при этом напечаталось в консоли
        assertEquals("Request Character:! processed by BrokenHandlerD\n", out.toString());
    }

    @Test
    public void shouldDelegateProcessing_whenNotCharacter() {
        // тут у нас уже все настроено в методе setup()

        // when
        // отправляем String (не наш) запрос
        handler.handleRequest(new Request(new String("!")));

        // then
        // запрос не пошел дальше, а должен был
        // assertEquals("!", processed.getMessage()); TODO исправить!
        assertNull(processed);

        // а консоль пуста
        assertEquals("", out.toString());
    }
}