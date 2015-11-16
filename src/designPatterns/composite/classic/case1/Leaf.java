package designPatterns.composite.classic.case1;

// это листок - конечный элемент в дереве компонентов
public class Leaf implements Component {

    // пусть он имеет айдишку
    private String id;

    // которая его отличает от других листков
    public Leaf(String id) {
        this.id = id;
    }

    // а операции реализованы вот так

    @Override
    public String operation1(String data) {
        return id + ".op1(" + data + ")";
    }

    @Override
    public String operation2(String data) {
        return id + ".op2(" + data + ")";
    }
}