package testPatterns.testDecorator;

import designPatterns.decorator.classic.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DecoratorTest {

    @Test
    public void testDecorator() {
        // given
        Component component = mock(Component.class);
        Component decorator = new Decorator(component) {
        };
        when(component.operation(anyString())).thenReturn("from_component");

        // when
        Object actual = decorator.operation("data");

        // then
        assertEquals("from_component", actual);
        verify(component).operation("data");
    }

    @Test
    public void testConcreteComponent() {
        // given
        Component component = new ConcreteComponent();

        // when
        Object actual = component.operation("data");

        // then
        assertEquals("data", actual);
    }

    @Test
    public void testConcreteDecoratorA() {
        // given
        Component component = mock(Component.class);
        Component decorator = new ConcreteDecoratorA(component, "state");
        when(component.operation(anyString())).thenReturn("from_component");

        // when
        Object actual = decorator.operation("data");

        // then
        assertEquals("[before]from_component[after]", actual);
        verify(component).operation("data state");
    }

    @Test
    public void testConcreteDecoratorB() {
        // given
        Component component = mock(Component.class);
        Component decorator = new ConcreteDecoratorB(component);
        when(component.operation(anyString())).thenReturn("from_component");

        // when
        Object actual = decorator.operation("data");

        // then
        assertEquals("[before]FROM_COMPONENT[after]", actual);
        verify(component).operation("data");
    }
}