package designPatterns.visitor.sample.music;

import designPatterns.visitor.sample.element.Bell;
import designPatterns.visitor.sample.element.Laser;
import designPatterns.visitor.sample.element.Led;

// по классике это у нас Visitor
public interface Music {

    // и он может влиять на любой элемент гирлянды
    void affect(Led led);

    void affect(Bell bell);

    void affect(Laser laser);
}