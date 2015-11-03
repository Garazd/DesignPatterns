package testPatterns.testVisitor.classic.case2_withAbstraction;

import junit.framework.TestCase;
import org.junit.Test;
import testPatterns.testVisitor.ConsoleMock;

public class ConcreteVisitorCTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testVisitConcreteElementA() {
        // given
        ConcreteElementA element = new ConcreteElementA();
        ConcreteVisitorC visitor = new ConcreteVisitorC();

        // when
        visitor.visit(element);

        // then
        TestCase.assertEquals("ConcreteVisitorC visited(1) ConcreteElementA\n", console.getOut());
    }

    @Test
    public void testVisitConcreteElementAChild() {
        // given
        ConcreteElementAChild element = new ConcreteElementAChild();
        ConcreteVisitorC visitor = new ConcreteVisitorC();

        // when
        visitor.visit(element);

        // then
        TestCase.assertEquals("ConcreteVisitorC visited(1) ConcreteElementAChild\n", console.getOut());
    }

    @Test
    public void testVisitConcreteElementB1() {
        // given
        ConcreteElementB1 element = new ConcreteElementB1();
        ConcreteVisitorC visitor = new ConcreteVisitorC();

        // when
        visitor.visit(element);

        // then
        TestCase.assertEquals("ConcreteVisitorC visited(2) ConcreteElementB1\n", console.getOut());
    }

    @Test
    public void testVisitConcreteElementB1Child() {
        // given
        ConcreteElementB1Child element = new ConcreteElementB1Child();
        ConcreteVisitorC visitor = new ConcreteVisitorC();

        // when
        visitor.visit(element);

        // then
        TestCase.assertEquals("ConcreteVisitorC visited(2) ConcreteElementB1Child\n", console.getOut());
    }

    @Test
    public void testVisitConcreteElementB2() {
        // given
        ConcreteElementB2 element = new ConcreteElementB2();
        ConcreteVisitorC visitor = new ConcreteVisitorC();

        // when
        visitor.visit(element);

        // then
        TestCase.assertEquals("ConcreteVisitorC visited(3) ConcreteElementB2\n", console.getOut());
    }

    @Test
    public void testVisitConcreteElementB2Child() {
        // given
        ConcreteElementB2Child element = new ConcreteElementB2Child();
        ConcreteVisitorC visitor = new ConcreteVisitorC();

        // when
        visitor.visit(element);

        // then
        TestCase.assertEquals("ConcreteVisitorC visited(3) ConcreteElementB2Child\n", console.getOut());
    }
}