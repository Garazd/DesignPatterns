package testPatterns.testVisitor.sample.garland;

import designPatterns.visitor.sample.element.Bell;
import designPatterns.visitor.sample.element.Color;
import designPatterns.visitor.sample.element.Laser;
import designPatterns.visitor.sample.element.Led;
import designPatterns.visitor.sample.garland.Player;
import designPatterns.visitor.sample.midi.Synthesizer;
import designPatterns.visitor.sample.music.Music;
import org.junit.Before;
import org.junit.Test;
import testPatterns.testVisitor.ConsoleMock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerTest {

    private Music player;
    public ConsoleMock console;

    @Before
    public void setUp() {
        console = new ConsoleMock();
        player = new Player();
    }

    @Test
    public void testPlayLedBlue() {
        // given
        Led led = new Led();
        led.setColor(Color.BLUE);

        // when
        player.affect(led);

        // then
        assertEquals("B", console.getOut());
    }

    @Test
    public void testPlayLedGreen() {
        // given
        Led led = new Led();
        led.setColor(Color.GREEN);

        // when
        player.affect(led);

        // then
        assertEquals("G", console.getOut());
    }

    @Test
    public void testPlayLedYellow() {
        // given
        Led led = new Led();
        led.setColor(Color.YELLOW);

        // when
        player.affect(led);

        // then
        assertEquals("Y", console.getOut());
    }

    @Test
    public void testPlayLedRed() {
        // given
        Led led = new Led();
        led.setColor(Color.RED);

        // when
        player.affect(led);

        // then
        assertEquals("R", console.getOut());
    }

    @Test
    public void testPlayBell() {
        // given
        Synthesizer synthesizer = mock(Synthesizer.class);
        Bell bell = new Bell(synthesizer);
        bell.tone(101);

        // when
        player.affect(bell);

        // then
        assertEquals("!", console.getOut());
        verify(synthesizer).tone(101, 1000, 100);

        // when
        bell.tone(102);
        player.affect(bell);

        // then
        assertEquals("!", console.getOut());
        verify(synthesizer).tone(102, 1000, 100);
    }

    @Test
    public void testPlayLaser_caseOn() {
        // given
        Laser laser = new Laser(Color.RED);
        laser.light(true);

        // when
        player.affect(laser);

        // then
        assertEquals("+", console.getOut());
    }

    @Test
    public void testPlayLaser_caseOff() {
        // given
        Laser laser = new Laser(Color.RED);
        laser.light(false);

        // when
        player.affect(laser);

        // then
        assertEquals("-", console.getOut());
    }
}