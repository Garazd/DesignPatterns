package designPatterns.iterator.classic;

import java.util.NoSuchElementException;

public class ConcreteIterator<T> implements Iterator<T> {

    private ConcreteAggregate<T> aggregate;
    private int index;

    public ConcreteIterator(ConcreteAggregate<T> aggregate) {
        this.aggregate = aggregate;
        first();
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        index++;
    }

    @Override
    public boolean isDone() {
        return index >= size();
    }

    private int size() {
        return aggregate.array.length;
    }

    @Override
    public T currentItem() {
        if (isDone()) {
            throw new NoSuchElementException();
        }
        return (T)aggregate.array[index];
    }
}