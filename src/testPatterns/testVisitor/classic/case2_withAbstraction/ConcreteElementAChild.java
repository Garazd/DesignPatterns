package testPatterns.testVisitor.classic.case2_withAbstraction;

public class ConcreteElementAChild extends ConcreteElementA {

    // наследник ConcreteElementA
    // сам не хочет ничего делать
    // обработается методом посетителя
    // void visit(ConcreteElementA element)
    // как элемент типа ConcreteElementA

    // так как мы не реализовали метод, то по умолчанию
    // будет нечто подобное этому методу
    // @Override
    // public void accept(Visitor visitor) {
    //     super.accept(visitor);
    // }

    // тут конечно же какая-то очень полезная логика
    // ...
}