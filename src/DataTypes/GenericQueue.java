/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Mon, 18th December 2023, 18:15
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package DataTypes;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class GenericQueue<T> implements Iterable<T> {
    private Node<T> first; // beginning of the queue
    private Node<T> last;  // end of the queue
    private int size;      // number of elements in the queue

    // helper linked list class
    private static class Node<T> {
        private T item;
        private Node<T> next;
    }

    public GenericQueue() {
        first = null;
        last = null;
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void insert(T item) {
        Node<T> oldLast = last;
        last = new Node<>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        size++;
    }

    public T delete() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        T item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    public Iterator<T> iterator() {
        return new QueueIterator(first);
    }

    private class QueueIterator implements Iterator<T> {
        private Node<T> current;

        public QueueIterator(Node<T> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // Test method for demonstration
    public static void main(String[] args) {
        GenericQueue<String> queue = new GenericQueue<>();
        queue.insert("Item 1");
        queue.insert("Item 2");
        queue.insert("Item 3");

        System.out.println("Queue contents:");
        for (String s : queue) {
            System.out.println(s);
        }

        System.out.println("Deleted: " + queue.delete());
        System.out.println("Deleted: " + queue.delete());
    }
}

