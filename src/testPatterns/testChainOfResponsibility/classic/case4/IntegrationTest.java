package testPatterns.testChainOfResponsibility.classic.case4;

import designPatterns.chainOfResponsibility.classic.case4.*;
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
        Aggregator aggregator = new Aggregator();
        aggregator.addSuccessor(h1);
        aggregator.addSuccessor(h2);
        aggregator.addSuccessor(h3);
        // а ведь можно было и так
        // Aggregator aggregator = new Aggregator(h1, h2, h3);

        // when
        // пошли обрабатывать
        aggregator.handle(new Request("qwe"));
        aggregator.handle(new Request(true));
        aggregator.handle(new Request(15));

        // then
        assertEquals("Request String:qwe processed by ConcreteHandlerB\n" +
                "Request Boolean:true processed by ConcreteHandlerA\n" +
                "Request Integer:15 processed by ConcreteHandlerC\n",
                out.toString());
    }
}