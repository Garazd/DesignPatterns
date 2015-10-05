package designPatterns.iterator.sample;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {

    private Node root;
    private int modCount;

    private static class Node {
        private Node next;
        private Object value;
    }

    public LinkedList() {
        clear();
    }

    @Override
    public int size() {
        int size = 0;
        Node node = root;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean contains(Object o) {
        Node node = root;
        while (node != null) {
            Object object = node.value;
            if (object == null) {
                if (o == null) {
                    return true;
                }
            }

            if (object.equals(o)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>();
    }

    @Override
    public boolean add(T value) {
        Node last = getLast();
        last = insertAfter(last, value);
        return true;
    }

    private Node insertAfter(Node node, T value) {
        modCount++;
        if (node == null) {
            root = new Node();
            root.value = value;
            return root;
        }

        Node old = node.next;
        node.next = new Node();
        node.next.value = value;
        node.next.next = old;
        return node.next;
    }

    private Node getLast() {
        if (root == null) {
            return null;
        }

        Node node = root;
        while (node.next != null) {
            node = node.next;
        }
        return node;
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
        root = null;
        modCount++;
    }

    @Override
    public T get(int index) {
        return (T)getNode(index).value;
    }

    private Node getNode(int index) {
        if (index < 0 || (index == 0 && root == null)) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        int i = 0;
        Node node = root;
        do {
            if (i == index) {
                return node;
            }
            i++;
            node = node.next;
        } while (node != null);

        throw new ArrayIndexOutOfBoundsException(index);
    }

    @Override
    public T set(int index, T object) {
        Node node = getNode(index);
        Object old = node.value;
        node.value = object;
        modCount++;
        return (T)old;
    }

    @Override
    public void add(int index, T object) {
        if (index == 0) {
            Node old = root;
            root = new Node();
            root.value = object;
            root.next = old;
        } else {
            Node prevNode = getNode(index - 1);
            if (prevNode.next == null) {
                prevNode.next = new Node();
                prevNode.next.value = object;
            } else {
                insertAfter(prevNode, object);
            }
        }
    }

    @Override
    public T remove(int index) {
        modCount++;
        if (index == 0) {
            if (root == null) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            Object old = root.value;
            root = root.next;
            return (T)old;
        } else {
            Node prevNode = getNode(index - 1);
            Node node = prevNode.next;
            if (node == null) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            prevNode.next = node.next;
            return (T)node.value;
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        Node node = root;
        while (node != null) {
            Object value = node.value;
            if (value == null && object == null) {
                return index;
            }
            if (value.equals(object)) {
                return index;
            }
            index++;
            node = node.next;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append('[');

        Node node = root;
        while (node != null) {
            result.append(node.value);
            if (node.next != null) {
                result.append(", ");
            }
            node = node.next;
        }
        result.append(']');
        return result.toString();
    }

    private class LinkedListIterator<T> implements Iterator<T> {

        private Node curr;
        private Node prev;

        private boolean removed;

        private int expectedModCount = modCount;

        public LinkedListIterator() {
            this.curr = null;
            this.prev = null;
            this.removed = false;
        }

        @Override
        public boolean hasNext() {
            return (curr == null && prev == null && root != null)
                    || (curr != null && curr.next != null);
        }

        @Override
        public T next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            removed = false;

            if (curr == null && prev == null) {
                curr = root;
                prev = null;
                return (T)curr.value;
            } else {
                prev = curr;
                curr = curr.next;
                return (T)curr.value;
            }
        }

        @Override
        public void remove() {
            checkForComodification();
            if (removed || curr == null) {
                throw new IllegalStateException();
            }

            if (curr == root) {
                root = curr.next;
            } else if (prev != null) {
                Node next = curr.next;
                curr = prev;
                curr.next = next;
            }
            prev = null;
            removed = true;

            modCount++;
            expectedModCount = modCount;
        }

        private void checkForComodification() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
    }
}