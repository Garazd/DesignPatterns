package testPatterns.testVisitor.classic.case1_simple;

import org.junit.Test;
import testPatterns.testVisitor.ConsoleMock;

import static junit.framework.TestCase.assertEquals;

public class ConcreteVisitorDTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void testVisitConcreteElementA() {
        // given
        ConcreteElementA element = new ConcreteElementA("qwe");
        ConcreteVisitorD visitor = new ConcreteVisitorD();

        // when
        visitor.visit(element);

        // then
        assertEquals("ConcreteVisitorD visited(3) ConcreteElementA, set something String:newData\n", console.getOut());
        assertEquals("newData", element.getSomething());
    }

    @Test
    public void testVisitConcreteElementB() {
        // given
        ConcreteElementB element = new ConcreteElementB(13);
        ConcreteVisitorD visitor = new ConcreteVisitorD();

        // when
        visitor.visit(element);

        // then
        assertEquals("ConcreteVisitorD visited(4) ConcreteElementB, set something Integer:24\n", console.getOut());
        assertEquals(Integer.valueOf(24), element.getSomething());
    }
}