package testPatterns.testVisitor.classic.case2_withAbstraction;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConcreteElementB1ChildTest {

    @Test
    public void testAccept() {
        // given
        ConcreteElementB1Child element = new ConcreteElementB1Child();
        Visitor visitor = mock(Visitor.class);

        // when
        element.accept(visitor);

        // then
        verify(visitor).visit(element);
    }
}