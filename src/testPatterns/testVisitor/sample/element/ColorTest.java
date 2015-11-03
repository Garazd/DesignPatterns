package testPatterns.testVisitor.sample.element;

import designPatterns.visitor.sample.element.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ColorTest {

    @Test
    public void testNext() {
        assertEquals(Color.GREEN, Color.RED.next());
        assertEquals(Color.BLUE, Color.GREEN.next());
        assertEquals(Color.YELLOW, Color.BLUE.next());
        assertEquals(Color.RED, Color.YELLOW.next());
    }
}