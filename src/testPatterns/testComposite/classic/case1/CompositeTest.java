package testPatterns.testComposite.classic.case1;

import designPatterns.composite.classic.case1.Component;
import designPatterns.composite.classic.case1.Composite;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class CompositeTest {

    @Test
    public void testNoChildren() {
        // given
        Composite composite = new Composite();

        // when then
        assertEquals(0, composite.count());
    }

    @Test
    public void testOneLeaf() {
        // given
        Composite composite = new Composite();
        Component component = mock(Component.class);

        // when
        composite.add(component);

        // then
        assertEquals(1, composite.count());
    }

    @Test
    public void testThreeLeaf() {
        // given
        Composite composite = new Composite();
        Component component = mock(Component.class);

        // when
        composite.add(component);
        composite.add(component);
        composite.add(component);

        // then
        assertEquals(3, composite.count());
    }

    @Test
    public void testOneLeaf_operation1() {
        // given
        Composite composite = new Composite();
        Component component = mock(Component.class);

        composite.add(component);

        when(component.operation1(anyString())).thenReturn("result");

        // when
        String actual = composite.operation1("data");

        // then
        verify(component).operation1("data");
        assertEquals("[result]", actual);
    }

    @Test
    public void testOneLeaf_operation2() {
        // given
        Composite composite = new Composite();
        Component component = mock(Component.class);

        composite.add(component);

        when(component.operation2(anyString())).thenReturn("result");

        // when
        String actual = composite.operation2("data");

        // then
        verify(component).operation2("data");
        assertEquals("[result]", actual);
    }

    @Test
    public void testSeveralLeafs_operation1() {
        // given
        Composite composite = new Composite();
        Component component1 = mock(Component.class);
        Component component2 = mock(Component.class);
        Component component3 = mock(Component.class);

        composite.add(component1);
        composite.add(component2);
        composite.add(component3);

        when(component1.operation1(anyString())).thenReturn("result1");
        when(component2.operation1(anyString())).thenReturn("result2");
        when(component3.operation1(anyString())).thenReturn("result3");

        // when
        String actual = composite.operation1("data");

        // then
        verify(component1).operation1("data");
        verify(component2).operation1("data");
        verify(component3).operation1("data");
        assertEquals("[result1, result2, result3]", actual);
    }

    @Test
    public void testSeveralLeafs_operation2() {
        // given
        Composite composite = new Composite();
        Component component1 = mock(Component.class);
        Component component2 = mock(Component.class);
        Component component3 = mock(Component.class);

        composite.add(component1);
        composite.add(component2);
        composite.add(component3);

        when(component1.operation2(anyString())).thenReturn("result1");
        when(component2.operation2(anyString())).thenReturn("result2");
        when(component3.operation2(anyString())).thenReturn("result3");

        // when
        String actual = composite.operation2("data");

        // then
        verify(component1).operation2("data");
        verify(component2).operation2("data");
        verify(component3).operation2("data");
        assertEquals("[result1, result2, result3]", actual);
    }

    @Test
    public void testRemoveComponent() {
        // given
        Composite composite = new Composite();
        Component component1 = mock(Component.class);
        Component component2 = mock(Component.class);
        Component component3 = mock(Component.class);

        composite.add(component1);
        composite.add(component2);
        composite.add(component3);

        // when
        composite.remove(component1);

        // then
        assertSame(component2, composite.get(0));
        assertSame(component3, composite.get(1));
    }
}