package testPatterns.testVisitor.classic.case2_withAbstraction;

public class ConcreteElementB2 extends ElementB {

    // а этот наследник ElementB самостоятельный
    // и хочет чтобы его обрабатывали посетители отдельно
    // потому очень важно тут переопределить этот метод снова,
    // потому как метод в родителе работает с типом ElementB
    // и направит выполнение к
    // public void visit(ElementB element) {
    // а нам надо к
    // public void visit(ConcreteElementB2 element) {
    // напомню - это не дуюлирование! тут определятеся тип элемента
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // тут конечно же какая-то очень полезная логика
    // ...
}