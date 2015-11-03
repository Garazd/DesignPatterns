package testPatterns.testVisitor.classic.case2_withAbstraction;

import org.junit.Test;
import testPatterns.testVisitor.ConsoleMock;

import static junit.framework.TestCase.assertEquals;

public class ConcreteVisitorDTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testVisitConcreteElementA() {
        // given
        ConcreteElementA element = new ConcreteElementA();
        ConcreteVisitorD visitor = new ConcreteVisitorD();

        // when
        visitor.visit(element);

        // then
        assertEquals("ConcreteVisitorD visited(4) ConcreteElementA\n", console.getOut());
    }

    @Test
    public void testVisitConcreteElementAChild() {
        // given
        ConcreteElementAChild element = new ConcreteElementAChild();
        ConcreteVisitorD visitor = new ConcreteVisitorD();

        // when
        visitor.visit(element);

        // then
        assertEquals("ConcreteVisitorD visited(4) ConcreteElementAChild\n", console.getOut());
    }

    @Test
    public void testVisitConcreteElementB1() {
        // given
        ConcreteElementB1 element = new ConcreteElementB1();
        ConcreteVisitorD visitor = new ConcreteVisitorD();

        // when
        visitor.visit(element);

        // then
        assertEquals("ConcreteVisitorD visited(5) ConcreteElementB1\n", console.getOut());
    }

    @Test
    public void testVisitConcreteElementB1Child() {
        // given
        ConcreteElementB1Child element = new ConcreteElementB1Child();
        ConcreteVisitorD visitor = new ConcreteVisitorD();

        // when
        visitor.visit(element);

        // then
        assertEquals("ConcreteVisitorD visited(5) ConcreteElementB1Child\n", console.getOut());
    }

    @Test
    public void testVisitConcreteElementB2() {
        // given
        ConcreteElementB2 element = new ConcreteElementB2();
        ConcreteVisitorD visitor = new ConcreteVisitorD();

        // when
        visitor.visit(element);

        // then
        assertEquals("ConcreteVisitorD visited(6) ConcreteElementB2\n", console.getOut());
    }

    @Test
    public void testVisitConcreteElementB2Child() {
        // given
        ConcreteElementB2Child element = new ConcreteElementB2Child();
        ConcreteVisitorD visitor = new ConcreteVisitorD();

        // when
        visitor.visit(element);

        // then
        assertEquals("ConcreteVisitorD visited(6) ConcreteElementB2Child\n", console.getOut());
    }
}