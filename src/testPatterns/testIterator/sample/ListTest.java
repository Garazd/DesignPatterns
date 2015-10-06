package testPatterns.testIterator.sample;

import org.junit.Test;
import designPatterns.iterator.sample.Iterator;
import designPatterns.iterator.sample.List;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public abstract class ListTest {

    protected abstract List<String> getList();

    @Test
    public void testEmptyList() {
        // given
        List<String> list = getList();

        // when

        // then
        assertEquals("[]", list.toString());

        Iterator<String> iterator = list.iterator();
        assertEquals(false, iterator.hasNext());
        try {
            iterator.next();
            fail();
        } catch (NoSuchElementException e) {
            // do nothing
        }

        assertEquals(0, list.size());

        assertEquals(false, list.contains("one"));

        try {
            list.get(0);
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            // do nothing
        }

        assertEquals(-1, list.indexOf("one"));

        assertEquals(true, list.isEmpty());

        assertEquals(false, list.remove("one"));
    }

    @Test
    public void testOneElement() {
        // given
        List<String> list = getList();

        // when
        list.add("one");

        // then
        assertEquals("[one]", list.toString());

        Iterator<String> iterator = list.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("one", iterator.next());
        assertEquals(false, iterator.hasNext());
        try {
            iterator.next();
            fail();
        } catch (NoSuchElementException e) {
            // do nothing
        }

        assertEquals(1, list.size());

        assertEquals(true, list.contains("one"));
        assertEquals(false, list.contains("two"));

        assertEquals("one", list.get(0));

        assertEquals(0, list.indexOf("one"));
        assertEquals(-1, list.indexOf("three"));

        assertEquals(false, list.isEmpty());

        assertEquals(true, list.remove("one"));

        assertEquals(false, list.remove("two"));
    }

    @Test
    public void testTwoElements() {
        // given
        List<String> list = getList();

        // when
        list.add("one");
        list.add("two");

        // then
        assertEquals("[one, two]", list.toString());

        Iterator<String> iterator = list.iterator();
        assertEquals(true, iterator.hasNext());
        assertEquals("one", iterator.next());
        assertEquals(true, iterator.hasNext());
        assertEquals("two", iterator.next());
        assertEquals(false, iterator.hasNext());
        try {
            iterator.next();
            fail();
        } catch (NoSuchElementException e) {
            // do nothing
        }

        assertEquals(2, list.size());

        assertEquals(true, list.contains("one"));
        assertEquals(true, list.contains("two"));
        assertEquals(false, list.contains("three"));

        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        try {
            list.get(2);
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            // do nothing
        }

        assertEquals(0, list.indexOf("one"));
        assertEquals(1, list.indexOf("two"));
        assertEquals(-1, list.indexOf("three"));

        assertEquals(false, list.isEmpty());

        assertEquals(true, list.remove("one"));
        assertEquals(true, list.remove("two"));
        assertEquals(false, list.remove("three"));
    }

    @Test
    public void testElementsRemoveOneByIndex() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        // when then
        assertEquals("one", list.remove(0));
        assertEquals("[two, three]", list.toString());

        // when then
        assertEquals("two", list.remove(0));
        assertEquals("[three]", list.toString());

        // when then
        assertEquals("three", list.remove(0));
        assertEquals("[]", list.toString());

        // when then
        try {
            list.remove(0);
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            // do nothing
        }
    }

    @Test
    public void testElementsRemoveOneByIndex2() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        // when then
        assertEquals("two", list.remove(1));
        assertEquals("[one, three]", list.toString());

        // when then
        assertEquals("three", list.remove(1));
        assertEquals("[one]", list.toString());

        // when then
        try {
            list.remove(1);
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            // do nothing
        }
    }

    @Test
    public void testElementsRemoveOneByIndex3() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        // when then
        assertEquals("three", list.remove(list.size() - 1));
        assertEquals("[one, two]", list.toString());

        // when then
        assertEquals("two", list.remove(list.size() - 1));
        assertEquals("[one]", list.toString());

        // when then
        assertEquals("one", list.remove(list.size() - 1));
        assertEquals("[]", list.toString());

        // when then
        try {
            list.remove(list.size() - 1);
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            // do nothing
        }
    }

    @Test
    public void testElementsRemoveOneByValue() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        // when then
        assertEquals(true, list.remove("one"));
        assertEquals("[two, three]", list.toString());

        // when then
        assertEquals(true, list.remove("two"));
        assertEquals("[three]", list.toString());

        // when then
        assertEquals(true, list.remove("three"));
        assertEquals("[]", list.toString());
    }

    @Test
    public void testElementsRemoveOneByValue2() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        // when then
        assertEquals(true, list.remove("two"));
        assertEquals("[one, three]", list.toString());

        // when then
        assertEquals(true, list.remove("three"));
        assertEquals("[one]", list.toString());

        // when then
        assertEquals(true, list.remove("one"));
        assertEquals("[]", list.toString());
    }

    @Test
    public void testElementsRemoveOneByValue3() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        // when then
        assertEquals(true, list.remove("three"));
        assertEquals("[one, two]", list.toString());

        // when then
        assertEquals(true, list.remove("two"));
        assertEquals("[one]", list.toString());

        // when then
        assertEquals(true, list.remove("one"));
        assertEquals("[]", list.toString());
    }

    @Test
    public void testInsertNewElement() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        // when then
        list.add(0, "zerro");
        assertEquals("[zerro, one, two, three]", list.toString());

        // when then
        list.add(list.size(), "four");
        assertEquals("[zerro, one, two, three, four]", list.toString());

        // when then
        list.add(2, "one_and_half");
        assertEquals("[zerro, one, one_and_half, two, three, four]", list.toString());

        // when then
        try {
            list.add(list.size() + 1, "five");
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            // do nothing
        }
    }

    @Test
    public void testInsertNewElementAtSamePosition() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        // when then
        list.add(0, "zerro");
        assertEquals("[zerro, one, two, three]", list.toString());

        // when then
        list.add(0, "-one");
        assertEquals("[-one, zerro, one, two, three]", list.toString());

        // when then
        list.add(0, "-two");
        assertEquals("[-two, -one, zerro, one, two, three]", list.toString());

        // when then
        list.add(0, "-three");
        assertEquals("[-three, -two, -one, zerro, one, two, three]", list.toString());
    }

    @Test
    public void testInsertNewElementAtSamePositionAtEnd() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        // when then
        list.add(list.size(), "four");
        assertEquals("[one, two, three, four]", list.toString());

        // when then
        list.add(list.size(), "five");
        assertEquals("[one, two, three, four, five]", list.toString());

        // when then
        list.add(list.size(), "six");
        assertEquals("[one, two, three, four, five, six]", list.toString());

        // when then
        list.add(list.size(), "seven");
        assertEquals("[one, two, three, four, five, six, seven]", list.toString());
    }

    @Test
    public void testInsertNewElementAtSamePositionAtMiddle() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        // when then
        list.add(2, "two_and_one");
        assertEquals("[one, two, two_and_one, three]", list.toString());

        // when then
        list.add(2, "two_and_two");
        assertEquals("[one, two, two_and_two, two_and_one, three]", list.toString());

        // when then
        list.add(2, "two_and_three");
        assertEquals("[one, two, two_and_three, two_and_two, two_and_one, three]", list.toString());

        // when then
        list.add(2, "two_and_four");
        assertEquals("[one, two, two_and_four, two_and_three, two_and_two, two_and_one, three]", list.toString());
    }

    @Test
    public void testClearListWithElements() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        // when
        list.clear();

        // then
        assertEquals("[]", list.toString());
    }

    @Test
    public void testClearEmptyList() {
        // given
        List<String> list = getList();

        // when
        list.clear();

        // then
        assertEquals("[]", list.toString());
    }

    @Test
    public void testSetNewElementAtIndex() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        // when then
        assertEquals("one", list.set(0, "one!"));
        assertEquals("[one!, two, three]", list.toString());

        // when then
        assertEquals("two", list.set(1, "two!"));
        assertEquals("[one!, two!, three]", list.toString());

        // when then
        assertEquals("three", list.set(2, "three!"));
        assertEquals("[one!, two!, three!]", list.toString());

        // when then
        try {
            list.set(3, "four!");
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            // do nothing
        }
        // when then
        try {
            list.set(-1, "zerro!");
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            // do nothing
        }
    }

    @Test
    public void testRemoveFromIterator() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        Iterator<String> iterator = list.iterator();

        // when then
        assertEquals(true, iterator.hasNext());
        try {
            iterator.remove();
            fail();
        } catch (IllegalStateException e) {
            // do nothing
        }

        // when
        assertEquals(true, iterator.hasNext());
        assertEquals("one", iterator.next());
        iterator.remove();

        // then
        assertEquals("[two, three, four]", list.toString());

        // when
        assertEquals(true, iterator.hasNext());
        assertEquals("two", iterator.next());
        assertEquals("three", iterator.next());
        iterator.remove();

        // when then
        try {
            iterator.remove();
            fail();
        } catch (IllegalStateException e) {
            // do nothing
        }

        // then
        assertEquals("[two, four]", list.toString());

        // when
        assertEquals(true, iterator.hasNext());
        assertEquals("four", iterator.next());
        iterator.remove();

        // then
        assertEquals("[two]", list.toString());
        assertEquals(false, iterator.hasNext());

        // when then
        try {
            iterator.remove();
            fail();
        } catch (IllegalStateException e) {
            // do nothing
        }
    }

    @Test
    public void testWorkWithNull() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add(null);
        list.add("four");

        // when then
        assertEquals("[one, two, null, four]", list.toString());
        assertEquals(2, list.indexOf(null));
        assertEquals(true, list.contains(null));

        // when then
        assertEquals(null, list.remove(2));
        assertEquals("[one, two, four]", list.toString());

        // when then
        list.add(2, null);
        assertEquals("[one, two, null, four]", list.toString());

        // when then
        list.set(1, null);
        assertEquals("[one, null, null, four]", list.toString());

        // when then
        assertEquals(true, list.remove(null));
        assertEquals("[one, null, four]", list.toString());

        assertEquals(true, list.remove(null));
        assertEquals("[one, four]", list.toString());

        assertEquals(false, list.remove(null));
        assertEquals("[one, four]", list.toString());
    }

    @Test
    public void testConcurrentModificationWhenRemove() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator = list.iterator();
        assertEquals("one", iterator.next());

        // when
        list.remove(0);
        assertConcurrentModificationExceptionWillBeThrown(iterator);
    }

    private void assertConcurrentModificationExceptionWillBeThrown(Iterator<String> iterator) {
        // then
        try {
            iterator.next();
            fail();
        } catch (ConcurrentModificationException e) {
            // do nothing
        }
        // then
        try {
            iterator.remove();
            fail();
        } catch (ConcurrentModificationException e) {
            // do nothing
        }
    }

    @Test
    public void testConcurrentModificationWhenInsert() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator = list.iterator();
        assertEquals("one", iterator.next());

        // when
        list.add("four");

        // then
        assertConcurrentModificationExceptionWillBeThrown(iterator);
    }

    @Test
    public void testConcurrentModificationWhenUpdate() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator = list.iterator();
        assertEquals("one", iterator.next());

        // when
        list.set(0, "one!");

        // then
        assertConcurrentModificationExceptionWillBeThrown(iterator);
    }

    @Test
    public void testConcurrentModificationWhenClear() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator = list.iterator();
        assertEquals("one", iterator.next());

        // when
        list.clear();

        // then
        assertConcurrentModificationExceptionWillBeThrown(iterator);
    }

    @Test
    public void testConcurrentModificationWhenRemoveOnOtherIterator() {
        // given
        List<String> list = getList();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iterator1 = list.iterator();
        assertEquals("one", iterator1.next());

        Iterator<String> iterator2 = list.iterator();
        assertEquals("one", iterator2.next());

        // when
        iterator1.remove();

        // then
        assertEquals("two", iterator1.next());
        assertConcurrentModificationExceptionWillBeThrown(iterator2);
    }
}