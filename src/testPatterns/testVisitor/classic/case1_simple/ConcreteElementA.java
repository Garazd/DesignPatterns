package testPatterns.testVisitor.classic.case1_simple;

// этот элемент пусть хранит строки
public class ConcreteElementA implements Element {

    private String data;

    public ConcreteElementA(String data) {
        this.data = data;
    }

    // вот тут случается самое интересное
    // этот метод вызывает клиент, передавая элементу посетителя с алгоритмом
    @Override
    public void accept(Visitor visitor) {
        // посетитель с алгоритмом приходит к нам сюда
        // и мы (элемент) ему отдаемся полностью, передавая this.
        // в визитере есть ряд перегруженных методов,
        // но тут мы точно знаем свой тип, а потому вызовется тот метод
        // который соответствует нашему типу
        // хотя клиент ничего не знал про наш класс, он нас вызывал под видом Element
        // обошлись без class casting - в этом вся соль шаблона
        visitor.visit(this);
    }
    // эта строчка - единственное, как мы расширяем все элементы
    // все остальное, что мы не хотели "пихать" в этот класс уходит в реализацию посетителя

    // дальше банальное POJO
    public String getSomething() {
        return data;
    }

    public void setSomething(String data) {
        this.data = data;
    }
}