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
import java.util.Stack;

public class AVLTree<T extends Comparable<T>> implements Iterable<T> {

    @Override
    public Iterator<T> iterator() {
        return iterator(TraversalType.IN_ORDER);
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public enum TraversalType {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }

    public T get(T key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    // Helper method to find a node with a given key
    private Node getNode(Node node, T key) {
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node; // Key found
            }
        }
        return null; // Key not found
    }

    // Method to check if a key exists in the tree
    public boolean search(T key) {
        return getNode(root, key) != null;
    }


    public class Node {
        T key;

        public void setKey(T key) {
            this.key = key;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        T value;
        int height;
        Node left;

        public T getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public int getHeight() {
            return height;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        Node right;

        public Node(T key, T value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }

    private Node root;

    public void insert(T key, T value) {
        root = insert(root, key, value);
    }

    private Node insert(Node node, T key, T value) {
        if (node == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, key, value);
        } else {
            return node; // Duplicate keys not allowed
        }

        updateHeight(node);
        return rebalance(node);
    }

    public void delete(T key) {
        root = delete(root, key);
    }

    private Node delete(Node node, T key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.value = mostLeftChild.value; // Update the value as well
                node.right = delete(node.right, mostLeftChild.key);
            }

        }

        if (node != null) {
            updateHeight(node);
            node = rebalance(node);
        }

        return node;
    }

    private Node mostLeftChild(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node rebalance(Node z) {
        int balance = getBalance(z);
        if (balance > 1) {
            if (getBalance(z.left) < 0) {
                z.left = rotateLeft(z.left);
            }
            return rotateRight(z);
        } else if (balance < -1) {
            if (getBalance(z.right) > 0) {
                z.right = rotateRight(z.right);
            }
            return rotateLeft(z);
        }
        return z;
    }

    private Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        updateHeight(x);
        updateHeight(y);
        return y;
    }

    private int height(Node N) {
        return N == null ? 0 : N.height;
    }

    private void updateHeight(Node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int getBalance(Node N) {
        return N == null ? 0 : height(N.left) - height(N.right);
    }

    public Iterator<T> iterator(TraversalType traversalType) {
        return new AVLTreeIterator(root, traversalType);
    }

    public Node getRoot() {
        return root;
    }

    private class AVLTreeIterator implements Iterator<T> {
        private Stack<Node> stack = new Stack<>();
        private TraversalType traversalType;

        public Stack<Node> getStack() {
            return stack;
        }

        public void setStack(Stack<Node> stack) {
            this.stack = stack;
        }

        public TraversalType getTraversalType() {
            return traversalType;
        }

        public void setTraversalType(TraversalType traversalType) {
            this.traversalType = traversalType;
        }

        public Node getLastNodeVisited() {
            return lastNodeVisited;
        }

        public void setLastNodeVisited(Node lastNodeVisited) {
            this.lastNodeVisited = lastNodeVisited;
        }

        private Node lastNodeVisited; // Needed for post-order traversal

        public AVLTreeIterator(Node root, TraversalType traversalType) {
            this.traversalType = traversalType;
            if (traversalType == TraversalType.PRE_ORDER) {
                pushPreOrder(root);
            } else {
                pushLeft(root);
            }
            lastNodeVisited = null;
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        private void pushPreOrder(Node node) {
            if (node != null) {
                stack.push(node);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();

            Node current;
            switch (traversalType) {
                case IN_ORDER:
                    current = stack.pop();
                    T key = current.key;
                    if (current.right != null) {
                        pushLeft(current.right);
                    }
                    return key;

                case PRE_ORDER:
                    current = stack.pop();
                    T keyValue = current.key;
                    if (current.right != null) {
                        pushPreOrder(current.right);
                    }
                    if (current.left != null) {
                        pushPreOrder(current.left);
                    }
                    return keyValue;

                case POST_ORDER:
                    while (true) {
                        current = stack.peek();
                        if (current.right != null && lastNodeVisited != current.right) {
                            pushLeft(current.right);
                        } else if (current.left == null || lastNodeVisited == current) {
                            stack.pop();
                            lastNodeVisited = current;
                            return current.key;
                        } else {
                            lastNodeVisited = null;
                        }
                    }

                default:
                    throw new UnsupportedOperationException("Unsupported traversal type");
            }
        }
    }

}

