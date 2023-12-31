/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed, 20th December 2023, 17:00
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package DataTypes;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private class Node {
        T data;

        public void setData(T data) {
            this.data = data;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        Node left, right;

        public Node(T data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    private Node insert(Node node, T data) {
        if (node == null) {
            return new Node(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insert(node.left, data);
        } else if (cmp > 0) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public void delete(T data) {
        root = delete(root, data);
    }

    private Node delete(Node node, T data) {
        if (node == null) return null;

        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete(node.left, data);
        } else if (cmp > 0) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        return node;
    }

    private Node deleteMin(Node node) {
        if (node.left == null) return node.right;
        node.left = deleteMin(node.left);
        return node;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        return min(node.left);
    }

    public Iterator<T> iterator(TraversalOrder order) {
        return new BSTIterator(order);
    }

    private class BSTIterator implements Iterator<T> {
        public Stack<Node> getStack() {
            return stack;
        }

        public void setStack(Stack<Node> stack) {
            this.stack = stack;
        }

        public TraversalOrder getOrder() {
            return order;
        }

        public void setOrder(TraversalOrder order) {
            this.order = order;
        }

        private Stack<Node> stack = new Stack<>();
        private TraversalOrder order;

        public BSTIterator(TraversalOrder order) {
            this.order = order;
            switch (order) {
                case IN_ORDER:
                    pushLeft(root);
                    break;
                case PRE_ORDER:
                    if (root != null) stack.push(root);
                    break;
                case POST_ORDER:
                    pushNodes(root);
                    break;
            }
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        private void pushNodes(Node node) {
            if (node == null) return;
            stack.push(node);
            if (node.right != null) pushNodes(node.right);
            if (node.left != null) pushNodes(node.left);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            Node node = stack.pop();
            if (order == TraversalOrder.IN_ORDER && node.right != null) {
                pushLeft(node.right);
            }
            return node.data;
        }
    }

    public enum TraversalOrder {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }
}

