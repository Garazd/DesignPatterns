package testPatterns.testIterator.classic;

import org.junit.Test;
import designPatterns.iterator.classic.ConcreteAggregate;
import designPatterns.iterator.classic.Iterator;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ConcreteAggregateTest {

    @Test
    public void testFirstElementWhenCreateIterator() {
        // given
        ConcreteAggregate aggregate = new ConcreteAggregate<String>(2);

        aggregate.set(0, "one");
        aggregate.set(1, "two");

        Iterator<String> iterator = aggregate.createIterator();

        // when
        String value = iterator.currentItem();

        // then
        assertEquals("one", value);
    }

    @Test
    public void testSecondElementWhenCallNext() {
        // given
        ConcreteAggregate aggregate = new ConcreteAggregate<String>(3);

        aggregate.set(0, "one");
        aggregate.set(1, "two");
        aggregate.set(2, "three");

        Iterator<String> iterator = aggregate.createIterator();

        // when
        iterator.next();
        String value = iterator.currentItem();

        // then
        assertEquals("two", value);
    }

    @Test
    public void testThirdElementWhenCallNextTwice() {
        // given
        ConcreteAggregate aggregate = new ConcreteAggregate<String>(3);

        aggregate.set(0, "one");
        aggregate.set(1, "two");
        aggregate.set(2, "three");

        Iterator<String> iterator = aggregate.createIterator();

        iterator.next();

        // when
        iterator.next();
        String value = iterator.currentItem();

        // then
        assertEquals("three", value);
    }

    @Test(expected = NoSuchElementException.class)
    public void testErrorWhenCallGetItemAtEndOfAggregate() {
        // given
        ConcreteAggregate aggregate = new ConcreteAggregate<String>(3);

        aggregate.set(0, "one");
        aggregate.set(1, "two");
        aggregate.set(2, "three");

        Iterator<String> iterator = aggregate.createIterator();

        iterator.next();
        iterator.next();
        iterator.next();

        // when
        iterator.currentItem();

        // then
        // exception will be thrown
    }

    @Test(expected = NoSuchElementException.class)
    public void testErrorWhenCallCallGetItemOnEmptyAggregate() {
        // given
        ConcreteAggregate aggregate = new ConcreteAggregate<String>(0);

        Iterator<String> iterator = aggregate.createIterator();
        iterator.next();

        // when
        iterator.currentItem();

        // then
        // exception will be thrown
    }

    @Test
    public void testIsDoneMustMeTrueWhenCallItOnEmptyAggregate() {
        // given
        ConcreteAggregate aggregate = new ConcreteAggregate<String>(0);

        Iterator<String> iterator = aggregate.createIterator();

        // when
        boolean done = iterator.isDone();

        // then
        assertTrue(done);
    }

    @Test
    public void testIsDoneIsFalseWhenCreateIteratorOfNotEmptyAggregate() {
        // given
        ConcreteAggregate aggregate = new ConcreteAggregate<String>(1);

        aggregate.set(0, "one");

        Iterator<String> iterator = aggregate.createIterator();

        // when
        boolean done = iterator.isDone();

        // then
        assertFalse(done);
    }

    @Test
    public void testIsDoneIsTrueAtEndOfIterator() {
        // given
        ConcreteAggregate aggregate = new ConcreteAggregate<String>(1);

        aggregate.set(0, "one");

        Iterator<String> iterator = aggregate.createIterator();

        iterator.next();

        // when
        boolean done = iterator.isDone();

        // then
        assertTrue(done);
    }
}