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

public class RecursiveTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public RecursiveTree() {
        this.root = null;
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private TreeNode<T> insertRecursive(TreeNode<T> current, T value) {
        if (current == null) {
            return new TreeNode<>(value);
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public boolean find(T value) {
        return findRecursive(root, value) != null;
    }

    private TreeNode<T> findRecursive(TreeNode<T> current, T value) {
        if (current == null || value.equals(current.getValue())) {
            return current;
        }

        return value.compareTo(current.getValue()) < 0
                ? findRecursive(current.getLeft(), value)
                : findRecursive(current.getRight(), value);
    }

    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    private TreeNode<T> deleteRecursive(TreeNode<T> current, T value) {
        if (current == null) {
            return null;
        }

        if (value.equals(current.getValue())) {
            // Node to delete found
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            T smallestValue = findSmallestValue(current.getRight());
            current.setValue(smallestValue);
            current.setRight(deleteRecursive(current.getRight(), smallestValue));
            return current;
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(deleteRecursive(current.getLeft(), value));
            return current;
        }

        current.setRight(deleteRecursive(current.getRight(), value));
        return current;
    }

    private T findSmallestValue(TreeNode<T> root) {
        return root.getLeft() == null ? root.getValue() : findSmallestValue(root.getLeft());
    }

    // Additional methods like traversal can be added here
}

class TreeNode<T> {
    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
        left = null;
        right = null;
    }

    // Getters and setters
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }
}

