package designPatterns.composite.classic.case2;

// там где есть интерфейс всегда можно попробовать абстрактный класс
// иногда это приводит к созданию другого шаблона, иногда разновидности исходного
//
// тут мы решаем проблему (в classic.case1), когда работая с Component,
// содержащими всего две операции, мы не могли получать доступ к его элементам,
// если этот Component был на самом деле Composite
//
// по моему это немного костыль, но работает! :)
public abstract class Component {

    // это наша главная часть компонента - операции

    public abstract String operation1(String data);
    
    public abstract String operation2(String data);
    
    // эти методы мы сюда вынесли, чтобы иметь возможность 
    // работать с абстракцией Component везде, не уточняя что бывают Composite
    //
    // пустая реализация тут за тем, чтоб Leaf не перегружались этим dummy-кодом
    
    public void add(Component component) {
        // do nothing
    }

    public void remove(Component component) {
        // do nothing
    }

    public int count() {
        return 0;
    }

    public Component get(int index) {
        // return null; // TODO тут потенциальный NPE
        // потому мы сгенерим исключение
        throw new UnsupportedOperationException("Этот лист не содержит элементов!");
    }
}