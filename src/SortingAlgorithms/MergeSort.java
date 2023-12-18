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

import java.util.List;
import java.util.function.Consumer;
import java.util.ArrayList;

public class MergeSort {

    /**
     * MergeSort algorithm implementation as a Consumer.
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the MergeSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getMergeSortAlgorithm() {
        return list -> {
            if (list != null && !list.isEmpty()) {
                mergeSort(list, 0, list.size() - 1);
            }
        };
    }

    private static <T extends Comparable<T>> void mergeSort(List<T> list, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = (left + right) / 2;

            // Sort first and second halves
            mergeSort(list, left, middle);
            mergeSort(list, middle + 1, right);

            // Merge the sorted halves
            merge(list, left, middle, right);
        }
    }

    private static <T extends Comparable<T>> void merge(List<T> list, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Create temporary arrays
        List<T> L = new ArrayList<>(n1);
        List<T> R = new ArrayList<>(n2);

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L.add(list.get(left + i));
        for (int j = 0; j < n2; ++j)
            R.add(list.get(middle + 1 + j));

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray
        int k = left;
        while (i < n1 && j < n2) {
            if (L.get(i).compareTo(R.get(j)) <= 0) {
                list.set(k, L.get(i));
                i++;
            } else {
                list.set(k, R.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            list.set(k, L.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            list.set(k, R.get(j));
            j++;
            k++;
        }
    }
}
