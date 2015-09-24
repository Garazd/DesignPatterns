package testPatterns.testAdapter.adapter1;

import designPatterns.adapter.adapter1.Adaptee;
import designPatterns.adapter.adapter1.Adapter;
import designPatterns.adapter.adapter1.Target;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class AdapterTest {
    @Test
    public void test() {
        // given
        Adaptee adaptee = mock(Adaptee.class);
        when(adaptee.specificRequest(anyObject())).thenReturn("data from adaptee");

        Target target = new Adapter(adaptee);

        // when
        Object actual = target.request("data");

        // then
        assertEquals("data from adaptee", actual);
        verify(adaptee).specificRequest("data");
    }
}