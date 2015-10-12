package testPatterns.testChainOfResponsibility.classic.case4;

import designPatterns.chainOfResponsibility.classic.case4.Handler;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class ConcreteHandlerTest {

    // так как один из обработчиков печатает нагло в консоль, мы ее замокаем
    // для этого нам потребуется этот малый
    protected ByteArrayOutputStream out = new ByteArrayOutputStream();

    // тут наш главный тестируемый обработчик
    protected Handler handler;

    @Before
    public void setup() {
        // переопределяем консоль
        System.setOut(new PrintStream(out));

        // given
        // создаем тестируемый обработчик
        handler = getHandler();
    }

    // помнишь зачем этот метод в template method шаблоне?
    protected abstract Handler getHandler();
}