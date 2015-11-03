package designPatterns.visitor.sample.music;

import designPatterns.visitor.sample.element.Bell;
import designPatterns.visitor.sample.element.Color;
import designPatterns.visitor.sample.element.Laser;
import designPatterns.visitor.sample.element.Led;

import java.util.Random;

// а это рендомная музыка, совсем рендомная
public class RandomMusic implements Music {

    private Random random;

    public RandomMusic(Random random) {
        this.random = random;
    }

    @Override
    public void affect(Led led) {
        Color[] colors = Color.values();
        Color next = colors[random.nextInt(colors.length)];
        led.setColor(next);
    }

    @Override
    public void affect(Bell bell) {
        bell.tone(random.nextInt(80) + 20);
    }

    @Override
    public void affect(Laser laser) {
        laser.light(random.nextBoolean());
    }
}