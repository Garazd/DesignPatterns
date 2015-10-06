package testPatterns.testIterator.sample;

import designPatterns.iterator.sample.ArrayList;
import designPatterns.iterator.sample.List;

public class ArrayListTest extends ListTest {

    @Override
    protected List<String> getList() {
        return new ArrayList<String>();
    }
}