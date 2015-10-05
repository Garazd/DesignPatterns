package designPatterns.iterator.classic;

public interface Aggregate<T> {

    Iterator<T> createIterator();
}