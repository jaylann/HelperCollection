import java.util.Objects;

public class ArrayHelperTemp {

    public static int getFirstFree(int[] a) {
        for (int i = 0; i<a.length; i++) {
            if (a[i]==0) {
                return i;
            }
        }
        return a.length;

    }
    private static boolean isArrayEqual(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[][] removeDuplicates(int[][] original) {
        int[][] temp = new int[original.length][];
        int count = 0;

        for (int i = 0; i < original.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < count; j++) {
                if (isArrayEqual(original[i], temp[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                temp[count++] = original[i];
            }
        }

        int[][] unique = new int[count][];
        System.arraycopy(temp, 0, unique, 0, count);

        return unique;
    }
    public static void gnomeSort(int[] a) {
        int n = 0;
        while (n<a.length) {
            if (n==0 || a[n]>=a[n-1]) {
                n++;
            } else {
                int tmp = a[n];
                a[n] = a[n-1];
                a[n-1]=tmp;
                n--;
            }
        }
    }

    public static int[] mergeSort(int[] array) {
        if (array.length==0) {
            return new int[0];
        }
        if (array.length == 1) {
            return array;
        }

        int[] part1 = new int[array.length/2];
        int[] part2 = new int[array.length/2 + (array.length%2==0?0:1)];
        System.arraycopy(array, 0, part1, 0, part1.length);
        if (array.length - part1.length >= 0)
            System.arraycopy(array, part1.length, part2, part1.length - part1.length, array.length - part1.length);
        return merge(mergeSort(part1), mergeSort(part2));

    }

    //public static int[] mergeSortRecursive(int[] a, )

    // Hilfsmethode (muss nicht verwendet werden, könnte aber hilfreich sein)
    public static int[] merge(int[] first, int[] second) {
        int[] result = new int[first.length+second.length];
        int i = 0;
        int j=0;
        while (i+j<first.length+second.length) {
            if(i>=first.length && j < second.length) {
                result[i+j] = second[j];
                j++;
                continue;
            } else if (j >= second.length && i<first.length) {
                result[i+j] = first[i];
                i++;
                continue;
            }
            if (first[i] < second[j]) {
                result[i+j] = first[i];
                i++;
            } else {
                result[i+j] = second[j];
                j++;
            }
        }
        return result;
    }
    public static void stoogeSort(int[] array) {
        if (array.length == 0) {
            return;
        }
        stoogeSort(array, 0, array.length-1);
    }
    public static void stoogeSort(int[] array, int from, int to) {

        int usableLength = to-from+1;
        if (usableLength <= 2) {

            if (array[from] > array[to]) {
                int tmp = array[from];
                array[from] = array[to];
                array[to] = tmp;
            }
            return;
        }
        int toLength = (2 * (usableLength / 3)) + (usableLength % 3);
        stoogeSort(array, from, toLength-1+from);
        stoogeSort(array, usableLength/3+from, usableLength-1+from);
        stoogeSort(array, from, toLength-1+from);
    }

    public static void selectionSortRec(int[] a) {
        if (a.length==0) {
            return;
        }
        selectionSortRec(a, a.length - 1);
    }

    public static void selectionSortRec(int[] a, int toIncl) {
        if (toIncl == 0) {
            return;
        }
        int maxIndex = findIndexOfLargest(a, toIncl);
        swap(a, maxIndex, toIncl);
        selectionSortRec(a, toIncl-1);
    }

    public static int findIndexOfLargest(int[] a, int toIncl) {
        int max = Integer.MIN_VALUE;
        int resIndex = 0;
        for (int i = 0; i <= toIncl; i++) {
            if (a[i]>max) {
                resIndex=i;
                max=a[i];
            }
        }
        return resIndex;
    }

    // Hilfsmethode (muss nicht verwendet werden, könnte aber hilfreich sein)
    public static void swap(int[] a, int firstPos, int secondPos) {
        int temp = a[firstPos];
        a[firstPos] = a[secondPos];
        a[secondPos] = temp;
    }

    public static boolean crossword(char[][] letterGrid, char[] word) {
        int curMaxHor = 0;
        int curMaxVert = 0;
        int curMaxDia = 0;
        for (int i = 0; i < letterGrid.length; i++) {
            for (int j = 0; j < letterGrid[i].length; j++) {
                if (word.length+j-curMaxHor <= letterGrid[i].length && letterGrid[i][j] == word[curMaxHor ]) {
                    curMaxHor++;
                } else {
                    curMaxHor = 0;
                    if (letterGrid[i][j] == word[curMaxHor]) {
                        curMaxHor++;
                    }
                }
                if (word.length+j-curMaxVert <= letterGrid.length && letterGrid[j][i] == word[curMaxVert]) {
                    curMaxVert++;

                } else {
                    curMaxVert = 0;
                    if (letterGrid[j][i] == word[0]) {
                        curMaxVert++;
                    }
                }

            }
            if (word.length+i-curMaxDia <= letterGrid.length && letterGrid[i][i] == word[curMaxDia]) {
                curMaxDia++;
            } else {
                curMaxDia=0;
                if (letterGrid[i][i] == word[0]) {
                    curMaxDia++;
                }
            }
            if (curMaxVert == word.length || curMaxHor ==word.length || curMaxDia == word.length) {
                return true;
            }
        } return false;
    }

    public static int[][] minsAndMaxs(int[][] a) {
        int[][] result = new int[a.length][2];
        for (int i = 0; i < a.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int cur : a[i]) {
                if (cur < min) {
                    min = cur;
                }
                if (cur > max) {
                    max = cur;
                }
            }
            result[i] = new int[]{min, max};
        }
        return result;
    }

    public static int[][] transpose(int[][] a) {
        int[][] result = new int[a[0].length][a.length];
        for (int i = 0; i < a[0].length; i++) {
            result[i] = new int[a.length];
            for (int j = 0; j < a.length; j++) {
                result[i][j] = a[j][i];
            }
        }
        return result;
    }

    public static int[] linearize(int[][] a) {
        int newLen = 0;
        for (int i = 0; i < a.length; i++) {
            newLen += a[i].length;
        }
        int[] newArray = new int[newLen];
        int totalIndex = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                newArray[totalIndex] = a[i][j];
                totalIndex++;
            }
        }
        return newArray;
    }

