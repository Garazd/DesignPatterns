package testPatterns.testVisitor.classic.case2_withAbstraction;

// этот интерфейс поднвольный, его определяют те реализации
// Element которые определили в себе метод
//    public void accept(Visitor visitor) {
//        visitor.visit(this);
//    }
public interface Visitor {

    void visit(ConcreteElementA element);

    void visit(ElementB element);

    void visit(ConcreteElementB2 element);
}