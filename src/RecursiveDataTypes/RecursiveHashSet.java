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

public class RecursiveHashSet<T extends Comparable<T>> {
    private class Node {
        T value;
        Node left, right;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public RecursiveHashSet() {
        root = null;
    }

    public boolean add(T value) {
        if (root == null) {
            root = new Node(value);
            return true;
        }
        return addRecursive(root, value);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private boolean addRecursive(Node current, T value) {
        int cmp = value.compareTo(current.value);
        if (cmp == 0) {
            // Value already exists in the set
            return false;
        } else if (cmp < 0) {
            if (current.left == null) {
                current.left = new Node(value);
                return true;
            } else {
                return addRecursive(current.left, value);
            }
        } else {
            if (current.right == null) {
                current.right = new Node(value);
                return true;
            } else {
                return addRecursive(current.right, value);
            }
        }
    }

    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(Node current, T value) {
        if (current == null) {
            return false;
        }
        int cmp = value.compareTo(current.value);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return containsRecursive(current.left, value);
        } else {
            return containsRecursive(current.right, value);
        }
    }

    public boolean remove(T value) {
        if (root == null) {
            return false;
        }
        return removeRecursive(null, root, value);
    }

    private boolean removeRecursive(Node parent, Node current, T value) {
        if (current == null) {
            return false;
        }
        int cmp = value.compareTo(current.value);
        if (cmp == 0) {
            // Node with value found, remove it
            if (current.left == null && current.right == null) {
                // Node is a leaf
                replaceChild(parent, current, null);
            } else if (current.left != null && current.right != null) {
                // Node has two children
                T minValue = findMinValue(current.right);
                current.value = minValue;
                removeRecursive(current, current.right, minValue);
            } else {
                // Node has one child
                Node child = (current.left != null) ? current.left : current.right;
                replaceChild(parent, current, child);
            }
            return true;
        } else if (cmp < 0) {
            return removeRecursive(current, current.left, value);
        } else {
            return removeRecursive(current, current.right, value);
        }
    }

    private void replaceChild(Node parent, Node current, Node child) {
        if (parent == null) {
            root = child;
        } else if (parent.left == current) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }

    private T findMinValue(Node node) {
        return node.left == null ? node.value : findMinValue(node.left);
    }
}
