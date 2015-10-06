package testPatterns.testIterator.sample;

import designPatterns.iterator.sample.LinkedList;
import designPatterns.iterator.sample.List;

public class LinkedListTest extends ListTest {

    @Override
    protected List<String> getList() {
        return new LinkedList<String>();
    }
}