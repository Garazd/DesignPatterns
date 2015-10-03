package testPatterns.testStrategy.sample;

import designPatterns.strategy.sample.BubbleSorter;
import designPatterns.strategy.sample.Comparator;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BubbleSorterTest {

    @Test
    public void testSorting() {
        // given
        BubbleSorter sorter = new BubbleSorter(new Comparator() {
            public boolean compare(Object o1, Object o2) {
                return Integer.valueOf((String)o1) > Integer.valueOf((String)o2);
            }
        });

        // when
        Object[] actual = sorter.sort(new String[]{"1", "2", "4", "3", "5"});

        // then
        assertEquals("[1, 2, 3, 4, 5]", Arrays.toString(actual));
    }
}