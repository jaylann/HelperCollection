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
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class BucketSort {

    /**
     * BucketSort algorithm implementation as a Consumer.
     *
     * @param <T> the type of elements in the list
     * @return a Consumer implementing the BucketSort algorithm
     */
    public static <T extends Comparable<T>> Consumer<List<T>> getBucketSortAlgorithm() {
        return list -> {
            if (list == null || list.size() <= 1) {
                return; // No sorting needed for null, empty, or single-element lists
            }

            // Find the minimum and maximum elements to determine the range
            T min = list.get(0);
            T max = list.get(0);
            for (T element : list) {
                if (element.compareTo(min) < 0) min = element;
                if (element.compareTo(max) > 0) max = element;
            }

            // Create buckets
            int bucketCount = calculateOptimalBucketCount(list.size());
            List<List<T>> buckets = new ArrayList<>(bucketCount);
            for (int i = 0; i < bucketCount; i++) {
                buckets.add(new ArrayList<>());
            }

            // Distribute the elements into buckets
            for (T element : list) {
                int bucketIndex = getBucketIndex(element, min, max, bucketCount);
                buckets.get(bucketIndex).add(element);
            }

            // Sort each bucket and concatenate back into the original list
            int index = 0;
            for (List<T> bucket : buckets) {
                Collections.sort(bucket); // Using Collections.sort for individual bucket sorting
                for (T element : bucket) {
                    list.set(index++, element);
                }
            }
        };
    }

    private static <T extends Comparable<T>> int getBucketIndex(T element, T min, T max, int bucketCount) {
        // Normalize the value to a range [0, 1] and then scale to the bucket count
        double normalizedIndex = (element.compareTo(min) - min.compareTo(min)) / (double) (max.compareTo(min));
        return (int) (normalizedIndex * (bucketCount - 1));
    }

    private static int calculateOptimalBucketCount(int size) {
        // Heuristic for optimal bucket count could be based on the size of the list
        // For example, square root of the size or a similar function
        return (int) Math.sqrt(size) + 1;
    }
}

