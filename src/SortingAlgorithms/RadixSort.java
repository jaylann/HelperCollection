/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed, 20th December 2023, 17:00
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package SortingAlgorithms;

import java.util.List;
import java.util.function.Consumer;
import java.util.Collections;
import java.util.LinkedList;

public class RadixSort {

    /**
     * RadixSort algorithm implementation as a Consumer.
     * @return a Consumer implementing the RadixSort algorithm for lists of integers
     */
    public static Consumer<List<Integer>> getRadixSortAlgorithm() {
        return list -> {
            if (list == null || list.size() < 2) {
                return; // No sorting needed for null, empty, or single-element lists
            }

            // Find the maximum number to know the number of digits
            int max = Collections.max(list);

            // Do counting sort for every digit
            for (int exp = 1; max / exp > 0; exp *= 10) {
                countingSortByDigit(list, exp);
            }
        };
    }

    private static void countingSortByDigit(List<Integer> list, int exp) {
        int n = list.size();
        int[] output = new int[n]; // Output array
        int[] count = new int[10];

        // Initialize count array
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(list.get(i) / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains actual
        // position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(list.get(i) / exp) % 10] - 1] = list.get(i);
            count[(list.get(i) / exp) % 10]--;
        }

        // Copy the output array to list
        for (int i = 0; i < n; i++) {
            list.set(i, output[i]);
        }
    }
}
