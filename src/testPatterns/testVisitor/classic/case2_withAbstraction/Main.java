package testPatterns.testVisitor.classic.case2_withAbstraction;

import java.util.Arrays;
import java.util.List;

// этот кейз немного сложнее
// тут хочется продемонстрировать два момента
// с одной стороны Element может иметь иерархию наследования
// делается это для группирования элементов в группы по его родителю
// для этого в родителе реализуется метод
//    public void accept(Visitor visitor) {
//        visitor.visit(this);
//    }
// а в наследнике нет
//
// с другой стороны, иерархия наследования так же возможна и со стороны Visitor
// но тут все тривиально - это стоит делать, если у нескольких
// посетителей есть общая логика, которая и уходит в абстрактный класс
//
// иерархия наследования в этом примере такая:
// Element
//         <- -
//                ElementB*
//                                   <---
//                                           ConcreteElementB1
//                                                                <---
//                                                                      ConcreteElementB1Child
//                                   <---
//                                           ConcreteElementB2*
//                                                                <---
//                                                                      ConcreteElementB2Child
//         <- -
//                ConcreteElementA*
//                                   <---
//                                          ConcreteElementAChild
// реализации помеченные * сами реализуют
//    public void accept(Visitor visitor) {
//        visitor.visit(this);
//    }
// определяя таким образом интерфейс Visitor как
//    public interface Visitor {
//        void visit(ConcreteElementA element);
//        void visit(ElementB element);
//        void visit(ConcreteElementB2 element);
//    }
// как-то так :)
public class Main {

    public static void main(String[] args) {
        // наши элементы, отцы и дети :)
        List<Element> elements = Arrays.asList(
                new ConcreteElementA(),
                new ConcreteElementAChild(),
                new ConcreteElementB1(),
                new ConcreteElementB1Child(),
                new ConcreteElementB2(),
                new ConcreteElementB2Child()
        );

        // наши посетители-алгоритмы
        Visitor visitorC = new ConcreteVisitorC();
        Visitor visitorD = new ConcreteVisitorD();

        // первый посетитель пройдется по всем элементам
        for (Element element : elements) {
            element.accept(visitorC);
        }

        printBreak();

        // второй посетитель пройдется по всем элементам
        for (Element element : elements) {
            element.accept(visitorD);
        }

        // Вывод:
        // ConcreteVisitorC visited(1) ConcreteElementA
        // ConcreteVisitorC visited(1) ConcreteElementAChild
        // ConcreteVisitorC visited(2) ConcreteElementB1
        // ConcreteVisitorC visited(2) ConcreteElementB1Child
        // ConcreteVisitorC visited(3) ConcreteElementB2
        // ConcreteVisitorC visited(3) ConcreteElementB2Child
        // -----------------
        // ConcreteVisitorD visited(4) ConcreteElementA
        // ConcreteVisitorD visited(4) ConcreteElementAChild
        // ConcreteVisitorD visited(5) ConcreteElementB1
        // ConcreteVisitorD visited(5) ConcreteElementB1Child
        // ConcreteVisitorD visited(6) ConcreteElementB2
        // ConcreteVisitorD visited(6) ConcreteElementB2Child
    }

    private static void printBreak() {
        System.out.print("--------------------------------------------------------------------\n");
    }
}