package designPatterns.visitor.classic.case2_withAbstraction;

// а это базовая реализация ветки наследников
// может быть абстрактной а может и нет, не существенно -
// все зависит от того может ли она сама по себе существовать - решать тебе
public abstract class ElementB implements Element {

    // все наследники, если они не переопределят этот метод
    // будут обрабатываться в посетителях в методе
    // public void visit(ElementB element) {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    // тут конечно же какая-то очень полезная логика
    // ...
}