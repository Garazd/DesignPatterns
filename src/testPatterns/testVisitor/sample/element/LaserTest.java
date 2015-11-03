package testPatterns.testVisitor.sample.element;

import designPatterns.visitor.sample.element.Color;
import designPatterns.visitor.sample.element.Laser;
import designPatterns.visitor.sample.music.Music;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LaserTest {

    private Music music;

    @Before
    public void setup() {
        music = mock(Music.class);
    }

    @Test
    public void testSetColor() {
        // when
        Laser laser = new Laser(Color.BLUE);

        // then
        assertEquals(Color.BLUE, laser.getColor());
    }

    @Test
    public void testDefaultLighting() {
        // when
        Laser laser = new Laser(Color.BLUE);

        // then
        assertFalse(laser.isOn());
    }

    @Test
    public void testChangeLighting() {
        // given
        Laser laser = new Laser(Color.BLUE);

        // when
        laser.light(true);

        // then
        assertTrue(laser.isOn());
    }

    @Test
    public void testChangeLighting2() {
        // given
        Laser laser = new Laser(Color.BLUE);
        laser.light(true);

        // when
        laser.light(false);

        // then
        assertFalse(laser.isOn());
    }

    @Test
    public void testAffectByMusic() {
        // given
        Laser laser = new Laser(Color.BLUE);

        // when
        laser.change(music);

        // then
        verify(music).affect(laser);
    }
}