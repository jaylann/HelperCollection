/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed, 20th December 2023, 17:00
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package DataTypes.Tests;

import static org.junit.Assert.*;

import DataTypes.BinaryHeap;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinaryHeapTest {

    private BinaryHeap<Integer> minHeap;
    private BinaryHeap<Integer> maxHeap;

    @Before
    public void setUp() {
        minHeap = new BinaryHeap<>(true); // assuming true is for minHeap
        maxHeap = new BinaryHeap<>(false); // assuming false is for maxHeap
    }

    @Test
    public void testIsEmptyOnNewHeap() {
        assertTrue(minHeap.isEmpty());
        assertTrue(maxHeap.isEmpty());
    }

    @Test
    public void testInsertAndDelete() {
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(2);
        assertFalse(minHeap.isEmpty());
        assertEquals(Integer.valueOf(1), minHeap.delete());

        maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(2);
        assertFalse(maxHeap.isEmpty());
        assertEquals(Integer.valueOf(3), maxHeap.delete());
    }

    @Test
    public void testSize() {
        minHeap.insert(3);
        minHeap.insert(1);
        assertEquals(2, minHeap.size());
    }

    @Test
    public void testGetHeap() {
        minHeap.insert(3);
        minHeap.insert(1);
        ArrayList<Integer> heapContent = minHeap.getHeap();
        assertNotNull(heapContent);
        assertTrue(heapContent.contains(1));
        assertTrue(heapContent.contains(3));
    }

    @Test
    public void testIsMinHeapProperty() {
        minHeap.insert(3);
        minHeap.insert(1);
        assertTrue(minHeap.isMinHeap());
    }

    @Test(expected = NoSuchElementException.class)
    public void testDeleteFromEmptyHeap() {
        minHeap.delete();
    }

    @Test
    public void testIterator() {
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(2);

        Iterator<Integer> iterator = minHeap.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(3), iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElement() {
        Iterator<Integer> iterator = minHeap.iterator();
        iterator.next(); // should throw NoSuchElementException
    }

    // Additional tests to consider:
    // - Inserting the same value multiple times
    // - Deleting until the heap is empty and checking size
    // - Testing the heap property after several inserts and deletes
    // - Testing the iterator on an empty heap
    // - Testing the iterator's remove method if implemented
    // - Thread safety tests if the heap is supposed to be thread-safe
}
