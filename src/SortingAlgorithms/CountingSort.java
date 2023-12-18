package SortingAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class CountingSort {

    /**
     * Counting Sort algorithm implementation as a Consumer.
     * @return a Consumer implementing the Counting Sort algorithm for a list of Integers.
     */
    public static Consumer<List<Integer>> getCountingSortAlgorithm() {
        return list -> {
            if (list == null || list.isEmpty()) return; // Handling null or empty list

            // Finding the maximum value in the list to determine the range of counting array
            Integer max = Collections.max(list, (a, b) -> {
                if (a == null) return -1;
                if (b == null) return 1;
                return a.compareTo(b);
            });

            if (max == null) return; // Handling list with all null values

            int[] count = new int[max + 1];

            // Count each element
            for (Integer item : list) {
                if (item != null) {
                    count[item]++;
                }
            }

            // Reconstruct the sorted list
            int index = 0;
            for (int i = 0; i < count.length; i++) {
                while (count[i] > 0) {
                    list.set(index++, i);
                    count[i]--;
                }
            }
        };
    }
}
