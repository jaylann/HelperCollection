package SortingAlgorithms.Tests;

import SortingAlgorithms.InsertionSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;


public class InsertionSortTest {

        @Test
        public void testInsertionSort() {
            // Create a list of integers
            List<Integer> list = Arrays.asList(5, 3, 8, 2, 9, 1);
    
            // Get the InsertionSort algorithm
            Consumer<List<Integer>> insertionSort = InsertionSort.getInsertionSortAlgorithm();
    
            // Sort the list
            insertionSort.accept(list);
    
            // Check if the list is sorted in ascending order
            for (int i = 0; i < list.size() - 1; i++) {
                assertTrue(list.get(i) <= list.get(i + 1));
            }
        }
    
        @Test
        public void testInsertionSortEmpty() {
            // Create a list of integers
            List<Integer> list = Arrays.asList();
    
            // Get the InsertionSort algorithm
            Consumer<List<Integer>> insertionSort = InsertionSort.getInsertionSortAlgorithm();
    
            // Sort the list
            insertionSort.accept(list);
    
            assertTrue(list.isEmpty());
        }
    
        @Test
        public void testInsertionSortSorted() {
            // Create a list of integers
            List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 9);
    
            // Get the InsertionSort algorithm
            Consumer<List<Integer>> insertionSort = InsertionSort.getInsertionSortAlgorithm();
    
            // Sort the list
            insertionSort.accept(list);
    
            // Check if the list is sorted in ascending order
            for (int i = 0; i < list.size() - 1; i++) {
                assertTrue(list.get(i) <= list.get(i + 1));
            }
        }
    
        @Test
        void testInsertionSortDuplicates() {
                    // Create a list of integers
            List<Integer> list = Arrays.asList(1, 2, 3, 5, 8, 1, 5, 9);;
    
            // Get the InsertionSort algorithm
            Consumer<List<Integer>> insertionSort = InsertionSort.getInsertionSortAlgorithm();
    
            // Sort the list
            insertionSort.accept(list);
    
            // Check if the list is sorted in ascending order
            for (int i = 0; i < list.size() - 1; i++) {
                assertTrue(list.get(i) <= list.get(i + 1));
            }
        }
    
        @Test
        void testInsertionSortCollection() {
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
    
            // Get the InsertionSort algorithm
            Consumer<List<Person>> insertionSort = InsertionSort.getInsertionSortAlgorithm();
    
            // Sort the list
            insertionSort.accept(list);
    
            System.out.println(list);
    
            for (int i = 0; i < list.size() - 1; i++) {
                assertTrue(list.get(i).equals(expected.get(i)));
            }
        }
    }

