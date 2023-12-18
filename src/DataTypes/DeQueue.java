package DataTypes;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DeQueue<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;
    }

    public DeQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insertFirst(T item) {
        Node<T> oldFirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldFirst;
        if (isEmpty()) last = first;
        else oldFirst.prev = first;
        size++;
    }

    public void insertLast(T item) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.prev = oldLast;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    public T deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException("DeQueue is empty");
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) last = null;
        else first.prev = null;
        return item;
    }

    public T deleteLast() {
        if (isEmpty()) throw new NoSuchElementException("DeQueue is empty");
        T item = last.item;
        last = last.prev;
        size--;
        if (isEmpty()) first = null;
        else last.next = null;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new DeQueueIterator();
    }

    private class DeQueueIterator implements Iterator<T> {
        private Node<T> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}

