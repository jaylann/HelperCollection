package SortingAlgorithms;

import java.util.List;
import java.util.function.Consumer;

public class GnomeSort {

    /**
     * GnomeSort algorithm implementation as a Consumer.
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the GnomeSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getGnomeSortAlgorithm() {
        return list -> {
            if (list == null || list.isEmpty()) return; // Handle null and empty lists

            int index = 0;
            int n = list.size();

            while (index < n) {
                if (index == 0) {
                    index++;
                }
                if (list.get(index).compareTo(list.get(index - 1)) >= 0) {
                    index++;
                } else {
                    // Swap elements
                    T temp = list.get(index);
                    list.set(index, list.get(index - 1));
                    list.set(index - 1, temp);
                    index--;
                }
            }
        };
    }
}

