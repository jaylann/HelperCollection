package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class MegaMergeSort {

    /**
     * MegaMergeSort algorithm implementation as a Consumer.
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the MegaMergeSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getMegaMergeSortAlgorithm() {
        return list -> {
            if (list == null || list.size() < 2) {
                return; // Handling null and single-element lists
            }

            int n = list.size();
            ArrayList<T> auxiliaryList = new ArrayList<>(Collections.nCopies(n, null));
            // Iteratively merge sub-arrays of increasing sizes
            for (int currSize = 1; currSize <= n - 1; currSize = 2 * currSize) {
                for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * currSize) {
                    int mid = Math.min(leftStart + currSize - 1, n - 1);
                    int rightEnd = Math.min(leftStart + 2 * currSize - 1, n - 1);

                    merge(list, auxiliaryList, leftStart, mid, rightEnd);
                }
            }
        };
    }

    private static <T extends Comparable<T>> void merge(List<T> list, List<T> auxiliaryList, int left, int middle, int right) {
        // Copy data to auxiliary list
        for (int i = left; i <= right; i++) {
            auxiliaryList.set(i, list.get(i));
        }

        int i = left;
        int j = middle + 1;
        int k = left;

        // Merge the two halves back into the original list
        while (i <= middle && j <= right) {
            if (auxiliaryList.get(i).compareTo(auxiliaryList.get(j)) <= 0) {
                list.set(k++, auxiliaryList.get(i++));
            } else {
                list.set(k++, auxiliaryList.get(j++));
            }
        }

        // Copy the remaining elements of left half, if any
        while (i <= middle) {
            list.set(k++, auxiliaryList.get(i++));
        }
        // No need to copy the second half as they are already in proper position
    }
}
