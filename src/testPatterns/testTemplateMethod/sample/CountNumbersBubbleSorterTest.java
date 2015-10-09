package testPatterns.testTemplateMethod.sample;

import designPatterns.templateMethod.sample.BubbleSorter;
import designPatterns.templateMethod.sample.CountNumbersBubbleSorter;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CountNumbersBubbleSorterTest {

    // given
    // мы инстранциируем готовый сортировщик
    BubbleSorter sorter = new CountNumbersBubbleSorter();

    // и тестим
    @Test
    public void testSortingInteger() {
        // when
        Object[] actual = sorter.sort(new Integer[]{123, 45, 3, 6, 12345, 456});

        // then
        assertEquals("[12345, 123, 456, 45, 3, 6]", Arrays.toString(actual));
    }

    @Test
    public void testSortingString() {
        // when
        Object[] actual = sorter.sort(new String[]{
                "sekfhseflj", "ds", "sdseee", "d", "dsds", "y"});

        // then
        assertEquals("[sekfhseflj, ds, sdseee, d, dsds, y]", Arrays.toString(actual));
    }

    @Test
    public void testSortingBoolean() {
        // when
        Object[] actual = sorter.sort(new Boolean[]{true, true, false, true});

        // then
        assertEquals("[true, true, false, true]", Arrays.toString(actual));
    }
}