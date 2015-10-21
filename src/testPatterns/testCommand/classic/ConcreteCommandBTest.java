package testPatterns.testCommand.classic;

import designPatterns.command.classic.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ConcreteCommandBTest {

    private Object processed;

    @Test
    public void shouldCallReceiver() {
        // given

        // создаем фейковый приемник-зонд, который сохраняет в поля то,
        // что ему передали
        ReceiverB receiver = new ReceiverB() {
            @Override
            public void otherMethod(Object input) {
                processed = input;
            }
        };

        // наш подопытная команда
        Command command = new ConcreteCommandB(receiver);

        // when
        // вызов тестового метода команды
        Object result = command.execute("data");

        // then
        // проверили что вернула команда
        assertEquals("CommandB result", result);

        // + до приемника дошел сигнал из command
        assertEquals("data", processed);
    }

    @Test
    public void shouldCallReceiver_mockitoCase() {
        // given

        // создаем мок приемника
        ReceiverA receiver = mock(ReceiverA.class);

        // наш подопытная команда
        ConcreteCommandA command = new ConcreteCommandA(receiver);

        // вот что веррнет приемник
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