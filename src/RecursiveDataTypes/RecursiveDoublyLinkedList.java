package RecursiveDataTypes;

public class RecursiveDoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

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

        public Node<T> getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        Node(T data) {
            this.data = data;
        }
    }

    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
        } else {
            addRecursive(data, head);
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    private void addRecursive(T data, Node<T> current) {
        if (current.next == null) {
            Node<T> newNode = new Node<>(data);
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            addRecursive(data, current.next);
        }
    }

    public boolean remove(T data) {
        if (head == null) {
            return false;
        } else {
            return removeRecursive(data, head);
        }
    }

    private boolean removeRecursive(T data, Node<T> current) {
        if (current == null) {
            return false;
        }

        if (current.data.equals(data)) {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }

            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }

            return true;
        }

        return removeRecursive(data, current.next);
    }

    public void printList() {
        printListRecursive(head);
    }

    private void printListRecursive(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            printListRecursive(node.next);
        }
    }

    public static void main(String[] args) {
        RecursiveDoublyLinkedList<Integer> list = new RecursiveDoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        list.printList(); // Prints: 1 2 3

        list.remove(2);
        list.printList(); // Prints: 1 3
    }
}

