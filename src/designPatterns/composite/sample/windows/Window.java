package designPatterns.composite.sample.windows;

// это наш Window(Component)
public abstract class Window {
    
    // методы отрисовки и получения размеров будут отличаться
    
    public abstract String draw();
    
    public abstract int width();
    
    public abstract int height();
    
    // это методы заглушки, чтобы листки не рисовали их у себя
    
    public void add(Window component) {
        // do nothing
    }

    public void remove(Window component) {
        // do nothing
    }

    public int count() {
        return 0;
    }

    public Window get(int index) {   
        throw new UnsupportedOperationException("Этот лист не содержит элементов!");
    }
}