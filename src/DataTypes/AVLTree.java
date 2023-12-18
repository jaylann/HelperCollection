package DataTypes;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class AVLTree<T extends Comparable<T>> {

    private enum TraversalType {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }

    private class Node {
        T key;
        int height;
        Node left, right;

        public Node(T key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node root;

    public void insert(T key) {
        root = insert(root, key);
    }

    private Node insert(Node node, T key) {
        if (node == null) {
            return new Node(key);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key);
        } else if (cmp > 0) {
            node.right = insert(node.right, key);
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

    private class AVLTreeIterator implements Iterator<T> {
        private Stack<Node> stack = new Stack<>();
        private TraversalType traversalType;

        public AVLTreeIterator(Node root, TraversalType traversalType) {
            this.traversalType = traversalType;
            pushLeft(root);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();

            Node current = stack.pop();
            T key = current.key;

            if (traversalType == TraversalType.IN_ORDER) {
                if (current.right != null) {
                    pushLeft(current.right);
                }
            } else if (traversalType == TraversalType.PRE_ORDER) {
                // Implementation for pre-order
            } else if (traversalType == TraversalType.POST_ORDER) {
                // Implementation for post-order
            }

            return key;
        }
    }
}
