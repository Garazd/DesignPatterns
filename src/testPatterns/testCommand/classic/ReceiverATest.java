package testPatterns.testCommand.classic;

import designPatterns.command.classic.ReceiverA;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReceiverATest {

    // given
    private ReceiverA receiver = new ReceiverA();

    @Test
    public void testMethod1() {
        // when then
        assertEquals("Processed by ReceiverA in method 1: data1",
                receiver.method1("data1"));
    }

    @Test
    public void testMethod2() {
        // when then
        assertEquals("Processed by ReceiverA in method 2: data2",
                receiver.method2("data2"));

    }
}