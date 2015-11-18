package designPatterns.composite.sample.windows;

import java.util.LinkedList;
import java.util.List;

// а это наш Frame(Composite), он аггрегирует другие Window(Component)
public abstract class Frame extends Window {

    protected List<Window> windows;
    
    public Frame() {
        windows = new LinkedList<Window>();
    }
    
    @Override
    public void add(Window component) {
        windows.add(component);
    }
    
    @Override
    public void remove(Window component) {
        windows.remove(component);
    }
    
    @Override
    public int count() {
        return windows.size();
    }
    
    @Override
    public Window get(int index) {
        return windows.get(index);
    }
}