/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed, 20th December 2023, 17:00
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */ package SortingAlgorithms.Tests;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.*;

import org.junit.jupiter.api.Test;

import SortingAlgorithms.StalinSort;

public class StalinSortTest {
    @Test
    public void testStalinSort() {
        // Create a list of integers
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5, 4, 7));

        // Get the StalinSort algorithm
        Consumer<List<Integer>> stalinSort = StalinSort.getStalinSortAlgorithm();

        // Sort the list
        stalinSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test
    public void testStalinSortEmpty() {
        // Create a list of integers
        List<Integer> list = Arrays.asList();

        // Get the StalinSort algorithm
        Consumer<List<Integer>> stalinSort = StalinSort.getStalinSortAlgorithm();

        // Sort the list
        stalinSort.accept(list);

        assertTrue(list.isEmpty());

        int t = 5;
    }

    @Test
    public void testStalinSortSorted() {
        // Create a list of integers
        List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 9);

        // Get the StalinSort algorithm
        Consumer<List<Integer>> stalinSort = StalinSort.getStalinSortAlgorithm();

        // Sort the list
        stalinSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test
    void testStalinSortDuplicates() {
        // Create a list of integers
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5, 4, 7));

        // Get the StalinSort algorithm
        Consumer<List<Integer>> stalinSort = StalinSort.getStalinSortAlgorithm();

        // Sort the list
        stalinSort.accept(list);

        // Check if the list is sorted in ascending order
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i) <= list.get(i + 1));
        }
    }

    @Test
    void testStalinSortCollection() {
        // Create a list of integers
        List<Person> list = new ArrayList<>();
        list.add(new Person("Abert", 10));
        list.add(new Person("Ferenc", 21));
        list.add(new Person("Justin", 1));
        list.add(new Person("Ana", 18));

        List<Person> expected = new ArrayList<>();

        expected.add(new Person("Abert", 10));
        expected.add(new Person("Ferenc", 21));

        // Get the StalinSort algorithm
        Consumer<List<Person>> stalinSort = StalinSort.getStalinSortAlgorithm();

        // Sort the list
        stalinSort.accept(list);

        System.out.println(list);

        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(list.get(i).equals(expected.get(i)));
        }
    }
}
