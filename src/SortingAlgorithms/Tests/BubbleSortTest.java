package SortingAlgorithms.Tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import SortingAlgorithms.BubbleSort;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


import org.junit.jupiter.api.Test;

public class BubbleSortTest {
    @Test
    public void testBubbleSort() {
        // Create a list of integers
        List<Integer> list = Arrays.asList(5, 3, 8, 2, 9, 1);

        // Get the BubbleSort algorithm
        Consumer<List<Integer>> bubbleSort = BubbleSort.getBubbleSortAlgorithm();

        // Sort the list
        bubbleSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test
    public void testBubbleSortEmpty() {
        // Create a list of integers
        List<Integer> list = Arrays.asList();

        // Get the BubbleSort algorithm
        Consumer<List<Integer>> bubbleSort = BubbleSort.getBubbleSortAlgorithm();

        // Sort the list
        bubbleSort.accept(list);

        assertTrue(list.isEmpty());
    }

    @Test
    public void testBubbleSortSorted() {
        // Create a list of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 9);

        // Get the BubbleSort algorithm
        Consumer<List<Integer>> bubbleSort = BubbleSort.getBubbleSortAlgorithm();

        // Sort the list
        bubbleSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }
}
