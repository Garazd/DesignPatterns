package testPatterns.testVisitor.sample.element;

import designPatterns.visitor.sample.element.Bell;
import designPatterns.visitor.sample.midi.Synthesizer;
import designPatterns.visitor.sample.music.Music;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class BellTest {

    private Synthesizer synthesizer;
    private Bell bell;

    @Before
    public void setup() {
        synthesizer = mock(Synthesizer.class);
        bell = new Bell(synthesizer);
    }

    @Test
    public void testChangeTone() {
        // when
        bell.tone(100);

        // then
        assertEquals(100, bell.tone());
        verifyNoMoreInteractions(synthesizer);
    }

    @Test
    public void testDefaultTone() {
        // when
        Bell bell = new Bell(synthesizer);

        // then
        assertEquals(0, bell.tone());
        verifyNoMoreInteractions(synthesizer);
    }

    @Test
    public void testBeep() {
        // given
        bell.tone(100);

        // when
        bell.beep();

        // then
        verify(synthesizer).tone(100, 1000, 100);
    }

    @Test
    public void testAffectByMusic() {
        // given
        Music music = mock(Music.class);

        // when
        bell.change(music);

        // then
        verify(music).affect(bell);
    }
}