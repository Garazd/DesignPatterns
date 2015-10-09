package testPatterns.testTemplateMethod.sample;

import designPatterns.templateMethod.sample.BubbleSorter;
import designPatterns.templateMethod.sample.ToStringLengthBubbleSorter;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ToStringLengthBubbleSorterTest {

    // given
    // мы инстранциируем готовый сортировщик
    BubbleSorter sorter = new ToStringLengthBubbleSorter();

    // и тестим
    @Test
    public void testSortingInteger() {
        // when
        Object[] actual = sorter.sort(new Integer[]{123, 45, 3, 6, 12345, 456});

        // then
        assertEquals("[3, 6, 45, 123, 456, 12345]", Arrays.toString(actual));
    }

    @Test
    public void testSortingString() {
        // when
        Object[] actual = sorter.sort(new String[]{
                "sekfhseflj", "ds", "sdseee", "d", "dsds", "y"});

        // then
        assertEquals("[d, y, ds, dsds, sdseee, sekfhseflj]", Arrays.toString(actual));
    }

    @Test
    public void testSortingBoolean() {
        // when
        Object[] actual = sorter.sort(new Boolean[]{true, true, false, true});

        // then
        assertEquals("[true, true, true, false]", Arrays.toString(actual));
    }
}