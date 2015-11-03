package designPatterns.visitor.sample.element;

import designPatterns.visitor.sample.music.Music;
import designPatterns.visitor.sample.garland.Node;

// этот элемент - это лазер, цвет у него зашит, и он может только вкл/выкл
public class Laser extends Node {

    private final Color color;
    private boolean on;

    public Laser(Color color) {
        this.color = color;
        on = false;
    }

    @Override
    public void change(Music music) {
        music.affect(this);
    }

    public void light(boolean on) {
        this.on = on;
    }

    public boolean isOn() {
        return on;
    }

    public Color getColor() {
        return color;
    }
}