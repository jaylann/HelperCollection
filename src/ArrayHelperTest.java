/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed 15. Nov 2023 17:15
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, and terms of use,
 * please visit the GitHub repository.
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ArrayHelperTest {
    @Test
    void testAddElementInt() {
        int[] initialArray = {1, 2, 3};
        int[] expectedArray = {1, 2, 3, 4};
        assertArrayEquals(expectedArray, ArrayHelper.addElement(initialArray, 4));

        assertArrayEquals(new int[]{1}, ArrayHelper.addElement((int[]) null, 1)); // Null check
    }

    @Test
    void testAddElementDouble() {

        double[] initialArray = {1, 2, 3};
        double[] expectedArray = {1, 2, 3, 4};
        assertArrayEquals(expectedArray, ArrayHelper.addElement(initialArray, 4));
        assertArrayEquals(new double[]{1}, ArrayHelper.addElement((double[]) null, 1)); // Null check
    }

    @Test
    void testAddElementLong() {

        long[] initialArray = {1, 2, 3};
        long[] expectedArray = {1, 2, 3, 4};
        assertArrayEquals(expectedArray, ArrayHelper.addElement(initialArray, 4));
        assertArrayEquals(new long[]{1}, ArrayHelper.addElement((long[]) null, 1L)); // Null check
    }

    @Test
    void testAddElementChar() {

        char[] initialArray = {'a', 'c', 'd'};
        char[] expectedArray = {'a', 'c', 'd', 'b'};
        assertArrayEquals(expectedArray, ArrayHelper.addElement(initialArray, 'b'));
        assertArrayEquals(new char[]{'a'}, ArrayHelper.addElement((char[]) null, 'a')); // Null check
    }

    @Test
    void testAddElementByte() {

        byte[] initialArray = {'a', 'c', 'd'};
        byte[] expectedArray = {'a', 'c', 'd', 'b'};
        assertArrayEquals(expectedArray, ArrayHelper.addElement(initialArray, (byte) 'b'));
        assertArrayEquals(new byte[]{'a'}, ArrayHelper.addElement((byte[]) null, (byte) 'a')); // Null check
    }

    @Test
    void testAddElementFloat() {

        float[] initialArray = {1, 2, 3};
        float[] expectedArray = {1, 2, 3, 4};
        assertArrayEquals(expectedArray, ArrayHelper.addElement(initialArray, 4));
        assertArrayEquals(new float[]{1}, ArrayHelper.addElement((float[]) null, 1)); // Null check
    }


    @Test
    void testAddElementString() {

        String[] initialArray = {"1", "2", "3"};
        String[] expectedArray = {"1", "2", "3", "4"};
        assertArrayEquals(expectedArray, ArrayHelper.addElement(initialArray, "4"));
        assertArrayEquals(new String[]{"1"}, ArrayHelper.addElement((String[]) null, "1")); // Null check
    }

}