    public int[] megaMergeSort(int[] array, int div) {
        return megaMergeSort(array, div, 0, array.length);
    }

    /**
     * Sorts the array using mega merge sort with div splits in the defined range
     * @param array the array to be sorted
     * @param div the split factor
     * @param from the lower bound (inclusive)
     * @param to the upper bound (exclusive)
     * @return the sorted array
     */
    public int[] megaMergeSort(int[] array, int div, int from, int to) {
        int length = to-from;
        if (length == 0) {
            return new int[0];
        }
        if (length==1) {
            return new int[]{array[from]};
        }
        int[][] resArray = mergeSplit(array,div,from,to);
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = megaMergeSort(resArray[i], div, 0, resArray[i].length);
        }
        return merge(resArray, 0, resArray.length);

    }

    public int[][] mergeSplit(int[] array, int div, int from, int to ) {
        int useLength = to-from;
        int length = useLength/div;
        int remainder = useLength%div;
        int[][] result = new int[div][];
        int totalLength = from;
        for (int i = 0; i < div; i++) {
            int arrayLength = 0;
            if (i+1 == div) {
                arrayLength = length +(Math.max(remainder, 0));
            } else {
                arrayLength = length +(remainder>0?1:0);
            }
            int[] subResult = new int[arrayLength];
            for (int j = 0; j < arrayLength; j++) {
                subResult[j] = array[totalLength+j];
            }
            totalLength+=arrayLength;
            remainder--;
            result[i] = subResult;
        }

        return result;
    }

    /**
     * Merges all arrays in the given range
     * @param arrays to be merged
     * @param from lower bound (inclusive)
     * @param to upper bound (exclusive)
     * @return the merged array
     */
    public int[] merge(int[][] arrays, int from, int to) {
        int length = to-from;
        if (length == 0) {
            return new int[0];
        }
        if (length==1) {
            return arrays[0];
        }
        if (length ==2) {
            return merge(arrays[from], arrays[to-1]);
        }

        return merge(merge(arrays, from+1, to), arrays[from]);
    }

    /**
     * Merges the given arrays into one
     * @param arr1 the first array
     * @param arr2 the second array
     * @return the resulting array
     */
    public static int[][] reverse(int[][] hull) {
        int[][] result = new int[hull.length][];
        for (int i = 0; i < hull.length; i++) {
            result[i] = hull[hull.length-1-i];
        }
        return result;
    }
    public static int[][] addInMiddle(int[][] a, int[] first, int[] last) {
        int length = a.length+2;
        int[][] result = new int[length][];
        result[0] = first;
        for (int i = 1; i < length-1; i++) {
            result[i] = a[i];
        }
        result[length-1] = last;
        return result;
    }

    // Overloads for other array types (float, char, String, byte, long, double) will be similar to the above methods.
    // They will be implemented with the same logic, adapted to each specific type.
}