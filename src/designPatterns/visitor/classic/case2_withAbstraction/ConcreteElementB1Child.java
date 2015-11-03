package designPatterns.visitor.classic.case2_withAbstraction;

public class ConcreteElementB1Child extends ConcreteElementB1 {

    // наследник ConcreteElementB1
    // сам не хочет ничего делать
    // обработается методом посетителя
    // void visit(ElementB element)
    // как элемент типа ElementB,
    // потому что ConcreteElementB1 тоже не реализовал
    // void accept(Visitor visitor)

    // тут конечно же какая-то очень полезная логика
    // ...
}