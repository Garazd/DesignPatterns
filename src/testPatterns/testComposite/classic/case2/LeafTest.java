package testPatterns.testComposite.classic.case2;

import designPatterns.composite.classic.case2.Component;
import designPatterns.composite.classic.case2.Leaf;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeafTest {

    @Test
    public void testOperation1() {
        // given
        Component component = new Leaf("id");

        // when
        String actual = component.operation1("data");

        // then
        assertEquals("id.op1(data)", actual);
    }

    @Test
    public void testOperation2() {
        // given
        Component component = new Leaf("id");

        // when
        String actual = component.operation2("data");

        // then
        assertEquals("id.op2(data)", actual);
    }
}