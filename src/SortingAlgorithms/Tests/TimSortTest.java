package SortingAlgorithms.Tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.jupiter.api.Test;

import SortingAlgorithms.TimSort;

public class TimSortTest {
    @Test
    public void testTimSort() {
        // Create a list of integers
        List<Integer> list = Arrays.asList(5, 3, 8, 2, 9, 1);

        // Get the TimSort algorithm
        Consumer<List<Integer>> timSort = TimSort.getTimSortAlgorithm();

        // Sort the list
        timSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test
    public void testTimSortEmpty() {
        // Create a list of integers
        List<Integer> list = Arrays.asList();

        // Get the TimSort algorithm
        Consumer<List<Integer>> timSort = TimSort.getTimSortAlgorithm();

        // Sort the list
        timSort.accept(list);

        assertTrue(list.isEmpty());
    }

    @Test
    public void testTimSortSorted() {
        // Create a list of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 9);

        // Get the TimSort algorithm
        Consumer<List<Integer>> timSort = TimSort.getTimSortAlgorithm();

        // Sort the list
        timSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test
    void testTimSortDuplicates() {
                // Create a list of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 1, 5, 9);;

        // Get the TimSort algorithm
        Consumer<List<Integer>> timSort = TimSort.getTimSortAlgorithm();

        // Sort the list
        timSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test
    void testTimSortCollection() {
        // Create a list of integers
        List<Person> list = new ArrayList<>();
        list.add(new Person("Abert", 10));
        list.add(new Person("Ferenc", 21));
        list.add(new Person("Justin", 1));
        list.add(new Person("Ana", 18));

        List<Person> expected = new ArrayList<>();
        expected.add(new Person("Justin", 1));
        expected.add(new Person("Abert", 10));
        expected.add(new Person("Ana", 18));
        expected.add(new Person("Ferenc", 21));

        // Get the TimSort algorithm
        Consumer<List<Person>> timSort = TimSort.getTimSortAlgorithm();

        // Sort the list
        timSort.accept(list);

        System.out.println(list);

        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i).equals(expected.get(i)));
        }
    }
}
