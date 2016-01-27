package testPatterns.testComposite.classic.case2;

import designPatterns.composite.classic.case2.Component;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class ComponentTest {

    private static class MyComponent extends Component {

        @Override
        public String operation1(String data) {
            return data;
        }

        @Override
        public String operation2(String data) {
            return data;
        }
    }

    @Test
    public void testNoChildren() {
        // given
        Component composite = new MyComponent();

        // when then
        assertEquals(0, composite.count());
    }

    @Test
    public void testOneLeaf() {
        // given
        Component composite = new MyComponent();
        Component component = mock(Component.class);

        // when
        composite.add(component);

        // then
        assertEquals(0, composite.count());
    }

    @Test
    public void testThreeLeaf() {
        // given
        Component composite = new MyComponent();
        Component component = mock(Component.class);

        // when
        composite.add(component);
        composite.add(component);
        composite.add(component);

        // then
        assertEquals(0, composite.count());
    }

    @Test
    public void testOneLeaf_operation1() {
        // given
        Component composite = new MyComponent();
        Component component = mock(Component.class);

        composite.add(component);

        when(component.operation1(anyString())).thenReturn("result");

        // when
        String actual = composite.operation1("data");

        // then
        verifyNoMoreInteractions(component);
        assertEquals("data", actual);
    }

    @Test
    public void testOneLeaf_operation2() {
        // given
        Component composite = new MyComponent();
        Component component = mock(Component.class);

        composite.add(component);

        when(component.operation2(anyString())).thenReturn("result");

        // when
        String actual = composite.operation2("data");

        // then
        verifyNoMoreInteractions(component);
        assertEquals("data", actual);
    }

    @Test
    public void testRemoveComponent() {
        // given
        Component composite = new MyComponent();
        Component component = mock(Component.class);

        composite.add(component);

        // when
        composite.remove(component);
    }

    // then
    @Test(expected = UnsupportedOperationException.class)
    public void testGetComponent() {
        // given
        Component composite = new MyComponent();

        // when
        composite.get(0);
    }
}