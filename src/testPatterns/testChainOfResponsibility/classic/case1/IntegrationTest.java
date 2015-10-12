package testPatterns.testChainOfResponsibility.classic.case1;

import designPatterns.chainOfResponsibility.classic.case1.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {

    // так как один из обработчиков печатает нагло в консоль, мы ее замокаем
    // для этого нам потребуется этот малый
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void setup() {
        // переопределяем консоль
        System.setOut(new PrintStream(out));
    }

    @Test
    public void test() {
        // given
        // создали обработчики
        Handler h1 = new ConcreteHandlerA();
        Handler h2 = new ConcreteHandlerB();
        Handler h3 = new ConcreteHandlerC();

        // настроили их в очередь
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        // when
        // пошли обрабатывать
        h1.handleRequest(new Request("qwe"));
        h1.handleRequest(new Request(true));
        h1.handleRequest(new Request(15));

        // then
        assertEquals("Request String:qwe processed by ConcreteHandlerB\n" +
                "Request Boolean:true processed by ConcreteHandlerA\n" +
                "Request Integer:15 processed by ConcreteHandlerC\n",
                out.toString());
    }
}