package testPatterns.testVisitor.sample.garland;

import designPatterns.visitor.sample.element.Bell;
import designPatterns.visitor.sample.element.Color;
import designPatterns.visitor.sample.element.Laser;
import designPatterns.visitor.sample.element.Led;
import designPatterns.visitor.sample.midi.Synthesizer;
import designPatterns.visitor.sample.music.Music;
import org.junit.Test;
import testPatterns.testVisitor.ConsoleMock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GarlandTest {

    private ConsoleMock console = new ConsoleMock();

    @Test
    public void test() {
        // given
        Synthesizer synthesizer = mock(Synthesizer.class);

        Garland garland = new Garland(synthesizer);

        garland.led().led().bell()
                .led().led().laser(Color.RED)
                .led().led().bell()
                .led().led().laser(Color.GREEN)
                .led().led().bell()
                .led().led().laser(Color.BLUE)
                .led().led();

        Music player = new Player();

        // when
        garland.play(player);

        // then
        assertEquals("RR-RR!RR-RR!RR-RR!RR", console.getOut());
        verify(synthesizer, times(3)).tone(0, 1000, 100);
        reset(synthesizer);

        // when
        garland.play(new Music() {
            @Override
            public void affect(Led led) {
                led.setColor(Color.GREEN);
            }

            @Override
            public void affect(Bell bell) {
                bell.tone(103);
            }

            @Override
            public void affect(Laser laser) {
                laser.light(true);
            }
        });

        garland.play(player);

        // then
        assertEquals("GG+GG!GG+GG!GG+GG!GG", console.getOut());
        verify(synthesizer, times(3)).tone(103, 1000, 100);
    }
}