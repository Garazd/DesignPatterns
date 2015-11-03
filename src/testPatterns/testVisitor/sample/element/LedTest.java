package testPatterns.testVisitor.sample.element;

import designPatterns.visitor.sample.element.Color;
import designPatterns.visitor.sample.element.Led;
import designPatterns.visitor.sample.music.Music;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LedTest {

    private Music music;

    @Before
    public void setup() {
        music = mock(Music.class);
    }

    @Test
    public void testDefaultColor() {
        // given
        Led led = new Led();

        // when
        Color color = led.getColor();

        // then
        assertEquals(Color.RED, color);
    }

    @Test
    public void testSetColor() {
        // given
        Led led = new Led();

        // when
        led.setColor(Color.BLUE);

        // then
        Color color = led.getColor();
        assertEquals(Color.BLUE, color);
    }

    @Test
    public void testAffectByMusic() {
        // given
        Led led = new Led();

        // when
        led.change(music);

        // then
        verify(music).affect(led);
    }
}