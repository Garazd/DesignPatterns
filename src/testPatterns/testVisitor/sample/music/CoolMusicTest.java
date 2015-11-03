package testPatterns.testVisitor.sample.music;

import designPatterns.visitor.sample.element.Bell;
import designPatterns.visitor.sample.element.Color;
import designPatterns.visitor.sample.element.Laser;
import designPatterns.visitor.sample.element.Led;
import designPatterns.visitor.sample.music.CoolMusic;
import designPatterns.visitor.sample.music.Music;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoolMusicTest {

    private Music music = new CoolMusic();

    @Test
    public void testAffectLed() {
        // given
        Led led = new Led();
        led.setColor(Color.BLUE);

        // when
        music.affect(led);

        // then
        assertEquals(Color.BLUE.next(), led.getColor());
    }

    @Test
    public void testAffectBell() {
        // given
        Bell bell = new Bell(null);
        bell.tone(101);

        // when
        music.affect(bell);

        // then
        assertEquals(102, bell.tone());

        // when
        music.affect(bell);

        // then
        assertEquals(103, bell.tone());
    }

    @Test
    public void testAffectLaser_caseOn() {
        // given
        Laser laser = new Laser(Color.RED);
        laser.light(true);

        // when
        music.affect(laser);

        // then
        assertEquals(false, laser.isOn());
    }

    @Test
    public void testAffectLaser_caseOff() {
        // given
        Laser laser = new Laser(Color.RED);
        laser.light(false);

        // when
        music.affect(laser);

        // then
        assertEquals(true, laser.isOn());
    }
}