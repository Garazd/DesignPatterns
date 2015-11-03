package testPatterns.testVisitor.classic.case2_withAbstraction;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConcreteElementATest {

    @Test
    public void testAccept() {
        // given
        ConcreteElementA element = new ConcreteElementA();
        Visitor visitor = mock(Visitor.class);

        // when
        element.accept(visitor);

        // then
        verify(visitor).visit(element);
    }
}