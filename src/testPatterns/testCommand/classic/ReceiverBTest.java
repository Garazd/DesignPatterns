package testPatterns.testCommand.classic;

import designPatterns.command.classic.ReceiverB;
import org.junit.Test;
import testPatterns.testCommand.ConsoleMock;

import static org.junit.Assert.assertEquals;

public class ReceiverBTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testOtherMethod() {
        // given
        ReceiverB receiver = new ReceiverB();

        // when
        receiver.otherMethod("data");

        // then
        assertEquals("ReceiverB got a: data\r\n",
                console.getOut());
    }
}