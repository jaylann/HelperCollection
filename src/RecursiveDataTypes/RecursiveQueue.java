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

public class RecursiveQueue<T> {
    private Node<T> front;
    private Node<T> rear;

    private static class Node<T> {
        T data;
        Node<T> next;

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

        Node(T data) {
            this.data = data;
        }
    }

    public RecursiveQueue() {
        this.front = null;
        this.rear = null;
    }

    // Enqueue element recursively
    public void enqueue(T element) {
        if (rear == null) {
            rear = new Node<>(element);
            front = rear;
        } else {
            enqueueRecursive(rear, element);
        }
    }

    private void enqueueRecursive(Node<T> node, T element) {
        if (node.next == null) {
            node.next = new Node<>(element);
            rear = node.next;
        } else {
            enqueueRecursive(node.next, element);
        }
    }

    public Node<T> getFront() {
        return front;
    }

    public void setFront(Node<T> front) {
        this.front = front;
    }

    public Node<T> getRear() {
        return rear;
    }

    public void setRear(Node<T> rear) {
        this.rear = rear;
    }

    // Dequeue element recursively
    public T dequeue() throws IllegalStateException {
        if (front == null) {
            throw new IllegalStateException("Queue is empty");
        }
        return dequeueRecursive(null, front);
    }

    private T dequeueRecursive(Node<T> prev, Node<T> current) {
        if (current == front) {
            T data = front.data;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            return data;
        }
        return dequeueRecursive(current, current.next);
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // For testing and demonstration
    public static void main(String[] args) {
        RecursiveQueue<Integer> queue = new RecursiveQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}

