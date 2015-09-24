package testPatterns.testAdapter.adapter2;

import designPatterns.adapter.adapter2.Adapter;
import designPatterns.adapter.adapter2.Target;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdapterTest {
    @Test
    public void test() {
        // given
        Target target = new Adapter();

        // when
        Object actual = target.request("data");

        // then
        assertEquals("Hello from Adaptee!", actual);
    }
}