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
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    private static class Node<T> {
        T data;
        Node<T> left, right;

        Node(T data) {
            this.data = data;
        }
    }

    public void insert(T data) {
        root = insertRec(root, data);
    }

    private Node<T> insertRec(Node<T> root, T data) {
        if (root == null) {
            root = new Node<>(data);
            return root;
        }
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public void delete(T data) {
        root = deleteRec(root, data);
    }

    private Node<T> deleteRec(Node<T> root, T data) {
        if (root == null) return null;
        if (data.compareTo(root.data) < 0) {
            root.left = deleteRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private T minValue(Node<T> root) {
        T minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public enum Traversal {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }

    public class BinaryTreeIterator implements Iterator<T> {
        private Stack<Node<T>> stack;

        public Stack<Node<T>> getStack() {
            return stack;
        }

        public void setStack(Stack<Node<T>> stack) {
            this.stack = stack;
        }

        public Traversal getTraversalType() {
            return traversalType;
        }

        public void setTraversalType(Traversal traversalType) {
            this.traversalType = traversalType;
        }

        private Traversal traversalType;

        public BinaryTreeIterator(Traversal traversalType) {
            this.traversalType = traversalType;
            stack = new Stack<>();
            if (traversalType == Traversal.PRE_ORDER) {
                pushLeft(root);
            } else if (traversalType == Traversal.POST_ORDER) {
                pushLeftRight(root);
            } else {
                pushLeftInOrder(root);
            }
        }

        private void pushLeft(Node<T> node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        private void pushLeftRight(Node<T> node) {
            while (node != null) {
                stack.push(node);
                if (node.left != null) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
        }

        private void pushLeftInOrder(Node<T> node) {
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
            Node<T> node = stack.pop();
            if (traversalType == Traversal.IN_ORDER) {
                pushLeftInOrder(node.right);
            } else if (traversalType == Traversal.PRE_ORDER && node.right != null) {
                pushLeft(node.right);
            } else if (traversalType == Traversal.POST_ORDER) {
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
                if (!stack.isEmpty()) {
                    pushLeftRight(stack.peek().right);
                }
            }
            return node.data;
        }
    }

    // Additional methods can be added here
}
