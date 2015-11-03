package designPatterns.visitor.classic.case2_withAbstraction;

// самостоятельный элемент
// реализует интерфейс сам и сам его имплементит
public class ConcreteElementA implements Element {

    // этим методом он заставляет всех посетителей
    // реализовать метод
    // void visit(ConcreteElementA element);
    // и обработать этот тип элементов как независимый
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // тут конечно же какая-то очень полезная логика
    // ...
}