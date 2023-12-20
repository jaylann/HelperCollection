/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed, 20th December 2023, 17:00
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package RecursiveDataTypes;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

public class RecursiveStack<T> {
    private Node<T> top;

    public Node<T> getTop() {
        return top;
    }

    public void setTop(Node<T> top) {
        this.top = top;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    private int size;
    private final int maxSize;

    public RecursiveStack(int maxSize) {
        this.top = null;
        this.size = 0;
        this.maxSize = maxSize;
    }

    public void push(T data) throws StackOverflowError {
        if (size == maxSize) {
            throw new StackOverflowError("Stack overflow: Cannot push to a full stack");
        }
        top = pushRecursive(top, data);
        size++;
    }

    private Node<T> pushRecursive(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        } else {
            Node<T> newNode = new Node<>(data);
            newNode.next = node;
            return newNode;
        }
    }

    public T pop() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow: Cannot pop from an empty stack");
        }
        T data = top.data;
        top = popRecursive(top);
        size--;
        return data;
    }

    private Node<T> popRecursive(Node<T> node) {
        return node.next;
    }

    public T peek() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("Stack underflow: Cannot peek in an empty stack");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }
}

