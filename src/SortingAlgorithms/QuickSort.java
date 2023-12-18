package SortingAlgorithms;

import java.util.List;
import java.util.function.Consumer;

public class QuickSort {

    /**
     * QuickSort algorithm implementation as a Consumer.
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the QuickSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getQuickSortAlgorithm() {
        return list -> {
            if (list != null && !list.isEmpty()) {
                quickSort(list, 0, list.size() - 1);
            }
        };
    }

    private static <T extends Comparable<T>> void quickSort(List<T> list, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(list, low, high);

            // Recursively sort elements before and after partition
            quickSort(list, low, partitionIndex - 1);
            quickSort(list, partitionIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(List<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                i++;

                // Swap list[i] and list[j]
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }

        // Swap list[i+1] and list[high] (or pivot)
        T temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);

        return i + 1;
    }
}

