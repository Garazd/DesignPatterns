package testPatterns.testVisitor.classic.case1_simple;

// это наш визитер (или посетитель)
//
// тут могла быть как абстракция в виде abstract class так и в виде interface (как у нас сейчас)
//
// реализация посетителя будет инкапсулировать однотипный алгоритм,
// применимый для всех типов элементов
public interface Visitor {

    // для каждого типа элемента свой метод с логикой
    // всего их столько, сколько у нас есть елементов

    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}