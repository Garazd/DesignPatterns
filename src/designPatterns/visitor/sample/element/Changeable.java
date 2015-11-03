package designPatterns.visitor.sample.element;

import designPatterns.visitor.sample.music.Music;

// а это по классике Element -
// интерфейс должны реализовать все,
// кто хочет быть обработаным Visitor (т.е. Music)
public interface Changeable {

    void change(Music music);
}