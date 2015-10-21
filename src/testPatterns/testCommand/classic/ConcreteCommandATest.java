package testPatterns.testCommand.classic;

import designPatterns.command.classic.Command;
import designPatterns.command.classic.ConcreteCommandA;
import designPatterns.command.classic.ReceiverA;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ConcreteCommandATest {

    private Object processed;
    private Object returned;

    @Test
    public void shouldCallReceiver() {
        // given

        // создаем фейковый приемник-зонд, который сохраняет в поля то,
        // что ему передали и возвращает то, что мы захотим.
        ReceiverA receiver = new ReceiverA() {
            @Override
            public Object method1(Object input) {
                processed = input;
                return returned;
            }

            @Override
            public Object method2(Object input) {
                throw new IllegalStateException("Не должно было вызываться!");
            }
        };

        // наш подопытная команда
        Command command = new ConcreteCommandA(receiver);

        // вот что вернет приемник
        returned = "returned";

        // when
        // вызов тестового метода команды
        Object result = command.execute("data");

        // then
        // проверили что команда вернула то, что ей передал приемник
        assertEquals("returned", result);

        // + до приемника дошел сигнал из команды
        assertEquals("data", processed);
    }

    @Test
    public void shouldCallReceiver_mockitoCase() {
        // given

        // создаем мок приемника
        ReceiverA receiver = mock(ReceiverA.class);

        // наш подопытная команда
        Command command = new ConcreteCommandA(receiver);

        // вот что вернет приемник
        when(receiver.method1(anyString())).thenReturn("returned");

        // when
        // вызов тестового метода команды
        Object result = command.execute("data");

        // then
        // проверили что команда вернула то, что ей передал приемник
        assertEquals("returned", result);

        // + до приемника дошел сигнал из команды
        verify(receiver).method1("data");

        // и больше ничего с рисивером не делали
        verifyNoMoreInteractions(receiver);
    }
}