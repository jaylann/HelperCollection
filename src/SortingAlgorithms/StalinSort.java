package SortingAlgorithms;

import java.util.List;
import java.util.function.Consumer;
import java.util.Iterator;

public class StalinSort {

    /**
     * StalinSort algorithm implementation as a Consumer.
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the StalinSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getStalinSortAlgorithm() {
        return list -> {
            if (list == null || list.size() < 2) return; // No sorting needed for null or single-element list

            Iterator<T> iterator = list.iterator();
            T current = iterator.next();
            while (iterator.hasNext()) {
                T next = iterator.next();
                if (next == null || current.compareTo(next) > 0) {
                    iterator.remove(); // Remove the element if it's not in the correct order
                } else {
                    current = next;
                }
            }
        };
    }
}
