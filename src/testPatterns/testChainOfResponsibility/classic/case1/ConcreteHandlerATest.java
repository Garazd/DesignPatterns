package testPatterns.testChainOfResponsibility.classic.case1;

import designPatterns.chainOfResponsibility.classic.case1.ConcreteHandlerA;
import designPatterns.chainOfResponsibility.classic.case1.Handler;
import designPatterns.chainOfResponsibility.classic.case1.Request;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

// тут чуть сложнее
public class ConcreteHandlerATest {

    // так как один из обработчиков печатает нагло в консоль, мы ее замокаем
    // для этого нам потребуется этот малый
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    // тут мы будем хранить запрос, который дошел до второго обработчика
    private Request processed;

    // тут наш главный тестируемый обработчик
    private Handler handler;

    @Before
    public void setup() {
        // переопределяем консоль
        System.setOut(new PrintStream(out));

        // given
        // создаем тестируемый обработчик
        handler = new ConcreteHandlerA();

        // ставим для него следующий фейковый обработчик в очередь
        handler.setSuccessor(new Handler() {
            @Override
            public void handleRequest(Request request) {
                // он просто сохранит то, что ему передали
                processed = request;
            }
        });
    }

    @Test
    public void shouldProcess_whenBoolean() {
        // тут у нас уже все настроено в методе setup()

        // when
        // отправляем Boolean (наш) запрос
        handler.handleRequest(new Request(Boolean.FALSE));

        // then
        // видим что сигнал не пошел дальше
        assertNull(processed);

        // и при этом напечаталось в консоли
        assertEquals("Request Boolean:false processed by ConcreteHandlerA\n", out.toString());
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
        assertEquals("", out.toString());
    }
}