package testPatterns.testTemplateMethod.sample2;

import designPatterns.templateMethod.sample2.CSVSorter;
import designPatterns.templateMethod.sample2.ToStringLengthCSVSorter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToStringLengthCSVSorterTest {

    // given
    // мы инстранциируем готовый сортировщик
    CSVSorter sorter = new ToStringLengthCSVSorter();

    // и тестим
    @Test
    public void testSortingInteger() {
        // when
        String actual = sorter.sort("123,45,3,6,12345,456");

        // then
        assertEquals("3<sep>6<sep>45<sep>123<sep>456<sep>12345",actual);
    }

    @Test
    public void testSortingString() {
        // when
        String actual = sorter.sort("sekfhseflj,ds,sdseee,d,dsds,y");

        // then
        assertEquals("d<sep>y<sep>ds<sep>dsds<sep>sdseee<sep>sekfhseflj", actual);
    }

    @Test
    public void testSortingBoolean() {
        // when
        String actual = sorter.sort("true,true,false,true");

        // then
        assertEquals("true<sep>true<sep>true<sep>false", actual);
    }
}