package designPatterns.iterator.sample;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {

    private Object[] array;
    private int modCount;

    public ArrayList() {
        clear();
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object object : array) {
            if (object == null) {
                if (o == null) {
                    return true;
                }
            }

            if (object.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<T>();
    }

    @Override
    public boolean add(T value) {
        array = Arrays.copyOf(array, size() + 1);
        array[size() - 1] = value;
        modCount++;
        return true;
    }

    @Override
    public boolean remove(Object object) {
        int index = indexOf(object);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public void clear() {
        array = new Object[0];
        modCount++;
    }

    @Override
    public T get(int index) {
        return (T)array[index];
    }

    @Override
    public T set(int index, T object) {
        Object old = array[index];
        array[index] = object;
        modCount++;
        return (T)old;
    }

    @Override
    public void add(int index, T object) {
        add(null);
        for (int i = size() - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = object;
    }

    @Override
    public T remove(int index) {
        Object old = array[index];
        modCount++;
        for (int i = index + 1; i < size(); i++) {
            array[i - 1] = array[i];
        }
        array = Arrays.copyOf(array, size() - 1);
        return (T)old;
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size(); i++) {
            if (array[i] == null && object == null) {
                return i;
            }
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    private class ArrayListIterator<T> implements Iterator<T> {

        private int cursor;  // index of next element to return
        private int lastRet; // index of last element returned; -1 if no such
        private int expectedModCount = modCount;

        public ArrayListIterator() {
            this.cursor = 0;
            this.lastRet = -1;
        }

        @Override
        public boolean hasNext() {
            return cursor != size();
        }

        @Override
        public T next() {
            checkForComodification();
            int i = cursor;
            if (i >= size()) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            return (T) ArrayList.this.get(lastRet = i);
        }

        @Override
        public void remove() {
            checkForComodification();
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            ArrayList.this.remove(lastRet);
            expectedModCount = modCount;
            cursor = lastRet;
            lastRet = -1;
        }

        private void checkForComodification() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}