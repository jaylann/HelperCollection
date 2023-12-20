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

import SortingAlgorithms.RadixSort;

public class RadixSortTest {
        @Test
    public void testRadixSort() {
        // Create a list of integers
        List<Integer> list = Arrays.asList(5, 3, 8, 2, 9, 1);

        // Get the RadixSort algorithm
        Consumer<List<Integer>> radixSort = RadixSort.getRadixSortAlgorithm();

        // Sort the list
        radixSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test
    public void testRadixSortEmpty() {
        // Create a list of integers
        List<Integer> list = Arrays.asList();

        // Get the RadixSort algorithm
        Consumer<List<Integer>> radixSort = RadixSort.getRadixSortAlgorithm();

        // Sort the list
        radixSort.accept(list);

        assertTrue(list.isEmpty());
    }

    @Test
    public void testRadixSortSorted() {
        // Create a list of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 9);

        // Get the RadixSort algorithm
        Consumer<List<Integer>> radixSort = RadixSort.getRadixSortAlgorithm();

        // Sort the list
        radixSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test
    void testRadixSortDuplicates() {
                // Create a list of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 1, 5, 9);;

        // Get the RadixSort algorithm
        Consumer<List<Integer>> radixSort = RadixSort.getRadixSortAlgorithm();

        // Sort the list
        radixSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }
}
