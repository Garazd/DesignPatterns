package designPatterns.iterator.sample;

import java.lang.*;

public interface List<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    Iterator<T> iterator();

    boolean add(T object);

    boolean remove(Object object);

    void clear();

    T get(int index);

    T set(int index, T object);

    void add(int index, T object);

    T remove(int index);

    int indexOf(Object object);
}