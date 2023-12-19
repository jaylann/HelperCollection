package SortingAlgorithms;

import java.util.List;
import java.util.function.Consumer;

public class StoogeSort {

    /**
     * StoogeSort algorithm implementation as a Consumer.
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the StoogeSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getStoogeSortAlgorithm() {
        return list -> stoogeSort(list, 0, list.size() - 1);
    }

    /**
     * Helper method to perform StoogeSort on a sublist.
     * @param <T> the type of elements in the list
     * @param list the list to be sorted
     * @param l the starting index of the sublist
     * @param h the ending index of the sublist
     */
    private static <T extends Comparable<T>> void stoogeSort(List<T> list, int l, int h) {
        if (list == null || list.isEmpty()) return; // Handling empty or null list

        if (l >= h) return; // Base case for recursion

        if (list.get(l).compareTo(list.get(h)) > 0) {
            // Swap elements at l and h
            T temp = list.get(l);
            list.set(l, list.get(h));
            list.set(h, temp);
        }

        if (h - l + 1 > 2) {
            int t = (h - l + 1) / 3;
            stoogeSort(list, l, h - t);
            stoogeSort(list, l + t, h);
            stoogeSort(list, l, h - t);
        }
    }
}

