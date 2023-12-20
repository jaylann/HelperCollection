package RecursiveDataTypes;

public class RecursiveDeque<T> {
    private class Node {
        T data;
        Node next;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    // Add element at the front of the deque
    public void addFirst(T data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    // Add element at the end of the deque
    public void addLast(T data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Remove element from the front of the deque recursively
    public T removeFirst() {
        if (head == null) {
            return null;
        }
        return removeFirstRecursive(head);
    }

    private T removeFirstRecursive(Node node) {
        if (node.next == null) {
            T data = head.data;
            head = tail = null;
            return data;
        }
        head = head.next;
        head.prev = null;
        return node.data;
    }

    // Remove element from the end of the deque recursively
    public T removeLast() {
        if (tail == null) {
            return null;
        }
        return removeLastRecursive(tail);
    }

    private T removeLastRecursive(Node node) {
        if (node.prev == null) {
            T data = tail.data;
            head = tail = null;
            return data;
        }
        tail = tail.prev;
        tail.next = null;
        return node.data;
    }

    // Optional: Method to display the contents of the deque
    public void display() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }
}

// Example usage:
/*
public class Main {
    public static void main(String[] args) {
        RecursiveDeque<Integer> deque = new RecursiveDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        deque.addLast(3);

        deque.display(); // Expected output: 0 1 2 3

        System.out.println("Removed from front: " + deque.removeFirst()); // 0
        System.out.println("Removed from end: " + deque.removeLast()); // 3

        deque.display(); // Expected output: 1 2
    }
}
*/
