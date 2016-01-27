package testPatterns.testComposite.windows;

import designPatterns.composite.sample.windows.HorizontalAlignment;
import designPatterns.composite.sample.windows.StringMessage;
import designPatterns.composite.sample.windows.VerticalAlignment;
import designPatterns.composite.sample.windows.Window;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void test1() {
        // given
        Window root = new HorizontalAlignment();

        root.add(new StringMessage("one"));

        Window composite2 = new VerticalAlignment();
        root.add(composite2);

        composite2.add(new StringMessage("two"));
        composite2.add(new StringMessage("three"));

        root.add(new StringMessage("four"));
        composite2.add(new StringMessage("five"));

        Window composite3 = new VerticalAlignment();
        root.add(composite3);

        composite3.add(new StringMessage("six"));
        composite3.add(new StringMessage("seven"));

        Window composite4 = new VerticalAlignment();
        composite2.add(composite4);

        composite4.add(new StringMessage("eight"));

        // when
        String draw = root.draw();

        // when
        assertEquals(
                "┌───────────────────────────────┐\n" +
                "│┌───┐┌─────────┐┌────┐┌───────┐│\n" +
                "││one││┌───┐    ││four││┌───┐  ││\n" +
                "│└───┘││two│    │└────┘││six│  ││\n" +
                "│     │└───┘    │      │└───┘  ││\n" +
                "│     │┌─────┐  │      │┌─────┐││\n" +
                "│     ││three│  │      ││seven│││\n" +
                "│     │└─────┘  │      │└─────┘││\n" +
                "│     │┌────┐   │      └───────┘│\n" +
                "│     ││five│   │               │\n" +
                "│     │└────┘   │               │\n" +
                "│     │┌───────┐│               │\n" +
                "│     ││┌─────┐││               │\n" +
                "│     │││eight│││               │\n" +
                "│     ││└─────┘││               │\n" +
                "│     │└───────┘│               │\n" +
                "│     └─────────┘               │\n" +
                "└───────────────────────────────┘\n", draw);
    }

    @Test
    public void test2() {
        // given
        Window root = new VerticalAlignment();

        root.add(new StringMessage("one"));

        Window composite2 = new HorizontalAlignment();
        root.add(composite2);

        composite2.add(new StringMessage("two"));
        composite2.add(new StringMessage("three"));

        root.add(new StringMessage("four"));
        composite2.add(new StringMessage("five"));

        Window composite3 = new HorizontalAlignment();
        root.add(composite3);

        composite3.add(new StringMessage("six"));
        composite3.add(new StringMessage("seven"));

        Window composite4 = new HorizontalAlignment();
        composite2.add(composite4);

        composite4.add(new StringMessage("eight"));

        // when
        String draw = root.draw();

        // when
        assertEquals(
                "┌─────────────────────────────┐\n" +
                "│┌───┐                        │\n" +
                "││one│                        │\n" +
                "│└───┘                        │\n" +
                "│┌───────────────────────────┐│\n" +
                "││┌───┐┌─────┐┌────┐┌───────┐││\n" +
                "│││two││three││five││┌─────┐│││\n" +
                "││└───┘└─────┘└────┘││eight││││\n" +
                "││                  │└─────┘│││\n" +
                "││                  └───────┘││\n" +
                "│└───────────────────────────┘│\n" +
                "│┌────┐                       │\n" +
                "││four│                       │\n" +
                "│└────┘                       │\n" +
                "│┌────────────┐               │\n" +
                "││┌───┐┌─────┐│               │\n" +
                "│││six││seven││               │\n" +
                "││└───┘└─────┘│               │\n" +
                "│└────────────┘               │\n" +
                "└─────────────────────────────┘\n", draw);

    }

    @Test
    public void test3() {
        // given
        Window root = new VerticalAlignment();

        root.add(new StringMessage("one"));

        Window composite2 = new VerticalAlignment();
        root.add(composite2);

        composite2.add(new StringMessage("two"));
        composite2.add(new StringMessage("three"));

        root.add(new StringMessage("four"));
        composite2.add(new StringMessage("five"));

        Window composite3 = new VerticalAlignment();
        root.add(composite3);

        composite3.add(new StringMessage("six"));
        composite3.add(new StringMessage("seven"));

        Window composite4 = new VerticalAlignment();
        composite2.add(composite4);

        composite4.add(new StringMessage("eight"));

        // when
        String draw = root.draw();

        // when
        assertEquals(
                "┌───────────┐\n" +
                "│┌───┐      │\n" +
                "││one│      │\n" +
                "│└───┘      │\n" +
                "│┌─────────┐│\n" +
                "││┌───┐    ││\n" +
                "│││two│    ││\n" +
                "││└───┘    ││\n" +
                "││┌─────┐  ││\n" +
                "│││three│  ││\n" +
                "││└─────┘  ││\n" +
                "││┌────┐   ││\n" +
                "│││five│   ││\n" +
                "││└────┘   ││\n" +
                "││┌───────┐││\n" +
                "│││┌─────┐│││\n" +
                "││││eight││││\n" +
                "│││└─────┘│││\n" +
                "││└───────┘││\n" +
                "│└─────────┘│\n" +
                "│┌────┐     │\n" +
                "││four│     │\n" +
                "│└────┘     │\n" +
                "│┌───────┐  │\n" +
                "││┌───┐  │  │\n" +
                "│││six│  │  │\n" +
                "││└───┘  │  │\n" +
                "││┌─────┐│  │\n" +
                "│││seven││  │\n" +
                "││└─────┘│  │\n" +
                "│└───────┘  │\n" +
                "└───────────┘\n", draw);
    }

    @Test
    public void test4() {
        // given
        Window root = new HorizontalAlignment();

        root.add(new StringMessage("one"));

        Window composite2 = new HorizontalAlignment();
        root.add(composite2);

        composite2.add(new StringMessage("two"));
        composite2.add(new StringMessage("three"));

        root.add(new StringMessage("four"));
        composite2.add(new StringMessage("five"));

        Window composite3 = new HorizontalAlignment();
        root.add(composite3);

        composite3.add(new StringMessage("six"));
        composite3.add(new StringMessage("seven"));

        Window composite4 = new HorizontalAlignment();
        composite2.add(composite4);

        composite4.add(new StringMessage("eight"));

        // when
        String draw = root.draw();

        // when
        assertEquals(
                "┌──────────────────────────────────────────────────────┐\n" +
                "│┌───┐┌───────────────────────────┐┌────┐┌────────────┐│\n" +
                "││one││┌───┐┌─────┐┌────┐┌───────┐││four││┌───┐┌─────┐││\n" +
                "│└───┘││two││three││five││┌─────┐││└────┘││six││seven│││\n" +
                "│     │└───┘└─────┘└────┘││eight│││      │└───┘└─────┘││\n" +
                "│     │                  │└─────┘││      └────────────┘│\n" +
                "│     │                  └───────┘│                    │\n" +
                "│     └───────────────────────────┘                    │\n" +
                "└──────────────────────────────────────────────────────┘\n", draw);
    }
}