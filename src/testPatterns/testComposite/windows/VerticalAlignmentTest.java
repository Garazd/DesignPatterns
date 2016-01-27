package testPatterns.testComposite.windows;

import designPatterns.composite.sample.windows.VerticalAlignment;
import designPatterns.composite.sample.windows.Window;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VerticalAlignmentTest {

    @Test
    public void testDrawSimpleWindow() {
        // given
        Window window = new VerticalAlignment();

        window.add(new StubWindow('+', 6, 1));

        // when
        String draw = window.draw();

        // then
        assertEquals(
                "┌──────┐\n" +
                "│++++++│\n" +
                "└──────┘\n", draw);

        assertEquals(6 + 2, window.width());
        assertEquals(1 + 2, window.height());
    }

    @Test
    public void testDrawSimpleWindow_case2() {
        // given
        Window window = new VerticalAlignment();

        window.add(new StubWindow('+', 1, 6));

        // when
        String draw = window.draw();

        // then
        assertEquals(
                "┌─┐\n" +
                "│+│\n" +
                "│+│\n" +
                "│+│\n" +
                "│+│\n" +
                "│+│\n" +
                "│+│\n" +
                "└─┘\n", draw);

        assertEquals(1 + 2, window.width());
        assertEquals(6 + 2, window.height());
    }

    @Test
    public void testDrawMultilineWindow() {
        // given
        Window window = new VerticalAlignment();

        window.add(new StubWindow('+', 6, 3));

        // when
        String draw = window.draw();

        // then
        assertEquals(
                "┌──────┐\n" +
                "│++++++│\n" +
                "│++++++│\n" +
                "│++++++│\n" +
                "└──────┘\n", draw);

        // when then
        assertEquals(6 + 2, window.width());
        assertEquals(3 + 2, window.height());
    }

    @Test
    public void testDrawTwoMultilineWindow() {
        // given
        Window window = new VerticalAlignment();

        window.add(new StubWindow('+', 6, 3));
        window.add(new StubWindow('-', 6, 2));

        // when
        String draw = window.draw();

        // then
        assertEquals(
                "┌──────┐\n" +
                "│++++++│\n" +
                "│++++++│\n" +
                "│++++++│\n" +
                "│------│\n" +
                "│------│\n" +
                "└──────┘\n", draw);

        // when then
        assertEquals(6 + 2, window.width());
        assertEquals(3 + 2 + 2, window.height());
    }

    @Test
    public void testDrawTwoMultilineWindow_whenOneWidthLessThanOther() {
        // given
        Window window = new VerticalAlignment();

        window.add(new StubWindow('+', 2, 3));
        window.add(new StubWindow('-', 6, 2));

        // when
        String draw = window.draw();

        // then
        assertEquals(
                "┌──────┐\n" +
                "│++    │\n" +
                "│++    │\n" +
                "│++    │\n" +
                "│------│\n" +
                "│------│\n" +
                "└──────┘\n", draw);

        // when then
        assertEquals(6 + 2, window.width());
        assertEquals(3 + 2 + 2, window.height());
    }

    @Test
    public void testDrawTwoMultilineWindow_whenOneWidthLessThanOther_case2() {
        // given
        Window window = new VerticalAlignment();

        window.add(new StubWindow('+', 6, 3));
        window.add(new StubWindow('-', 2, 2));

        // when
        String draw = window.draw();

        // then
        assertEquals(
                "┌──────┐\n" +
                "│++++++│\n" +
                "│++++++│\n" +
                "│++++++│\n" +
                "│--    │\n" +
                "│--    │\n" +
                "└──────┘\n", draw);

        // when then
        assertEquals(6 + 2, window.width());
        assertEquals(3 + 2 + 2, window.height());
    }

    @Test
    public void testDrawThreeMultilineWindow() {
        // given
        Window window = new VerticalAlignment();

        window.add(new StubWindow('+', 3, 1));
        window.add(new StubWindow('-', 1, 2));
        window.add(new StubWindow('=', 2, 3));

        // when
        String draw = window.draw();

        // then
        assertEquals(
                "┌───┐\n" +
                "│+++│\n" +
                "│-  │\n" +
                "│-  │\n" +
                "│== │\n" +
                "│== │\n" +
                "│== │\n" +
                "└───┘\n", draw);

        // when then
        assertEquals(3 + 2, window.width());
        assertEquals(1 + 2 + 3 + 2, window.height());
    }
}