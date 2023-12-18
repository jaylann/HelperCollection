/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Mon, 18th December 2023, 18:15
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */

/*
 * THIS IS JUST A FILE FOR INSPIRATION
 * FUNCTIONS INSIDE HERE MIGHT NOT WORK AND ARE NOT OPTIMIZED
 * USE AT YOUR OWN RISK
 */


public class ArrayHelperTemp {


    public static void gnomeSort(int[] a) {
        int n = 0;
        while (n < a.length) {
            if (n == 0 || a[n] >= a[n - 1]) {
                n++;
            } else {
                int tmp = a[n];
                a[n] = a[n - 1];
                a[n - 1] = tmp;
                n--;
            }
        }
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }
        if (array.length == 1) {
            return array;
        }

        int[] part1 = new int[array.length / 2];
        int[] part2 = new int[array.length / 2 + (array.length % 2 == 0 ? 0 : 1)];
        System.arraycopy(array, 0, part1, 0, part1.length);
        if (array.length - part1.length >= 0)
            System.arraycopy(array, part1.length, part2, part1.length - part1.length, array.length - part1.length);
        return merge(mergeSort(part1), mergeSort(part2));

    }

    //public static int[] mergeSortRecursive(int[] a, )

    // Hilfsmethode (muss nicht verwendet werden, könnte aber hilfreich sein)
    public static int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int i = 0;
        int j = 0;
        while (i + j < first.length + second.length) {
            if (i >= first.length && j < second.length) {
                result[i + j] = second[j];
                j++;
                continue;
            } else if (j >= second.length && i < first.length) {
                result[i + j] = first[i];
                i++;
                continue;
            }
            if (first[i] < second[j]) {
                result[i + j] = first[i];
                i++;
            } else {
                result[i + j] = second[j];
                j++;
            }
        }
        return result;
    }

    public static void stoogeSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        stoogeSort(array, 0, array.length - 1);
    }

    public static void stoogeSort(int[] array, int from, int to) {

        int usableLength = to - from + 1;
        if (usableLength <= 2) {

            if (array[from] > array[to]) {
                int tmp = array[from];
                array[from] = array[to];
                array[to] = tmp;
            }
            return;
        }
        int toLength = (2 * (usableLength / 3)) + (usableLength % 3);
        stoogeSort(array, from, toLength - 1 + from);
        stoogeSort(array, usableLength / 3 + from, usableLength - 1 + from);
        stoogeSort(array, from, toLength - 1 + from);
    }

    public static void selectionSortRec(int[] a) {
        if (a.length == 0) {
            return;
        }
        selectionSortRec(a, a.length - 1);
    }

    public static void selectionSortRec(int[] a, int toIncl) {
        if (toIncl == 0) {
            return;
        }
        int maxIndex = findIndexOfLargest(a, toIncl);
        ArrayHelper.swap(a, maxIndex, toIncl);
        selectionSortRec(a, toIncl - 1);
    }

    public static int findIndexOfLargest(int[] a, int toIncl) {
        int max = Integer.MIN_VALUE;
        int resIndex = 0;
        for (int i = 0; i <= toIncl; i++) {
            if (a[i] > max) {
                resIndex = i;
                max = a[i];
            }
        }
        return resIndex;
    }


    public int[] megaMergeSort(int[] array, int div) {
        return megaMergeSort(array, div, 0, array.length);
    }

    /**
     * Sorts the array using mega merge sort with div splits in the defined range
     *
     * @param array the array to be sorted
     * @param div   the split factor
     * @param from  the lower bound (inclusive)
     * @param to    the upper bound (exclusive)
     * @return the sorted array
     */
    public int[] megaMergeSort(int[] array, int div, int from, int to) {
        int length = to - from;
        if (length == 0) {
            return new int[0];
        }
        if (length == 1) {
            return new int[]{array[from]};
        }
        int[][] resArray = mergeSplit(array, div, from, to);
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = megaMergeSort(resArray[i], div, 0, resArray[i].length);
        }
        return merge(resArray, 0, resArray.length);

    }

    public int[][] mergeSplit(int[] array, int div, int from, int to) {
        int useLength = to - from;
        int length = useLength / div;
        int remainder = useLength % div;
        int[][] result = new int[div][];
        int totalLength = from;
        for (int i = 0; i < div; i++) {
            int arrayLength = 0;
            if (i + 1 == div) {
                arrayLength = length + (Math.max(remainder, 0));
            } else {
                arrayLength = length + (remainder > 0 ? 1 : 0);
            }
            int[] subResult = new int[arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                subResult[j] = array[totalLength + j];
            }
            totalLength += arrayLength;
            remainder--;
            result[i] = subResult;
        }

        return result;
    }

    /**
     * Merges all arrays in the given range
     *
     * @param arrays to be merged
     * @param from   lower bound (inclusive)
     * @param to     upper bound (exclusive)
     * @return the merged array
     */
    public int[] merge(int[][] arrays, int from, int to) {
        int length = to - from;
        if (length == 0) {
            return new int[0];
        }
        if (length == 1) {
            return arrays[0];
        }
        if (length == 2) {
            return merge(arrays[from], arrays[to - 1]);
        }

        return merge(merge(arrays, from + 1, to), arrays[from]);
    }
}