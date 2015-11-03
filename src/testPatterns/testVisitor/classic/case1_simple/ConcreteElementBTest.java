package testPatterns.testVisitor.classic.case1_simple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConcreteElementBTest {

    @Test
    public void testGetFromConstructor() {
        // given
        ConcreteElementB element = new ConcreteElementB(13);

        // when
        int actual = element.getSomething();

        // then
        assertEquals(13, actual);
    }

    @Test
    public void testChangeSetter() {
        // given
        ConcreteElementB element = new ConcreteElementB(13);

        // when
        element.setSomething(24);

        // then
        int actual = element.getSomething();
        assertEquals(24, actual);
    }

    @Test
    public void testAccept() {
        // given
        ConcreteElementB element = new ConcreteElementB(13);
        Visitor visitor = mock(Visitor.class);

        // when
        element.accept(visitor);

        // then
        verify(visitor).visit(element);
    }
}