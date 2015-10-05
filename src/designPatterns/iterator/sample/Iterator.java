package designPatterns.iterator.sample;

public interface Iterator<T> {

    boolean hasNext();

    T next();

    void remove();
}