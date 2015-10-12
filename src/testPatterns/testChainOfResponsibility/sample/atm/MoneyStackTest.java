package testPatterns.testChainOfResponsibility.sample.atm;

import designPatterns.chainOfResponsibility.sample.atm.MoneyStack;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MoneyStackTest {

    // так как весь вывод в консоль, мы ее замокаем
    // для этого нам потребуется этот малый
    private ByteArrayOutputStream out = new ByteArrayOutputStream();

    // наш подопытный
    private MoneyStack moneyStack;

    // будем считать долги :)
    private int debt = 0;

    // общее для всех тестов в setup!
    @Before
    public void setup() {
        // переопределяем консоль
        System.setOut(new PrintStream(out));

        // given
        // тестируемый класс
        moneyStack = new MoneyStack(100);

        // а сюда подставим застабленный класс
        moneyStack.setNextStack(new MoneyStack(0) {
            // в нем переопределен метод который сохраняет остаток нам в поле
            @Override
            public void withdraw(int amount) {
                debt = amount;
            }
        });
    }

    @Test
    public void testWithDebt() {
        // when
        moneyStack.withdraw(250);

        // then

        // двапосто
        assertEquals("2 x $100\r\n", out.toString());

        // и пятдесят на сдачу
        assertEquals(50, debt);
    }

    @Test
    public void testWithoutDebt() {
        // when
        moneyStack.withdraw(300);

        // then
        // трипосто
        assertEquals("3 x $100\r\n", out.toString());

        // без сдачи
        assertEquals(0, debt);
    }
}