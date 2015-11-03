package designPatterns.visitor.classic.case2_withAbstraction;

// тут содержится какая-то общая логика для группы визитеров ее наследующей
public abstract class AbstractVisitor implements Visitor {

    protected void print(int number, Object element) {
        System.out.printf("%s visited(%s) %s\n",
                this.getClass().getSimpleName(),
                number,
                element.getClass().getSimpleName());
    }
}