package designPatterns.visitor.classic.case1_simple;

// тут все так же, только храним мы Integer
public class ConcreteElementB implements Element {

    private Integer data;

    public ConcreteElementB(Integer data) {
        this.data = data;
    }

    // метод заметь тут точно такой же, и он должен быть тут
    // это не дублирование! Тут он потому что тут мы знаем тип
    // унесем куда-то в родителя (если бы он был), то там типа уже не имели бы
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Integer getSomething() {
        return data;
    }

    public void setSomething(Integer data) {
        this.data = data;
    }
}