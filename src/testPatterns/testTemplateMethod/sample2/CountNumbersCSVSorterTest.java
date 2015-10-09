package testPatterns.testTemplateMethod.sample2;

import designPatterns.templateMethod.sample2.CSVSorter;
import designPatterns.templateMethod.sample2.CountNumbersCSVSorter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountNumbersCSVSorterTest {

    // и тестим
    @Test
    public void testSortingInteger() {
        // given
        // мы инстранциируем готовый сортировщик
        CSVSorter sorter = new CountNumbersCSVSorter("|");

        // when
        String actual = sorter.sort("123|45|3|6|12345|456");

        // then
        assertEquals("12345|123|456|45|3|6", actual);
    }

    @Test
    public void testSortingString() {
        // given
        // мы инстранциируем готовый сортировщик
        CSVSorter sorter = new CountNumbersCSVSorter("-");

        // when
        String actual = sorter.sort("sekfhseflj-ds-sdseee-d-dsds-y");

        // then
        assertEquals("sekfhseflj-ds-sdseee-d-dsds-y", actual);
    }

    @Test
    public void testSortingBoolean() {
        // given
        // мы инстранциируем готовый сортировщик
        CSVSorter sorter = new CountNumbersCSVSorter(",");

        // when
        String actual = sorter.sort("true,true,false,true");

        // then
        assertEquals("true,true,false,true", actual);
    }
}