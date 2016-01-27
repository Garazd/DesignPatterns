package testPatterns.testComposite.windows;

import designPatterns.composite.sample.windows.StringMessage;
import designPatterns.composite.sample.windows.Window;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringMessageTest {

    @Test
    public void testDraw() {
        // given
        Window window = new StringMessage("message");

        // when
        String draw = window.draw();

        // then
        assertEquals(
                "┌───────┐\n" +
                "│message│\n" +
                "└───────┘\n", draw);
    }

    @Test
    public void testSize() {
        // given
        Window window = new StringMessage("message");

        // when then
        assertEquals(9, window.width());
        assertEquals(3, window.height());
    }
}