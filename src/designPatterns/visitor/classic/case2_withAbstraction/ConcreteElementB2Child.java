package designPatterns.visitor.classic.case2_withAbstraction;

public class ConcreteElementB2Child extends ConcreteElementB2 {

    // наследник ConcreteElementB2
    // сам не хочет ничего делать
    // обработается методом посетителя
    // void visit(ConcreteElementB2 element)
    // как элемент типа ConcreteElementB2
    // поскольку ConcreteElementB2 переопределил
    // void accept(Visitor visitor)

    // тут конечно же какая-то очень полезная логика
    // ...
}