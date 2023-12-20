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

public class ShellSort {

    /**
     * ShellSort algorithm implementation as a Consumer.
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the ShellSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getShellSortAlgorithm() {
        return list -> {
            if (list == null || list.size() < 2) {
                return; // No sorting needed for null or single-element lists
            }

            int n = list.size();

            // Start with a large gap, then reduce the gap
            for (int gap = n / 2; gap > 0; gap /= 2) {
                // Perform a "gapped" insertion sort for this gap size
                for (int i = gap; i < n; i++) {
                    // Add list[i] to the elements that have been gap-sorted
                    // Save list[i] in temp and make a hole at position i
                    T temp = list.get(i);

                    // Shift earlier gap-sorted elements up until the correct location for list[i] is found
                    int j;
                    for (j = i; j >= gap && list.get(j - gap).compareTo(temp) > 0; j -= gap) {
                        list.set(j, list.get(j - gap));
                    }

                    // Put temp (the original list[i]) in its correct location
                    list.set(j, temp);
                }
            }
        };
    }
}
