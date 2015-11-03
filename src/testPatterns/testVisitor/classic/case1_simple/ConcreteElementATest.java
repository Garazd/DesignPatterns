package testPatterns.testVisitor.classic.case1_simple;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConcreteElementATest {

    @Test
    public void testGetFromConstructor() {
        // given
        ConcreteElementA element = new ConcreteElementA("qwe");

        // when
        String actual = element.getSomething();

        // then
        assertEquals("qwe", actual);
    }

    @Test
    public void testChangeSetter() {
        // given
        ConcreteElementA element = new ConcreteElementA("qwe");

        // when
        element.setSomething("asd");

        // then
        String actual = element.getSomething();
        assertEquals("asd", actual);
    }

    @Test
    public void testAccept() {
        // given
        ConcreteElementA element = new ConcreteElementA("qwe");
        Visitor visitor = mock(Visitor.class);

        // when
        element.accept(visitor);

        // then
        verify(visitor).visit(element);
    }
}