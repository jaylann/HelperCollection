/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed, 20th December 2023, 17:00
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */ package SortingAlgorithms.Tests;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import SortingAlgorithms.CountingSort;

public class CountingSortTest {
    @Test
    void testGetCountingSortAlgorithm() {
                // Create a list of integers
        List<Integer> list = Arrays.asList(5, 3, 8, 2, 9, 1);

        // Get the BubbleSort algorithm
        Consumer<List<Integer>> bubbleSort = CountingSort.getCountingSortAlgorithm();

        // Sort the list
        bubbleSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test
    void testGetCountingSortAlgorithmSorted() {
                // Create a list of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 9);

        // Get the BubbleSort algorithm
        Consumer<List<Integer>> bubbleSort = CountingSort.getCountingSortAlgorithm();
        // Sort the list
        bubbleSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test
    void testGetCountingSortAlgorithmEmpty() {
                // Create a list of integers
        List<Integer> list = Arrays.asList();

        // Get the BubbleSort algorithm
        Consumer<List<Integer>> bubbleSort = CountingSort.getCountingSortAlgorithm();

        // Sort the list
        bubbleSort.accept(list);

        assertTrue(list.isEmpty());
    }

    @Test
    void testGetCountingSortAlgorithmDuplicates() {
                // Create a list of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 1, 5, 9);;

        // Get the BubbleSort algorithm
        Consumer<List<Integer>> bubbleSort = CountingSort.getCountingSortAlgorithm();

        // Sort the list
        bubbleSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }
}
        