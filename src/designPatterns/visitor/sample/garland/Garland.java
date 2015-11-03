package designPatterns.visitor.sample.garland;

import designPatterns.visitor.sample.element.Bell;
import designPatterns.visitor.sample.element.Color;
import designPatterns.visitor.sample.element.Laser;
import designPatterns.visitor.sample.element.Led;
import designPatterns.visitor.sample.midi.Synthesizer;
import designPatterns.visitor.sample.music.Music;

// это наш контейнер, сделан о в режиме билдера для удобства
public class Garland {

    private Synthesizer synthesizer;
    private Node start;

    // Garland это композит с Synthesizer
    // нам синтезатор понадобится дальше в каждом новом Bell
    // так мы его сразу сохранили, чтобы не повторяться
    public Garland(Synthesizer synthesizer) {
        this.synthesizer = synthesizer;
    }

    // это логика зпуска музыки на нашей гирлянде
    public void play(Music music) {
        for (Node node = start; node != null; node = node.prev) {
            // вот тут самая магическая часть шаблона Visitor
            // тип у нас тут Node и не понять Led, Laser или Bell тут у нас
            // но на music вызовется именно тот метод что надо
            // void affect(Led led);
            // void affect(Bell bell);
            // void affect(Laser laser);
            // вот такая магия!
            node.change(music);
        }
    }

    // все что ниже элементы шаблона Builder
    // мы строим цепочку давая более удобный DSL
    // клиенту нежели интерфейс Node
    // если бы не это, то код у нас был бы такой
    // Node start = new Led().add(new Led()).add(new Bell(synthesizer))
    //      .add(new Led()).add(new Led()).add(new Laser(Color.RED))
    //      .add(new Led()).add(new Led()).add(new Bell(synthesizer))
    //      .add(new Led()).add(new Led()).add(new Laser(Color.GREEN))
    //      .add(new Led()).add(new Led()).add(new Bell(synthesizer))
    //      .add(new Led()).add(new Led()).add(new Laser(Color.BLUE))
    //      .add(new Led()).add(new Led());
    // что согласись менее читабельнее чем
    // garland.led().led().bell()
    //      .led().led().laser(Color.RED)
    //      .led().led().bell()
    //      .led().led().laser(Color.GREEN)
    //      .led().led().bell()
    //      .led().led().laser(Color.BLUE)
    //      .led().led();

    public Garland led() {
        add(new Led());
        return this;
    }

    private void add(Node node) {
        if (start == null) {
            start = node;
        } else {
            start = start.add(node);
        }
    }

    public Garland bell() {
        add(new Bell(synthesizer));
        return this;
    }

    public Garland laser(Color color) {
        add(new Laser(color));
        return this;
    }
}