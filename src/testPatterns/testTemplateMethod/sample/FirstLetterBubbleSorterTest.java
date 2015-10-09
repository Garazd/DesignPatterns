package testPatterns.testTemplateMethod.sample;

import designPatterns.templateMethod.sample.BubbleSorter;
import designPatterns.templateMethod.sample.FirstLetterBubbleSorter;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class FirstLetterBubbleSorterTest {

    // given
    // мы инстранциируем готовый сортировщик
    BubbleSorter sorter = new FirstLetterBubbleSorter();

    // и тестим
    @Test
    public void testSortingInteger() {
        // when
        Object[] actual = sorter.sort(new Integer[]{123, 45, 3, 6, 12345, 456});

        // then
        assertEquals("[123, 12345, 3, 45, 456, 6]", Arrays.toString(actual));
    }

    @Test
    public void testSortingString() {
        // when
        Object[] actual = sorter.sort(new String[]{
                "sekfhseflj", "ds", "sdseee", "d", "dsds", "y"});

        // then
        assertEquals("[ds, d, dsds, sekfhseflj, sdseee, y]", Arrays.toString(actual));
    }

    @Test
    public void testSortingBoolean() {
        // when
        Object[] actual = sorter.sort(new Boolean[]{true, true, false, true});

        // then
        assertEquals("[false, true, true, true]", Arrays.toString(actual));
    }
}