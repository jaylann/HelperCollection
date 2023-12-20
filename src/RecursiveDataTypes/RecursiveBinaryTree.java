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

// Class representing a node in the binary tree
class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    // Constructor
    BinaryTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

// Class representing the binary tree
public class RecursiveBinaryTree {
    private BinaryTreeNode root;

    // Constructor
    public RecursiveBinaryTree() {
        root = null;
    }

    // Insert method
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    // Recursive insert helper
    private BinaryTreeNode insertRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return new BinaryTreeNode(value);
        }

        if (value < current.value) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = insertRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    // Search method
    public boolean containsNode(int value) {
        return containsNodeRecursive(root, value);
    }

    // Recursive search helper
    private boolean containsNodeRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        return value < current.value
                ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);
    }

    // Delete method
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    // Recursive delete helper
    private BinaryTreeNode deleteRecursive(BinaryTreeNode current, int value) {
        if (current == null) {
            return null;
        }

        if (value == current.value) {
            // Node to delete found
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only one child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: two children
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    // Helper to find the smallest value (used in delete)
    private int findSmallestValue(BinaryTreeNode root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    // Method to traverse the tree in order
    public void traverseInOrder(BinaryTreeNode node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }
}

