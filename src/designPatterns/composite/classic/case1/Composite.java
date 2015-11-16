package designPatterns.composite.classic.case1;

import java.util.LinkedList;
import java.util.List;

// это наш контейнер компонентов - компоновщик
// и так как контейнер сам реализует компонент, то может включать сам себя
public class Composite implements Component {

    // хранилище компонентов - детей
    private List<Component> children;
    
    public Composite() {
        children = new LinkedList<Component>();
    }
    
    // компоновщик не реализует сам операцию, а делегирует ее детям
    // собирая результат для вызвавшего метод клиента
    @Override
    public String operation1(String data) {
        List<Object> result = new LinkedList<Object>();
        for (Component component : children) {
            // причем мы тут не знаем, что в переменной Leaf или другой Composite
            result.add(component.operation1(data));
        }
        return result.toString();
    }

    // то же по другой операции
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
    
    public void add(Component component) {
        children.add(component);
    }
    
    public void remove(Component component) {
        children.remove(component);
    }
    
    public int count() {
        return children.size();
    }
    
    public Component get(int index) {
        return children.get(index);
    }
}