package designPatterns.iterator.classic;

public interface Iterator<T> {

    void first();

    void next();

    boolean isDone();

    T currentItem();
}