package testPatterns.testVisitor.classic.case2_withAbstraction;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConcreteElementB2Test {

    @Test
    public void testAccept() {
        // given
        ConcreteElementB2 element = new ConcreteElementB2();
        Visitor visitor = mock(Visitor.class);

        // when
        element.accept(visitor);

        // then
        verify(visitor).visit(element);
    }
}