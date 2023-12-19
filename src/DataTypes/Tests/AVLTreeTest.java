package DataTypes.Tests;

import DataTypes.AVLTree;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class AVLTreeTest {

    private AVLTree<Integer> tree;

    @BeforeEach
    void init() {
        tree = new AVLTree<>();
    }

    @Test
    void testInsertAndIterator() {
        tree.insert(10, 10);
        tree.insert(15, 15);
        tree.insert(5, 5);
        Iterator<Integer> it = tree.iterator();
        assertTrue(it.hasNext());
        assertEquals(5, it.next());
        assertEquals(10, it.next());
        assertEquals(15, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testInsertAndRebalance() {
        tree.insert(3, 3);
        tree.insert(2, 2);
        tree.insert(1, 1); // This should cause a right rotation
        assertEquals(2, tree.getRoot().getValue()); // Assuming a getRoot() method for testing
    }

    @Test
    void testSearch() {
        tree.insert(20, 20);
        assertTrue(tree.search(20));
        assertFalse(tree.search(99));
    }

    @Test
    void testGet() {
        tree.insert(30, 30);
        assertEquals(30, tree.get(30));
        assertNull(tree.get(99));
    }

    @Test
    void testDeleteAndRebalance() {
        tree.insert(40, 40);
        tree.insert(50, 50);
        tree.insert(60, 60); // Insert nodes to form a straight line
        tree.delete(50); // Should trigger rebalancing
        assertEquals(60, tree.getRoot().getValue()); // Assuming a getRoot() method for testing
    }

    @Test
    void testIteratorWithTraversalType() {
        tree.insert(40, 40);
        tree.insert(30, 30);
        tree.insert(50, 50);
        Iterator<Integer> it = tree.iterator(AVLTree.TraversalType.IN_ORDER); // Assuming TraversalType is an enum or class
        assertTrue(it.hasNext());
        assertEquals(30, it.next());
        assertEquals(40, it.next());
        assertEquals(50, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    void testIteratorNoSuchElementException() {
        tree.insert(100, 100);
        Iterator<Integer> it = tree.iterator();
        assertEquals(100, it.next());
        assertThrows(NoSuchElementException.class, it::next);
    }

    // Add more tests for each method and different scenarios, including edge cases.
}
