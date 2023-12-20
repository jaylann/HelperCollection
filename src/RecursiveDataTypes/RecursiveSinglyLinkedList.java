/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Mon, 18th December 2023, 18:15
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package RecursiveDataTypes;

public class RecursiveSinglyLinkedList {
    private Node head;

    private static class Node {
        int data;
        Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add element to the list
    public void add(int data) {
        head = addRecursive(head, data);
    }

    private Node addRecursive(Node current, int data) {
        if (current == null) {
            return new Node(data);
        }
        current.next = addRecursive(current.next, data);
        return current;
    }

    // Remove element from the list
    public void remove(int data) {
        head = removeRecursive(head, data);
    }

    private Node removeRecursive(Node current, int data) {
        if (current == null) {
            return null;
        }
        if (current.data == data) {
            return current.next;
        }
        current.next = removeRecursive(current.next, data);
        return current;
    }

    // Find an element in the list
    public boolean find(int data) {
        return findRecursive(head, data);
    }

    private boolean findRecursive(Node current, int data) {
        if (current == null) {
            return false;
        }
        if (current.data == data) {
            return true;
        }
        return findRecursive(current.next, data);
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    // Print the linked list
    public void printList() {
        printListRecursive(head);
        System.out.println();
    }

    private void printListRecursive(Node current) {
        if (current != null) {
            System.out.print(current.data + " ");
            printListRecursive(current.next);
        }
    }
}

