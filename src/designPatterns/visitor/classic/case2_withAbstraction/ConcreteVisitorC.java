package designPatterns.visitor.classic.case2_withAbstraction;

// посетитель, который обращается за помощью
// к родителю, чтобы сделать полезное действие
public class ConcreteVisitorC extends AbstractVisitor {

    @Override
    public void visit(ConcreteElementA element) {
        print(1, element);
    }

    @Override
    public void visit(ElementB element) {
        print(2, element);
    }

    @Override
    public void visit(ConcreteElementB2 element) {
        print(3, element);
    }
}