package designPatterns.composite.classic.case2;

// тоже наследование
public class Leaf extends Component {

    // дальше без изменений
    private String id;

    public Leaf(String id) {
        this.id = id;
    }
    
    @Override
    public String operation1(String data) {
        return id + ".op1(" + data + ")";
    }

    @Override
    public String operation2(String data) {
        return id + ".op2(" + data + ")";
    }

    // листик с точки зрения того что он Component может
    // добавлять и удалять элементы, но они ни к чему не приведут
    // вот что мы наследуем от Component
    //
    // public void add(Component component) {
    //     // do nothing
    // }
    //
    // public void remove(Component component) {
    //     // do nothing
    // }
    //
    // public int count() {
    //     return 0;
    // }
    //
    // public Component get(int index) {
    //     throw new UnsupportedOperationException("Этот лист не содержит элементов!");
    // }
}