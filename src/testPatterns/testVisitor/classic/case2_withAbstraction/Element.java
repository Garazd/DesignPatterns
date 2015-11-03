package testPatterns.testVisitor.classic.case2_withAbstraction;

// тут все без изменений - интерфейс константа!
public interface Element {

    void accept(Visitor visitor);
}