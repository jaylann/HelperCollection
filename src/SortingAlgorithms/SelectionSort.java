package SortingAlgorithms;

import java.util.List;
import java.util.function.Consumer;

public class SelectionSort {

    /**
     * SelectionSort algorithm implementation as a Consumer.
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the SelectionSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getSelectionSortAlgorithm() {
        return list -> {
            if (list == null || list.size() < 2) {
                return; // No sorting needed for null, empty, or single-element lists
            }

            int n = list.size();
            for (int i = 0; i < n - 1; i++) {
                // Find the minimum element in the unsorted part of the list
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (list.get(j).compareTo(list.get(minIndex)) < 0) {
                        minIndex = j;
                    }
                }

                // Swap the found minimum element with the first element of the unsorted part
                if (minIndex != i) {
                    T temp = list.get(minIndex);
                    list.set(minIndex, list.get(i));
                    list.set(i, temp);
                }
            }
        };
    }
}
