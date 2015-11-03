package designPatterns.visitor.sample.music;

import designPatterns.visitor.sample.element.Bell;
import designPatterns.visitor.sample.element.Laser;
import designPatterns.visitor.sample.element.Led;

// цвето-мелодия, которая изменяет состояние относительно текущего
public class CoolMusic implements Music {

    // R -> G -> B -> Y -> R -> ...
    @Override
    public void affect(Led led) {
        led.setColor(led.getColor().next());
    }

    // тон повышается на 1 с каждым тактом
    @Override
    public void affect(Bell bell) {
        bell.tone(bell.tone() + 1);
    }

    // ладер то включается то выключается
    @Override
    public void affect(Laser laser) {
        laser.light(!laser.isOn());
    }
}