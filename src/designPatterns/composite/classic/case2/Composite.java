package designPatterns.composite.classic.case2;

import java.util.LinkedList;
import java.util.List;

// реализацию заменили на наследование
public class Composite extends Component {

    // все тот же контейнер
    private List<Component> children;
    
    public Composite() {
        children = new LinkedList<Component>();
    }
    
    // все так же компоновщик не делает ничего сам, а делегирует детям-компонентам
    // аггрегируя результат

    @Override
    public String operation1(String data) {
        List<Object> result = new LinkedList<Object>();
        for (Component component : children) {
            // причем мы тут не знаем что в переменной Leaf или другой Composite
            result.add(component.operation1(data));
        }
        return result.toString();
    }

    @Override
    public String operation2(String data) {
        List<Object> result = new LinkedList<Object>();
        for (Component component : children) {
            result.add(component.operation2(data));
        }
        return result.toString();
    }
    
    // часть по работе с контейнером
    // добавление, удаление компонентов
    //
    // тут мы переопределяем базовую dummy-реализацию
    
    @Override
    public void add(Component component) {
        children.add(component);
    }
    
    @Override
    public void remove(Component component) {
        children.remove(component);
    }
    
    @Override
    public int count() {
        return children.size();
    }
    
    @Override
    public Component get(int index) {
        return children.get(index);
    }
}