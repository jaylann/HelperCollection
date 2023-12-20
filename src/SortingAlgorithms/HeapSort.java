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

public class HeapSort {

    /**
     * HeapSort algorithm implementation as a Consumer.
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the HeapSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getHeapSortAlgorithm() {
        return list -> {
            if (list == null || list.size() < 2) {
                // No sorting needed for null or single-element list
                return;
            }

            int n = list.size();

            // Build heap (rearrange array)
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(list, n, i);
            }

            // Extract elements from heap one by one
            for (int i = n - 1; i > 0; i--) {
                // Move current root to end
                T temp = list.get(0);
                list.set(0, list.get(i));
                list.set(i, temp);

                // Call max heapify on the reduced heap
                heapify(list, i, 0);
            }
        };
    }

    /**
     * To heapify a subtree rooted with node i.
     * @param list the list to be heapified
     * @param heapSize the size of the heap
     * @param i the index of the root element of the subtree
     * @param <T> the type of elements in the list
     */
    private static <T extends Comparable<T>> void heapify(List<T> list, int heapSize, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        // If left child is larger than root
        if (left < heapSize && list.get(left).compareTo(list.get(largest)) > 0) {
            largest = left;
        }

        // If right child is larger than the largest so far
        if (right < heapSize && list.get(right).compareTo(list.get(largest)) > 0) {
            largest = right;
        }

        // If largest is not root
        if (largest != i) {
            T swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(list, heapSize, largest);
        }
    }
}
