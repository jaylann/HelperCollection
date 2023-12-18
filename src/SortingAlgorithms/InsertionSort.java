package SortingAlgorithms;

import java.util.List;
import java.util.function.Consumer;

public class InsertionSort {

    /**
     * InsertionSort algorithm implementation as a Consumer.
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the InsertionSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getInsertionSortAlgorithm() {
        return list -> {
            if (list == null || list.size() <= 1) {
                return; // No sorting needed for null or single element lists
            }

            for (int i = 1; i < list.size(); i++) {
                T key = list.get(i);
                int j = i - 1;

                // Move elements of list[0..i-1], that are greater than key,
                // to one position ahead of their current position
                while (j >= 0 && list.get(j).compareTo(key) > 0) {
                    list.set(j + 1, list.get(j));
                    j = j - 1;
                }
                list.set(j + 1, key);
            }
        };
    }
}

