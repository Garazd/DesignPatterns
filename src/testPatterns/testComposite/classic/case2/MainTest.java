package testPatterns.testComposite.classic.case2;

import designPatterns.composite.classic.case2.Main;
import org.junit.Test;
import testPatterns.testComposite.ConsoleMock;
import static org.junit.Assert.assertEquals;

public class MainTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void test() {
        // given when
        Main.main(new String[0]);

        // when
        assertEquals(
                "[one.op1(data1), [two.op1(data1), three.op1(data1), five.op1(data1), [eight.op1(data1)]], four.op1(data1), [six.op1(data1), seven.op1(data1)]]\n" +
                "[one.op2(data2), [two.op2(data2), three.op2(data2), five.op2(data2), [eight.op2(data2)]], four.op2(data2), [six.op2(data2), seven.op2(data2)]]\n" +
                "three.op1(data3)\n",
                console.getOut());
    }
}