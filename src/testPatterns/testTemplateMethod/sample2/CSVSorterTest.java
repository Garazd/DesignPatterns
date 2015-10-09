package testPatterns.testTemplateMethod.sample2;

import designPatterns.templateMethod.sample2.CSVSorter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// это тест на абстрактную составляющую - нащ темплейт метод
public class CSVSorterTest {

    @Test
    public void testSorting() {
        // given
        // мы инстранциируем анонимно наш абстрактный класс
        CSVSorter sorter = new CSVSorter(){
            @Override
            protected String getInputSeparator() {
                return "-";
            }

            @Override
            protected String getOutputSeparator() {
                return "+";
            }

            @Override
            public boolean compare(Object o1, Object o2) {
                return Integer.valueOf((String)o1) > Integer.valueOf((String)o2);
            }
        };
        // when
        // и тестим
        String actual = sorter.sort("1-4-5-2-3");

        // then
        assertEquals("1+2+3+4+5", actual);
    }

    @Test
    public void testSortingWithDefaultSeparator() {
        // given
        // мы инстранциируем анонимно наш абстрактный класс
        CSVSorter sorter = new CSVSorter(){
              @Override
              public boolean compare(Object o1, Object o2) {
                return Integer.valueOf((String)o1) > Integer.valueOf((String)o2);
            }
        };
        // when
        // и тестим
        String actual = sorter.sort("1,4,5,2,3");

        // then
        assertEquals("1,2,3,4,5", actual);
    }
}