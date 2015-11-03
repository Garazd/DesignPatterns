package designPatterns.visitor.classic.case1_simple;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // хранилище элементов, над которыми будем совершать действия,
        // инскапсулированное в посетителях (визитерах)
        List<Element> elements = Arrays.asList(new ConcreteElementA("data"),
                new ConcreteElementB(13));

        // вот наши алгоритмы
        Visitor visitorC = new ConcreteVisitorC();
        Visitor visitorD = new ConcreteVisitorD();

        // первый проход - над всеми элементами совершаем дествия из VisitorC
        for (Element element : elements) {
            element.accept(visitorC);
        }

        printBreak();

        // второй проход - над всеми элементами совершаем дествия из VisitorD
        for (Element element : elements) {
            element.accept(visitorD);
        }

        printBreak();

        // третий проход - снова VisitorС
        for (Element element : elements) {
            element.accept(visitorC);
        }

        // Вывод:
        // ConcreteVisitorC visited(1) ConcreteElementA, get something String:data
        // ConcreteVisitorC visited(2) ConcreteElementB, get something Integer:13
        // --------------------------------------------------------------------
        // ConcreteVisitorD visited(3) ConcreteElementA, set something String:newData
        // ConcreteVisitorD visited(4) ConcreteElementB, set something Integer:24
        // --------------------------------------------------------------------
        // ConcreteVisitorC visited(1) ConcreteElementA, get something String:newData
        // ConcreteVisitorC visited(2) ConcreteElementB, get something Integer:24
    }

    private static void printBreak() {
        System.out.print("--------------------------------------------------------------------\n");
    }
}