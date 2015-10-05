package designPatterns.iterator.classic;

public class ConcreteAggregate<T> implements Aggregate<T> {

    final Object[] array;

    public ConcreteAggregate(int count) {
        this.array = new Object[count];
    }

    public void set(int index, T value) {
        array[index] = value;
    }

    @Override
    public Iterator<T> createIterator() {
        return new ConcreteIterator<T>(this);
    }
}