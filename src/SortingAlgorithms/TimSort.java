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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TimSort {

    private static final int RUN = 32;

    /**
     * TimSort algorithm implementation as a Consumer.
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the TimSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getTimSortAlgorithm() {
        return list -> {
            if (list == null || list.size() < 2) {
                return; // No sorting needed for null or single-element list
            }

            int n = list.size();
            // Sort individual subarrays of size RUN
            for (int i = 0; i < n; i += RUN) {
                insertionSort(list, i, Math.min((i + RUN - 1), (n - 1)));
            }

            // Merge sorted subarrays
            for (int size = RUN; size < n; size = 2 * size) {
                for (int left = 0; left < n; left += 2 * size) {
                    int mid = left + size - 1;
                    int right = Math.min((left + 2 * size - 1), (n - 1));

                    if (mid < right) {
                        merge(list, left, mid, right);
                    }
                }
            }
        };
    }

    private static <T extends Comparable<T>> void insertionSort(List<T> list, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            T temp = list.get(i);
            int j = i - 1;
            while (j >= left && list.get(j).compareTo(temp) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, temp);
        }
    }

    private static <T extends Comparable<T>> void merge(List<T> list, int l, int m, int r) {
        // Create two temporary lists
        List<T> leftList = new ArrayList<>(list.subList(l, m + 1));
        List<T> rightList = new ArrayList<>(list.subList(m + 1, r + 1));

        int i = 0, j = 0, k = l;

        // Merge the temp lists
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i).compareTo(rightList.get(j)) <= 0) {
                list.set(k, leftList.get(i));
                i++;
            } else {
                list.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        // Copy remaining elements if any
        while (i < leftList.size()) {
            list.set(k, leftList.get(i));
            i++;
            k++;
        }
        while (j < rightList.size()) {
            list.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
}
