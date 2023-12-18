/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Mon, 18th December 2023, 18:15
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Utility class for sorting collections.
 * Provides static methods for sorting both Lists and Iterables.
 */
public class Sortable {

    /**
     * Static method to sort a list using the provided sorting algorithm.
     * @param <T> the type of elements in the list
     * @param list the list to be sorted
     * @param sortingAlgorithm the sorting algorithm to be applied
     */
    public static <T extends Comparable<T>> void sort(List<T> list, Consumer<List<T>> sortingAlgorithm) {
        validateListNotNull(list);
        sortingAlgorithm.accept(list);
    }

    /**
     * Static method to sort an iterable by first converting it into a list.
     * The provided sorting algorithm is then applied.
     * @param <T> the type of elements in the iterable
     * @param iterable the iterable to be sorted
     * @param sortingAlgorithm the sorting algorithm to be applied
     * @return a sorted List
     */
    public static <T extends Comparable<T>> List<T> sort(Iterable<T> iterable, Consumer<List<T>> sortingAlgorithm) {
        validateIterableNotNull(iterable);
        List<T> list = new ArrayList<>();
        iterable.forEach(list::add);
        sortingAlgorithm.accept(list);
        return list;
    }

    /**
     * Validates that the list is not null.
     * @param <T> the type of elements in the list
     * @param list the list to be validated
     * @throws IllegalArgumentException if the list is null
     */
    private static <T> void validateListNotNull(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null.");
        }
    }

    /**
     * Validates that the iterable is not null.
     * @param <T> the type of elements in the iterable
     * @param iterable the iterable to be validated
     * @throws IllegalArgumentException if the iterable is null
     */
    private static <T> void validateIterableNotNull(Iterable<T> iterable) {
        if (iterable == null) {
            throw new IllegalArgumentException("Iterable cannot be null.");
        }
    }
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);

        // Sorting a list using BubbleSort
        Sortable.sort(numbers, BubbleSort.getBubbleSortAlgorithm());
        System.out.println("Sorted List: " + numbers);

        // Sorting an iterable (e.g., an array) using BubbleSort
        Integer[] numberArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Sortable.sort(Arrays.asList(numberArray), BubbleSort.getBubbleSortAlgorithm());
        System.out.println("Sorted Iterable: " + Arrays.toString(numberArray));
    }
}
