package testPatterns.testVisitor.classic.case2_withAbstraction;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConcreteElementB2ChildTest {

    @Test
    public void testAccept() {
        // given
        ConcreteElementB2Child element = new ConcreteElementB2Child();
        Visitor visitor = mock(Visitor.class);

        // when
        element.accept(visitor);

        // then
        verify(visitor).visit(element);
    }
}