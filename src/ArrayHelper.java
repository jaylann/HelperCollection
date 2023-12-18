/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Mon, 18th December 2023, 18:15
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */


import java.util.Objects;
import java.util.Random;

public class ArrayHelper {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    // Adds an element to an array, expanding its size by one
    public static int[] addElement(int[] array, int element) {
        if (array == null) {
            return new int[]{element};
        }

        int[] newArray = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        return newArray;
    }
    public static byte[] addElement(byte[] array, byte element) {
        if (array == null) {
            return new byte[]{element};
        }

        byte[] newArray = new byte[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        return newArray;
    }
    public static String[] addElement(String[] array, String element) {
        if (array == null) {
            return new String[]{element};
        }

        String[] newArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        return newArray;
    }
    public static double[] addElement(double[] array, double element) {
        if (array == null) {
            return new double[]{element};
        }

        double[] newArray = new double[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        return newArray;
    }
    public static long[] addElement(long[] array, long element) {
        if (array == null) {
            return new long[]{element};
        }

        long[] newArray = new long[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        return newArray;
    }
    public static float[] addElement(float[] array, float element) {
        if (array == null) {
            return new float[]{element};
        }

        float[] newArray = new float[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        return newArray;
    }
    public static char[] addElement(char[] array, char element) {
        if (array == null) {
            return new char[]{element};
        }

        char[] newArray = new char[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        return newArray;
    }

    // Removes an element from an array, shrinking its size by one
    public static int[] removeElement(int[] array, int element) {
        if (array == null) {
            return null;
        }

        int index = findElement(array, element);
        if (index == -1) {
            return array;
        }

        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }
    public static byte[] removeElement(byte[] array, byte element) {
        if (array == null) {
            return null;
        }

        int index = findElement(array, element);
        if (index == -1) {
            return array;
        }

        byte[] newArray = new byte[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }
    public static String[] removeElement(String[] array, String element) {
        if (array == null) {
            return null;
        }

        int index = findElement(array, element);
        if (index == -1) {
            return array;
        }

        String[] newArray = new String[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }
    public static double[] removeElement(double[] array, double element) {
        if (array == null) {
            return null;
        }

        int index = findElement(array, element);
        if (index == -1) {
            return array;
        }

        double[] newArray = new double[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }
    public static long[] removeElement(long[] array, long element) {
        if (array == null) {
            return null;
        }

        int index = findElement(array, element);
        if (index == -1) {
            return array;
        }

        long[] newArray = new long[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }
    public static float[] removeElement(float[] array, float element) {
        if (array == null) {
            return null;
        }

        int index = findElement(array, element);
        if (index == -1) {
            return array;
        }

        float[] newArray = new float[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }
    public static char[] removeElement(char[] array, char element) {
        if (array == null) {
            return null;
        }

        int index = findElement(array, element);
        if (index == -1) {
            return array;
        }

        char[] newArray = new char[array.length - 1];
        for (char i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }

    // Searches for an element and returns its index, or -1 if not found
    public static int findElement(int[] array, int element) {
        if (array == null) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
    public static int findElement(byte[] array, byte element) {
        if (array == null) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
    public static int findElement(String[] array, String element) {
        if (array == null) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], element)) {
                return i;
            }
        }
        return -1;
    }
    public static int findElement(double[] array, double element) {
        if (array == null) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
    public static int findElement(long[] array, long element) {
        if (array == null) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
    public static int findElement(float[] array, float element) {
        if (array == null) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }
    public static int findElement(char[] array, char element) {
        if (array == null) {
            return -1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1;
    }

    // Sorts the array in ascending or descending order
    public static void sortArray(int[] array, boolean ascending) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (ascending ? array[j] > array[j + 1] : array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static void sortArray(byte[] array, boolean ascending) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (ascending ? array[j] > array[j + 1] : array[j] < array[j + 1]) {
                    byte temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static void sortArray(double[] array, boolean ascending) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (ascending ? array[j] > array[j + 1] : array[j] < array[j + 1]) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static void sortArray(long[] array, boolean ascending) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (ascending ? array[j] > array[j + 1] : array[j] < array[j + 1]) {
                    long temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static void sortArray(float[] array, boolean ascending) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (ascending ? array[j] > array[j + 1] : array[j] < array[j + 1]) {
                    float temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    public static void sortArray(char[] array, boolean ascending) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (ascending ? array[j] > array[j + 1] : array[j] < array[j + 1]) {
                    char temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    
    // Reverses the order of elements in the array
    public static void reverseArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    public static void reverseArray(byte[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length / 2; i++) {
            byte temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    public static void reverseArray(String[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    public static void reverseArray(double[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length / 2; i++) {
            double temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    public static void reverseArray(long[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length / 2; i++) {
            long temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    public static void reverseArray(float[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length / 2; i++) {
            float temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
    public static void reverseArray(char[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    
    public static int sumArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
    public static long sumArray(long[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        long sum = 0;
        for (long value : array) {
            sum += value;
        }
        return sum;
    }
    public static double sumArray(double[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        double sum = 0;
        for (double value : array) {
            sum += value;
        }
        return sum;
    }
    public static float sumArray(float[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        float sum = 0;
        for (float value : array) {
            sum += value;
        }
        return sum;
    }

    // Average of array elements
    public static double averageArray(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        double sum = sumArray(array);
        return sum / array.length;
    }
    public static double averageArray(long[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        double sum = sumArray(array);
        return sum / array.length;
    }
    public static double averageArray(double[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        double sum = sumArray(array);
        return sum / array.length;
    }
    public static double averageArray(float[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        double sum = sumArray(array);
        return sum / array.length;
    }

    // Minimum element in the array
    public static int minElement(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
    public static long minElement(long[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        long min = array[0];
        for (long value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
    public static double minElement(double[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        double min = array[0];
        for (double value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }
    public static float minElement(float[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        float min = array[0];
        for (float value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    // Maximum element in the array
    public static int maxElement(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
    public static long maxElement(long[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        long max = array[0];
        for (long value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
    public static double maxElement(double[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        double max = array[0];
        for (double value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
    public static float maxElement(float[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is null or empty");
        }

        float max = array[0];
        for (float value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    // Copy of the array
    public static int[] cloneArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }
    public static long[] cloneArray(long[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        long[] copy = new long[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }
    public static double[] cloneArray(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        double[] copy = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }
    public static float[] cloneArray(float[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        float[] copy = new float[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }
    public static String[] cloneArray(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        String[] copy = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }
    public static char[] cloneArray(char[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        char[] copy = new char[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }
    public static byte[] cloneArray(byte[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array is null");
        }

        byte[] copy = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    // Concatenates two int arrays
    public static int[] concatenateArrays(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }
        int[] result = new int[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            result[array1.length + i] = array2[i];
        }
        return result;
    }
    public static float[] concatenateArrays(float[] array1, float[] array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }
        float[] result = new float[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            result[array1.length + i] = array2[i];
        }
        return result;
    }
    public static double[] concatenateArrays(double[] array1, double[] array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }
        double[] result = new double[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            result[array1.length + i] = array2[i];
        }
        return result;
    }
    public static long[] concatenateArrays(long[] array1, long[] array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }
        long[] result = new long[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            result[array1.length + i] = array2[i];
        }
        return result;
    }
    public static char[] concatenateArrays(char[] array1, char[] array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }
        char[] result = new char[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            result[array1.length + i] = array2[i];
        }
        return result;
    }
    public static byte[] concatenateArrays(byte[] array1, byte[] array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }
        byte[] result = new byte[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            result[array1.length + i] = array2[i];
        }
        return result;
    }
    public static String[] concatenateArrays(String[] array1, String[] array2) {
        if (array1 == null || array2 == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }
        String[] result = new String[array1.length + array2.length];
        for (int i = 0; i < array1.length; i++) {
            result[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++) {
            result[array1.length + i] = array2[i];
        }
        return result;
    }

    // Converts an int array to a String
    public static String arrayToString(int[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
    public static String arrayToString(float[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
    public static String arrayToString(String[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
    public static String arrayToString(double[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
    public static String arrayToString(long[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
    public static String arrayToString(char[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
    public static String arrayToString(byte[] array) {
        if (array == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    // Fills an int array with a specific value
    public static void fillArray(int[] array, int value) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }
    public static void fillArray(float[] array, float value) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }
    public static void fillArray(String[] array, String value) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }
    public static void fillArray(double[] array, double value) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }
    public static void fillArray(long[] array, long value) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }
    public static void fillArray(char[] array, char value) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }
    public static void fillArray(byte[] array, byte value) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
    }

    // Checks if an int array contains a specific value
    public static boolean arrayContains(int[] array, int value) {
        if (array == null) {
            return false;
        }
        for (int i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean arrayContains(float[] array, float value) {
        if (array == null) {
            return false;
        }
        for (float i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean arrayContains(String[] array, String value) {
        if (array == null) {
            return false;
        }
        for (String i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean arrayContains(double[] array, double value) {
        if (array == null) {
            return false;
        }
        for (double i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean arrayContains(long[] array, long value) {
        if (array == null) {
            return false;
        }
        for (long i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean arrayContains(char[] array, char value) {
        if (array == null) {
            return false;
        }
        for (char i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean arrayContains(byte[] array, byte value) {
        if (array == null) {
            return false;
        }
        for (byte i : array) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    // Counts the occurrences of a value in an int array
    public static int countOccurrences(int[] array, int value) {
        if (array == null) {
            return 0;
        }
        int count = 0;
        for (int i : array) {
            if (i == value) {
                count++;
            }
        }
        return count;
    }
    public static int countOccurrences(float[] array, float value) {
        if (array == null) {
            return 0;
        }
        int count = 0;
        for (float i : array) {
            if (i == value) {
                count++;
            }
        }
        return count;
    }
    public static int countOccurrences(String[] array, String value) {
        if (array == null) {
            return 0;
        }
        int count = 0;
        for (String i : array) {
            if (i == value) {
                count++;
            }
        }
        return count;
    }
    public static int countOccurrences(double[] array, double value) {
        if (array == null) {
            return 0;
        }
        int count = 0;
        for (double i : array) {
            if (i == value) {
                count++;
            }
        }
        return count;
    }
    public static int countOccurrences(long[] array, long value) {
        if (array == null) {
            return 0;
        }
        int count = 0;
        for (long i : array) {
            if (i == value) {
                count++;
            }
        }
        return count;
    }
    public static int countOccurrences(char[] array, char value) {
        if (array == null) {
            return 0;
        }
        int count = 0;
        for (char i : array) {
            if (i == value) {
                count++;
            }
        }
        return count;
    }
    public static int countOccurrences(byte[] array, byte value) {
        if (array == null) {
            return 0;
        }
        int count = 0;
        for (byte i : array) {
            if (i == value) {
                count++;
            }
        }
        return count;
    }

    // Resizes an int array
    public static int[] resizeArray(int[] array, int newSize) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (newSize < 0) {
            throw new IllegalArgumentException("New size cannot be negative");
        }
        int[] newArray = new int[newSize];
        for (int i = 0; i < Integer.min(array.length, newSize); i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    public static float[] resizeArray(float[] array, int newSize) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (newSize < 0) {
            throw new IllegalArgumentException("New size cannot be negative");
        }
        float[] newArray = new float[newSize];
        for (int i = 0; i < Integer.min(array.length, newSize); i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    public static String[] resizeArray(String[] array, int newSize) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (newSize < 0) {
            throw new IllegalArgumentException("New size cannot be negative");
        }
        String[] newArray = new String[newSize];
        for (int i = 0; i < Integer.min(array.length, newSize); i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    public static double[] resizeArray(double[] array, int newSize) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (newSize < 0) {
            throw new IllegalArgumentException("New size cannot be negative");
        }
        double[] newArray = new double[newSize];
        for (int i = 0; i < Integer.min(array.length, newSize); i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    public static long[] resizeArray(long[] array, int newSize) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (newSize < 0) {
            throw new IllegalArgumentException("New size cannot be negative");
        }
        long[] newArray = new long[newSize];
        for (int i = 0; i < Integer.min(array.length, newSize); i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    public static char[] resizeArray(char[] array, int newSize) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (newSize < 0) {
            throw new IllegalArgumentException("New size cannot be negative");
        }
        char[] newArray = new char[newSize];
        for (int i = 0; i < Integer.min(array.length, newSize); i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
    public static byte[] resizeArray(byte[] array, int newSize) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        if (newSize < 0) {
            throw new IllegalArgumentException("New size cannot be negative");
        }
        byte[] newArray = new byte[newSize];
        for (int i = 0; i < Integer.min(array.length, newSize); i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    // Shuffles an int array
    public static void shuffleArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            // Simple swap
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffleArray(float[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            // Simple swap
            float temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffleArray(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            // Simple swap
            String temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffleArray(double[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            // Simple swap
            double temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffleArray(long[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            // Simple swap
            long temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffleArray(char[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            // Simple swap
            char temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
    public static void shuffleArray(byte[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            // Simple swap
            byte temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    // Find unique elements in a float array
    public static float[] uniqueElements(float[] array) {
        if (array == null) return null;
        float[] temp = new float[array.length];
        int uniqueCount = 0;

        for (float value : array) {
            if (!containsPartial(temp, uniqueCount, value)) {
                temp[uniqueCount++] = value;
            }
        }

        float[] result = new float[uniqueCount];
        copyArray(temp, result, uniqueCount);
        return result;
    }
    public static long[] uniqueElements(long[] array) {
        if (array == null) return null;
        long[] temp = new long[array.length];
        int uniqueCount = 0;

        for (long value : array) {
            if (!containsPartial(temp, uniqueCount, value)) {
                temp[uniqueCount++] = value;
            }
        }

        long[] result = new long[uniqueCount];
        copyArray(temp, result, uniqueCount);
        return result;
    }
    public static double[] uniqueElements(double[] array) {
        if (array == null) return null;
        double[] temp = new double[array.length];
        int uniqueCount = 0;

        for (double value : array) {
            if (!containsPartial(temp, uniqueCount, value)) {
                temp[uniqueCount++] = value;
            }
        }

        double[] result = new double[uniqueCount];
        copyArray(temp, result, uniqueCount);
        return result;
    }
    public static int[] uniqueElements(int[] array) {
        if (array == null) return null;
        int[] temp = new int[array.length];
        int uniqueCount = 0;

        for (int value : array) {
            if (!containsPartial(temp, uniqueCount, value)) {
                temp[uniqueCount++] = value;
            }
        }

        int[] result = new int[uniqueCount];
        copyArray(temp, result, uniqueCount);
        return result;
    }
    public static byte[] uniqueElements(byte[] array) {
        if (array == null) return null;
        byte[] temp = new byte[array.length];
        int uniqueCount = 0;

        for (byte value : array) {
            if (!containsPartial(temp, uniqueCount, value)) {
                temp[uniqueCount++] = value;
            }
        }

        byte[] result = new byte[uniqueCount];
        copyArray(temp, result, uniqueCount);
        return result;
    }
    public static char[] uniqueElements(char[] array) {
        if (array == null) return null;
        char[] temp = new char[array.length];
        int uniqueCount = 0;

        for (char value : array) {
            if (!containsPartial(temp, uniqueCount, value)) {
                temp[uniqueCount++] = value;
            }
        }

        char[] result = new char[uniqueCount];
        copyArray(temp, result, uniqueCount);
        return result;
    }
    public static String[] uniqueElements(String[] array) {
        if (array == null) return null;
        String[] temp = new String[array.length];
        int uniqueCount = 0;

        for (String value : array) {
            if (!containsPartial(temp, uniqueCount, value)) {
                temp[uniqueCount++] = value;
            }
        }

        String[] result = new String[uniqueCount];
        copyArray(temp, result, uniqueCount);
        return result;
    }

    // Check if array contains a value up to a certain index
    public static boolean containsPartial(float[] array, int length, float value) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsPartial(long[] array, int length, long value) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsPartial(double[] array, int length, double value) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsPartial(byte[] array, int length, byte value) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsPartial(int[] array, int length, int value) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsPartial(char[] array, int length, char value) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsPartial(String[] array, int length, String value) {
        for (int i = 0; i < length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    // Find intersection of two float arrays
    public static float[] intersectArrays(float[] array1, float[] array2) {
        if (array1 == null || array2 == null) return null;
        float[] temp = new float[Integer.min(array1.length, array2.length)];
        int count = 0;

        for (float value : array1) {
            if (containsPartial(array2, array2.length, value) && !containsPartial(temp, count, value)) {
                temp[count++] = value;
            }
        }

        float[] result = new float[count];
        copyArray(temp, result, count);
        return result;
    }
    public static long[] intersectArrays(long[] array1, long[] array2) {
        if (array1 == null || array2 == null) return null;
        long[] temp = new long[Integer.min(array1.length, array2.length)];
        int count = 0;

        for (long value : array1) {
            if (containsPartial(array2, array2.length, value) && !containsPartial(temp, count, value)) {
                temp[count++] = value;
            }
        }

        long[] result = new long[count];
        copyArray(temp, result, count);
        return result;
    }
    public static double[] intersectArrays(double[] array1, double[] array2) {
        if (array1 == null || array2 == null) return null;
        double[] temp = new double[Integer.min(array1.length, array2.length)];
        int count = 0;

        for (double value : array1) {
            if (containsPartial(array2, array2.length, value) && !containsPartial(temp, count, value)) {
                temp[count++] = value;
            }
        }

        double[] result = new double[count];
        copyArray(temp, result, count);
        return result;
    }
    public static int[] intersectArrays(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) return null;
        int[] temp = new int[Integer.min(array1.length, array2.length)];
        int count = 0;

        for (int value : array1) {
            if (containsPartial(array2, array2.length, value) && !containsPartial(temp, count, value)) {
                temp[count++] = value;
            }
        }

        int[] result = new int[count];
        copyArray(temp, result, count);
        return result;
    }
    public static byte[] intersectArrays(byte[] array1, byte[] array2) {
        if (array1 == null || array2 == null) return null;
        byte[] temp = new byte[Integer.min(array1.length, array2.length)];
        int count = 0;

        for (byte value : array1) {
            if (containsPartial(array2, array2.length, value) && !containsPartial(temp, count, value)) {
                temp[count++] = value;
            }
        }

        byte[] result = new byte[count];
        copyArray(temp, result, count);
        return result;
    }
    public static char[] intersectArrays(char[] array1, char[] array2) {
        if (array1 == null || array2 == null) return null;
        char[] temp = new char[Integer.min(array1.length, array2.length)];
        int count = 0;

        for (char value : array1) {
            if (containsPartial(array2, array2.length, value) && !containsPartial(temp, count, value)) {
                temp[count++] = value;
            }
        }

        char[] result = new char[count];
        copyArray(temp, result, count);
        return result;
    }
    public static String[] intersectArrays(String[] array1, String[] array2) {
        if (array1 == null || array2 == null) return null;
        String[] temp = new String[Integer.min(array1.length, array2.length)];
        int count = 0;

        for (String value : array1) {
            if (containsPartial(array2, array2.length, value) && !containsPartial(temp, count, value)) {
                temp[count++] = value;
            }
        }

        String[] result = new String[count];
        copyArray(temp, result, count);
        return result;
    }

    // Find difference between two float arrays
    public static float[] differenceArrays(float[] array1, float[] array2) {
        if (array1 == null) return null;
        if (array2 == null) return array1.clone();
        float[] temp = new float[array1.length];
        int count = 0;

        for (float value : array1) {
            if (!containsPartial(array2, array2.length, value)) {
                temp[count++] = value;
            }
        }

        float[] result = new float[count];
        copyArray(temp, result, count);
        return result;
    }
    public static long[] differenceArrays(long[] array1, long[] array2) {
        if (array1 == null) return null;
        if (array2 == null) return array1.clone();
        long[] temp = new long[array1.length];
        int count = 0;

        for (long value : array1) {
            if (!containsPartial(array2, array2.length, value)) {
                temp[count++] = value;
            }
        }

        long[] result = new long[count];
        copyArray(temp, result, count);
        return result;
    }
    public static double[] differenceArrays(double[] array1, double[] array2) {
        if (array1 == null) return null;
        if (array2 == null) return array1.clone();
        double[] temp = new double[array1.length];
        int count = 0;

        for (double value : array1) {
            if (!containsPartial(array2, array2.length, value)) {
                temp[count++] = value;
            }
        }

        double[] result = new double[count];
        copyArray(temp, result, count);
        return result;
    }
    public static int[] differenceArrays(int[] array1, int[] array2) {
        if (array1 == null) return null;
        if (array2 == null) return array1.clone();
        int[] temp = new int[array1.length];
        int count = 0;

        for (int value : array1) {
            if (!containsPartial(array2, array2.length, value)) {
                temp[count++] = value;
            }
        }

        int[] result = new int[count];
        copyArray(temp, result, count);
        return result;
    }
    public static byte[] differenceArrays(byte[] array1, byte[] array2) {
        if (array1 == null) return null;
        if (array2 == null) return array1.clone();
        byte[] temp = new byte[array1.length];
        int count = 0;

        for (byte value : array1) {
            if (!containsPartial(array2, array2.length, value)) {
                temp[count++] = value;
            }
        }

        byte[] result = new byte[count];
        copyArray(temp, result, count);
        return result;
    }
    public static char[] differenceArrays(char[] array1, char[] array2) {
        if (array1 == null) return null;
        if (array2 == null) return array1.clone();
        char[] temp = new char[array1.length];
        int count = 0;

        for (char value : array1) {
            if (!containsPartial(array2, array2.length, value)) {
                temp[count++] = value;
            }
        }

        char[] result = new char[count];
        copyArray(temp, result, count);
        return result;
    }
    public static String[] differenceArrays(String[] array1, String[] array2) {
        if (array1 == null) return null;
        if (array2 == null) return array1.clone();
        String[] temp = new String[array1.length];
        int count = 0;

        for (String value : array1) {
            if (!containsPartial(array2, array2.length, value)) {
                temp[count++] = value;
            }
        }

        String[] result = new String[count];
        copyArray(temp, result, count);
        return result;
    }

    // Rotate a float array by a number of positions
    public static void rotateArray(float[] array, int positions) {
        if (array == null || positions < 0 || positions >= array.length) return;
        int n = array.length;
        positions = positions % n;
        reversePartial(array, 0, n - 1);
        reversePartial(array, 0, positions - 1);
        reversePartial(array, positions, n - 1);
    }
    public static void rotateArray(long[] array, int positions) {
        if (array == null || positions < 0 || positions >= array.length) return;
        int n = array.length;
        positions = positions % n;
        reversePartial(array, 0, n - 1);
        reversePartial(array, 0, positions - 1);
        reversePartial(array, positions, n - 1);
    }
    public static void rotateArray(double[] array, int positions) {
        if (array == null || positions < 0 || positions >= array.length) return;
        int n = array.length;
        positions = positions % n;
        reversePartial(array, 0, n - 1);
        reversePartial(array, 0, positions - 1);
        reversePartial(array, positions, n - 1);
    }
    public static void rotateArray(int[] array, int positions) {
        if (array == null || positions < 0 || positions >= array.length) return;
        int n = array.length;
        positions = positions % n;
        reversePartial(array, 0, n - 1);
        reversePartial(array, 0, positions - 1);
        reversePartial(array, positions, n - 1);
    }
    public static void rotateArray(byte[] array, int positions) {
        if (array == null || positions < 0 || positions >= array.length) return;
        int n = array.length;
        positions = positions % n;
        reversePartial(array, 0, n - 1);
        reversePartial(array, 0, positions - 1);
        reversePartial(array, positions, n - 1);
    }
    public static void rotateArray(char[] array, int positions) {
        if (array == null || positions < 0 || positions >= array.length) return;
        int n = array.length;
        positions = positions % n;
        reversePartial(array, 0, n - 1);
        reversePartial(array, 0, positions - 1);
        reversePartial(array, positions, n - 1);
    }
    public static void rotateArray(String[] array, int positions) {
        if (array == null || positions < 0 || positions >= array.length) return;
        int n = array.length;
        positions = positions % n;
        reversePartial(array, 0, n - 1);
        reversePartial(array, 0, positions - 1);
        reversePartial(array, positions, n - 1);
    }

    // Helper method to reverse a portion of a float array
    public static void reversePartial(float[] array, int start, int end) {
        while (start < end) {
            float temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void reversePartial(long[] array, int start, int end) {
        while (start < end) {
            long temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void reversePartial(double[] array, int start, int end) {
        while (start < end) {
            double temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void reversePartial(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void reversePartial(byte[] array, int start, int end) {
        while (start < end) {
            byte temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void reversePartial(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
    public static void reversePartial(String[] array, int start, int end) {
        while (start < end) {
            String temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    // Custom method to copy array elements
    public static void copyArray(float[] source, float[] destination, int length) {
        for (int i = 0; i < length; i++) {
            destination[i] = source[i];
        }
    }
    public static void copyArray(long[] source, long[] destination, int length) {
        for (int i = 0; i < length; i++) {
            destination[i] = source[i];
        }
    }
    public static void copyArray(double[] source, double[] destination, int length) {
        for (int i = 0; i < length; i++) {
            destination[i] = source[i];
        }
    }
    public static void copyArray(int[] source, int[] destination, int length) {
        for (int i = 0; i < length; i++) {
            destination[i] = source[i];
        }
    }
    public static void copyArray(byte[] source, byte[] destination, int length) {
        for (int i = 0; i < length; i++) {
            destination[i] = source[i];
        }
    }
    public static void copyArray(char[] source, char[] destination, int length) {
        for (int i = 0; i < length; i++) {
            destination[i] = source[i];
        }
    }
    public static void copyArray(String[] source, String[] destination, int length) {
        for (int i = 0; i < length; i++) {
            destination[i] = source[i];
        }
    }

    public static int getFirstFreeElement(float[] a) {
        if (a == null) return -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return i;
            }
        }
        return a.length;
    }
    public static int getFirstFreeElement(long[] a) {
        if (a == null) return -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return i;
            }
        }
        return a.length;
    }
    public static int getFirstFreeElement(double[] a) {
        if (a == null) return -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return i;
            }
        }
        return a.length;
    }
    public static int getFirstFreeElement(int[] a) {
        if (a == null) return -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return i;
            }
        }
        return a.length;
    }
    public static int getFirstFreeElement(String[] a) {
        if (a == null) return -1;
        for (int i = 0; i < a.length; i++) {
            if (Objects.equals(a[i], "")) {
                return i;
            }
        }
        return a.length;
    }
    public static int getFirstFreeElement(char[] a) {
        if (a == null) return -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return i;
            }
        }
        return a.length;
    }
    public static int getFirstFreeElement(byte[] a) {
        if (a == null) return -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                return i;
            }
        }
        return a.length;
    }

    public static boolean isArrayEqual(float[] a, float[] b) {
        if (a == null || b == null) return false;
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
    public static boolean isArrayEqual(long[] a, long[] b) {
        if (a == null || b == null) return false;
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
    public static boolean isArrayEqual(int[] a, int[] b) {
        if (a == null || b == null) return false;
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
    public static boolean isArrayEqual(double[] a, double[] b) {
        if (a == null || b == null) return false;
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
    public static boolean isArrayEqual(String[] a, String[] b) {
        if (a == null || b == null) return false;
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!Objects.equals(a[i], b[i])) {
                return false;
            }
        }
        return true;
    }
    public static boolean isArrayEqual(byte[] a, byte[] b) {
        if (a == null || b == null) return false;
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
    public static boolean isArrayEqual(char[] a, char[] b) {
        if (a == null || b == null) return false;
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

    public static float[] removeDuplicates(float[] original) {
        if (original == null || original.length == 0) return original;

        float[] temp = new float[original.length];
        int count = 0;

        for (float element : original) {
            if (findElement(temp, element) == -1 || count == 0) {
                temp[count++] = element;
            }
        }

        float[] unique = new float[count];
        copyArray(temp, unique, count);
        return unique;
    }
    public static long[] removeDuplicates(long[] original) {
        if (original == null || original.length == 0) return original;

        long[] temp = new long[original.length];
        int count = 0;

        for (long element : original) {
            if (findElement(temp, element) == -1 || count == 0) {
                temp[count++] = element;
            }
        }

        long[] unique = new long[count];
        copyArray(temp, unique, count);
        return unique;
    }
    public static double[] removeDuplicates(double[] original) {
        if (original == null || original.length == 0) return original;

        double[] temp = new double[original.length];
        int count = 0;

        for (double element : original) {
            if (findElement(temp, element) == -1 || count == 0) {
                temp[count++] = element;
            }
        }

        double[] unique = new double[count];
        copyArray(temp, unique, count);
        return unique;
    }
    public static int[] removeDuplicates(int[] original) {
        if (original == null || original.length == 0) return original;

        int[] temp = new int[original.length];
        int count = 0;

        for (int element : original) {
            if (findElement(temp, element) == -1 || count == 0) {
                temp[count++] = element;
            }
        }

        int[] unique = new int[count];
        copyArray(temp, unique, count);
        return unique;
    }
    public static String[] removeDuplicates(String[] original) {
        if (original == null || original.length == 0) return original;

        String[] temp = new String[original.length];
        int count = 0;

        for (String element : original) {
            if (findElement(temp, element) == -1 || count == 0) {
                temp[count++] = element;
            }
        }

        String[] unique = new String[count];
        copyArray(temp, unique, count);
        return unique;
    }
    public static char[] removeDuplicates(char[] original) {
        if (original == null || original.length == 0) return original;

        char[] temp = new char[original.length];
        int count = 0;

        for (char element : original) {
            if (findElement(temp, element) == -1 || count == 0) {
                temp[count++] = element;
            }
        }

        char[] unique = new char[count];
        copyArray(temp, unique, count);
        return unique;
    }
    public static byte[] removeDuplicates(byte[] original) {
        if (original == null || original.length == 0) return original;

        byte[] temp = new byte[original.length];
        int count = 0;

        for (byte element : original) {
            if (findElement(temp, element) == -1 || count == 0) {
                temp[count++] = element;
            }
        }

        byte[] unique = new byte[count];
        copyArray(temp, unique, count);
        return unique;
    }

    public static float[][] removeDuplicates(float[][] original) {
        if (original == null || original.length == 0) return original;

        float[][] temp = new float[original.length][];
        int count = 0;

        for (float[] element : original) {
            if (!containsArray2D(temp, element, count)) {
                temp[count++] = element;
            }
        }

        float[][] unique = new float[count][];
        for (int i = 0; i < count; i++) {
            unique[i] = new float[temp[i].length];
            copyArray(temp[i], unique[i], temp[i].length);
        }
        return unique;
    }
    public static long[][] removeDuplicates(long[][] original) {
        if (original == null || original.length == 0) return original;

        long[][] temp = new long[original.length][];
        int count = 0;

        for (long[] element : original) {
            if (!containsArray2D(temp, element, count)) {
                temp[count++] = element;
            }
        }

        long[][] unique = new long[count][];
        for (int i = 0; i < count; i++) {
            unique[i] = new long[temp[i].length];
            copyArray(temp[i], unique[i], temp[i].length);
        }
        return unique;
    }
    public static double[][] removeDuplicates(double[][] original) {
        if (original == null || original.length == 0) return original;

        double[][] temp = new double[original.length][];
        int count = 0;

        for (double[] element : original) {
            if (!containsArray2D(temp, element, count)) {
                temp[count++] = element;
            }
        }

        double[][] unique = new double[count][];
        for (int i = 0; i < count; i++) {
            unique[i] = new double[temp[i].length];
            copyArray(temp[i], unique[i], temp[i].length);
        }
        return unique;
    }
    public static int[][] removeDuplicates(int[][] original) {
        if (original == null || original.length == 0) return original;

        int[][] temp = new int[original.length][];
        int count = 0;

        for (int[] element : original) {
            if (!containsArray2D(temp, element, count)) {
                temp[count++] = element;
            }
        }

        int[][] unique = new int[count][];
        for (int i = 0; i < count; i++) {
            unique[i] = new int[temp[i].length];
            copyArray(temp[i], unique[i], temp[i].length);
        }
        return unique;
    }
    public static String[][] removeDuplicates(String[][] original) {
        if (original == null || original.length == 0) return original;

        String[][] temp = new String[original.length][];
        int count = 0;

        for (String[] element : original) {
            if (!containsArray2D(temp, element, count)) {
                temp[count++] = element;
            }
        }

        String[][] unique = new String[count][];
        for (int i = 0; i < count; i++) {
            unique[i] = new String[temp[i].length];
            copyArray(temp[i], unique[i], temp[i].length);
        }
        return unique;
    }
    public static char[][] removeDuplicates(char[][] original) {
        if (original == null || original.length == 0) return original;

        char[][] temp = new char[original.length][];
        int count = 0;

        for (char[] element : original) {
            if (!containsArray2D(temp, element, count)) {
                temp[count++] = element;
            }
        }

        char[][] unique = new char[count][];
        for (int i = 0; i < count; i++) {
            unique[i] = new char[temp[i].length];
            copyArray(temp[i], unique[i], temp[i].length);
        }
        return unique;
    }
    public static byte[][] removeDuplicates(byte[][] original) {
        if (original == null || original.length == 0) return original;

        byte[][] temp = new byte[original.length][];
        int count = 0;

        for (byte[] element : original) {
            if (!containsArray2D(temp, element, count)) {
                temp[count++] = element;
            }
        }

        byte[][] unique = new byte[count][];
        for (int i = 0; i < count; i++) {
            unique[i] = new byte[temp[i].length];
            copyArray(temp[i], unique[i], temp[i].length);
        }
        return unique;
    }

    public static boolean containsArray2D(float[][] array, float[] element, int length) {
        for (int i = 0; i < length; i++) {
            if (isArrayEqual(array[i], element)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsArray2D(long[][] array, long[] element, int length) {
        for (int i = 0; i < length; i++) {
            if (isArrayEqual(array[i], element)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsArray2D(double[][] array, double[] element, int length) {
        for (int i = 0; i < length; i++) {
            if (isArrayEqual(array[i], element)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsArray2D(int[][] array, int[] element, int length) {
        for (int i = 0; i < length; i++) {
            if (isArrayEqual(array[i], element)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsArray2D(String[][] array, String[] element, int length) {
        for (int i = 0; i < length; i++) {
            if (isArrayEqual(array[i], element)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsArray2D(char[][] array, char[] element, int length) {
        for (int i = 0; i < length; i++) {
            if (isArrayEqual(array[i], element)) {
                return true;
            }
        }
        return false;
    }
    public static boolean containsArray2D(byte[][] array, byte[] element, int length) {
        for (int i = 0; i < length; i++) {
            if (isArrayEqual(array[i], element)) {
                return true;
            }
        }
        return false;
    }

    public static void swap(float[] a, int firstPos, int secondPos) {
        // Check if the array is null
        if (a == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        // Check if positions are within the array bounds
        if (firstPos < 0 || firstPos >= a.length || secondPos < 0 || secondPos >= a.length) {
            throw new IllegalArgumentException("Position out of array bounds.");
        }

        // Check if the positions are the same
        if (firstPos == secondPos) {
            return;
        }

        // Swap the elements
        float temp = a[firstPos];
        a[firstPos] = a[secondPos];
        a[secondPos] = temp;
    }
    public static void swap(int[] a, int firstPos, int secondPos) {
        // Check if the array is null
        if (a == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        // Check if positions are within the array bounds
        if (firstPos < 0 || firstPos >= a.length || secondPos < 0 || secondPos >= a.length) {
            throw new IllegalArgumentException("Position out of array bounds.");
        }

        // Check if the positions are the same
        if (firstPos == secondPos) {
            return;
        }

        // Swap the elements
        int temp = a[firstPos];
        a[firstPos] = a[secondPos];
        a[secondPos] = temp;
    }
    public static void swap(long[] a, int firstPos, int secondPos) {
        // Check if the array is null
        if (a == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        // Check if positions are within the array bounds
        if (firstPos < 0 || firstPos >= a.length || secondPos < 0 || secondPos >= a.length) {
            throw new IllegalArgumentException("Position out of array bounds.");
        }

        // Check if the positions are the same
        if (firstPos == secondPos) {
            return;
        }

        // Swap the elements
        long temp = a[firstPos];
        a[firstPos] = a[secondPos];
        a[secondPos] = temp;
    }
    public static void swap(double[] a, int firstPos, int secondPos) {
        // Check if the array is null
        if (a == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        // Check if positions are within the array bounds
        if (firstPos < 0 || firstPos >= a.length || secondPos < 0 || secondPos >= a.length) {
            throw new IllegalArgumentException("Position out of array bounds.");
        }

        // Check if the positions are the same
        if (firstPos == secondPos) {
            return;
        }

        // Swap the elements
        double temp = a[firstPos];
        a[firstPos] = a[secondPos];
        a[secondPos] = temp;
    }
    public static void swap(char[] a, int firstPos, int secondPos) {
        // Check if the array is null
        if (a == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        // Check if positions are within the array bounds
        if (firstPos < 0 || firstPos >= a.length || secondPos < 0 || secondPos >= a.length) {
            throw new IllegalArgumentException("Position out of array bounds.");
        }

        // Check if the positions are the same
        if (firstPos == secondPos) {
            return;
        }

        // Swap the elements
        char temp = a[firstPos];
        a[firstPos] = a[secondPos];
        a[secondPos] = temp;
    }
    public static void swap(byte[] a, int firstPos, int secondPos) {
        // Check if the array is null
        if (a == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        // Check if positions are within the array bounds
        if (firstPos < 0 || firstPos >= a.length || secondPos < 0 || secondPos >= a.length) {
            throw new IllegalArgumentException("Position out of array bounds.");
        }

        // Check if the positions are the same
        if (firstPos == secondPos) {
            return;
        }

        // Swap the elements
        byte temp = a[firstPos];
        a[firstPos] = a[secondPos];
        a[secondPos] = temp;
    }
    public static void swap(String[] a, int firstPos, int secondPos) {
        // Check if the array is null
        if (a == null) {
            throw new IllegalArgumentException("Array must not be null.");
        }

        // Check if positions are within the array bounds
        if (firstPos < 0 || firstPos >= a.length || secondPos < 0 || secondPos >= a.length) {
            throw new IllegalArgumentException("Position out of array bounds.");
        }

        // Check if the positions are the same
        if (firstPos == secondPos) {
            return;
        }

        // Swap the elements
        String temp = a[firstPos];
        a[firstPos] = a[secondPos];
        a[secondPos] = temp;
    }

    public static boolean isInHorizontal(char[][] letterGrid, char[] word) {
        for (int i = 0; i < letterGrid.length; i++) {
            for (int j = 0; j <= letterGrid[i].length - word.length; j++) {
                int k;
                for (k = 0; k < word.length; k++) {
                    if (letterGrid[i][j + k] != word[k]) {
                        break;
                    }
                }
                if (k == word.length) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isInVertical(char[][] letterGrid, char[] word) {
        for (int i = 0; i <= letterGrid.length - word.length; i++) {
            for (int j = 0; j < letterGrid[0].length; j++) {
                int k;
                for (k = 0; k < word.length; k++) {
                    if (letterGrid[i + k][j] != word[k]) {
                        break;
                    }
                }
                if (k == word.length) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isInDiagonal(char[][] letterGrid, char[] word) {
        // Diagonal from top-left to bottom-right
        for (int i = 0; i <= letterGrid.length - word.length; i++) {
            for (int j = 0; j <= letterGrid[i].length - word.length; j++) {
                int k;
                for (k = 0; k < word.length; k++) {
                    if (letterGrid[i + k][j + k] != word[k]) {
                        break;
                    }
                }
                if (k == word.length) {
                    return true;
                }
            }
        }
        // Additional diagonals can be added here if needed (e.g., top-right to bottom-left)
        return false;
    }

    public static float[][] minsAndMaxs(float[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        float[][] result = new float[a.length][2];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null || a[i].length == 0) {
                result[i] = new float[]{Float.NaN, Float.NaN};  // Handle empty subarrays
                continue;
            }

            float min = Float.MAX_VALUE;
            float max = Float.MIN_VALUE;
            for (float cur : a[i]) {
                if (cur < min) {
                    min = cur;
                }
                if (cur > max) {
                    max = cur;
                }
            }
            result[i] = new float[]{min, max};
        }
        return result;
    }
    public static long[][] minsAndMaxs(long[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        long[][] result = new long[a.length][2];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null || a[i].length == 0) {
                result[i] = new long[]{};  // Handle empty subarrays
                continue;
            }

            long min = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            for (long cur : a[i]) {
                if (cur < min) {
                    min = cur;
                }
                if (cur > max) {
                    max = cur;
                }
            }
            result[i] = new long[]{min, max};
        }
        return result;
    }
    public static int[][] minsAndMaxs(int[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        int[][] result = new int[a.length][2];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null || a[i].length == 0) {
                result[i] = new int[]{};  // Handle empty subarrays
                continue;
            }

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
    public static double[][] minsAndMaxs(double[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        double[][] result = new double[a.length][2];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null || a[i].length == 0) {
                result[i] = new double[]{Double.NaN, Double.NaN};  // Handle empty subarrays
                continue;
            }

            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;
            for (double cur : a[i]) {
                if (cur < min) {
                    min = cur;
                }
                if (cur > max) {
                    max = cur;
                }
            }
            result[i] = new double[]{min, max};
        }
        return result;
    }
    public static byte[][] minsAndMaxs(byte[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        byte[][] result = new byte[a.length][2];
        for (int i = 0; i < a.length; i++) {
            if (a[i] == null || a[i].length == 0) {
                result[i] = new byte[]{};  // Handle empty subarrays
                continue;
            }

            byte min = Byte.MAX_VALUE;
            byte max = Byte.MIN_VALUE;
            for (byte cur : a[i]) {
                if (cur < min) {
                    min = cur;
                }
                if (cur > max) {
                    max = cur;
                }
            }
            result[i] = new byte[]{min, max};
        }
        return result;
    }

    public static float[][] transpose(float[][] a) {
        if (a == null || a.length == 0 || a[0] == null) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        float[][] result = new float[a[0].length][a.length];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i][j] = a[j][i];
            }
        }
        return result;
    }
    public static long[][] transpose(long[][] a) {
        if (a == null || a.length == 0 || a[0] == null) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        long[][] result = new long[a[0].length][a.length];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i][j] = a[j][i];
            }
        }
        return result;
    }
    public static int[][] transpose(int[][] a) {
        if (a == null || a.length == 0 || a[0] == null) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        int[][] result = new int[a[0].length][a.length];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i][j] = a[j][i];
            }
        }
        return result;
    }
    public static double[][] transpose(double[][] a) {
        if (a == null || a.length == 0 || a[0] == null) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        double[][] result = new double[a[0].length][a.length];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i][j] = a[j][i];
            }
        }
        return result;
    }
    public static String[][] transpose(String[][] a) {
        if (a == null || a.length == 0 || a[0] == null) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        String[][] result = new String[a[0].length][a.length];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i][j] = a[j][i];
            }
        }
        return result;
    }
    public static char[][] transpose(char[][] a) {
        if (a == null || a.length == 0 || a[0] == null) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        char[][] result = new char[a[0].length][a.length];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i][j] = a[j][i];
            }
        }
        return result;
    }
    public static byte[][] transpose(byte[][] a) {
        if (a == null || a.length == 0 || a[0] == null) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        byte[][] result = new byte[a[0].length][a.length];
        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                result[i][j] = a[j][i];
            }
        }
        return result;
    }

    public static float[] linearize(float[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        int newLen = 0;
        for (float[] subArray : a) {
            if (subArray != null) {
                newLen += subArray.length;
            }
        }

        float[] newArray = new float[newLen];
        int totalIndex = 0;
        for (float[] subArray : a) {
            if (subArray != null) {
                for (float value : subArray) {
                    newArray[totalIndex++] = value;
                }
            }
        }
        return newArray;
    }
    public static long[] linearize(long[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        int newLen = 0;
        for (long[] subArray : a) {
            if (subArray != null) {
                newLen += subArray.length;
            }
        }

        long[] newArray = new long[newLen];
        int totalIndex = 0;
        for (long[] subArray : a) {
            if (subArray != null) {
                for (long value : subArray) {
                    newArray[totalIndex++] = value;
                }
            }
        }
        return newArray;
    }
    public static int[] linearize(int[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        int newLen = 0;
        for (int[] subArray : a) {
            if (subArray != null) {
                newLen += subArray.length;
            }
        }

        int[] newArray = new int[newLen];
        int totalIndex = 0;
        for (int[] subArray : a) {
            if (subArray != null) {
                for (int value : subArray) {
                    newArray[totalIndex++] = value;
                }
            }
        }
        return newArray;
    }
    public static double[] linearize(double[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        int newLen = 0;
        for (double[] subArray : a) {
            if (subArray != null) {
                newLen += subArray.length;
            }
        }

        double[] newArray = new double[newLen];
        int totalIndex = 0;
        for (double[] subArray : a) {
            if (subArray != null) {
                for (double value : subArray) {
                    newArray[totalIndex++] = value;
                }
            }
        }
        return newArray;
    }
    public static String[] linearize(String[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        int newLen = 0;
        for (String[] subArray : a) {
            if (subArray != null) {
                newLen += subArray.length;
            }
        }

        String[] newArray = new String[newLen];
        int totalIndex = 0;
        for (String[] subArray : a) {
            if (subArray != null) {
                for (String value : subArray) {
                    newArray[totalIndex++] = value;
                }
            }
        }
        return newArray;
    }
    public static char[] linearize(char[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        int newLen = 0;
        for (char[] subArray : a) {
            if (subArray != null) {
                newLen += subArray.length;
            }
        }

        char[] newArray = new char[newLen];
        int totalIndex = 0;
        for (char[] subArray : a) {
            if (subArray != null) {
                for (char value : subArray) {
                    newArray[totalIndex++] = value;
                }
            }
        }
        return newArray;
    }
    public static byte[] linearize(byte[][] a) {
        if (a == null) {
            throw new IllegalArgumentException("Input array must not be null.");
        }

        int newLen = 0;
        for (byte[] subArray : a) {
            if (subArray != null) {
                newLen += subArray.length;
            }
        }

        byte[] newArray = new byte[newLen];
        int totalIndex = 0;
        for (byte[] subArray : a) {
            if (subArray != null) {
                for (byte value : subArray) {
                    newArray[totalIndex++] = value;
                }
            }
        }
        return newArray;
    }










}