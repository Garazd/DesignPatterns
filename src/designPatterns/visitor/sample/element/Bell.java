package designPatterns.visitor.sample.element;

import designPatterns.visitor.sample.garland.Node;
import designPatterns.visitor.sample.midi.Synthesizer;
import designPatterns.visitor.sample.music.Music;

// звоночек может 1 секунду играть какую-то нотку
public class Bell extends Node {

    private Synthesizer synthesizer;
    private int frequency;

    public Bell(Synthesizer synthesizer) {
        frequency = 0;
        this.synthesizer = synthesizer;
    }

    @Override
    public void change(Music music) {
        music.affect(this);
    }

    public void tone(int frequency) {
        this.frequency = frequency;
    }

    public void beep() {
        synthesizer.tone(frequency, 1000, 100);
    }

    public int tone() {
        return frequency;
    }
}