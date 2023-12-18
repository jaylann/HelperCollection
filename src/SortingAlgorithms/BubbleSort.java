package SortingAlgorithms;

import java.util.List;
import java.util.function.Consumer;

public class BubbleSort {

    /**
     * BubbleSort algorithm implementation as a Consumer.
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the BubbleSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getBubbleSortAlgorithm() {
        return list -> {
            boolean swapped;
            int n = list.size();
            do {
                swapped = false;
                for (int i = 1; i < n; i++) {
                    if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                        // Swap elements
                        T temp = list.get(i);
                        list.set(i, list.get(i - 1));
                        list.set(i - 1, temp);
                        swapped = true;
                    }
                }
                n--; // Each iteration, the largest element "bubbles up" to its correct position
            } while (swapped);
        };
    }
}
