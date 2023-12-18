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

public class CircularLinkedList<T> implements Iterable<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the size of the list
    public int size() {
        return size;
    }

    // Insert element at the end of the list
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        size++;
    }

    // Delete the first occurrence of an element
    public boolean delete(T data) {
        if (isEmpty()) {
            return false;
        }

        Node<T> current = head;
        Node<T> previous = tail;

        do {
            if (current.data.equals(data)) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                    if (current == tail) {
                        tail = previous;
                    }
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            private boolean hasIterated = false;

            @Override
            public boolean hasNext() {
                return !isEmpty() && (!hasIterated || current != head);
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                hasIterated = true;
                return data;
            }
        };
    }

    // Display the elements of the list
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<T> temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(head)");
    }
}
