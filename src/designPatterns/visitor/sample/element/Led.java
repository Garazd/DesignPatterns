package designPatterns.visitor.sample.element;

import designPatterns.visitor.sample.music.Music;
import designPatterns.visitor.sample.garland.Node;

// этот элемент - это светодиод, который может гореть разными цветами
public class Led extends Node {

    private Color color = Color.RED;

    @Override
    public void change(Music music) {
        music.affect(this);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}