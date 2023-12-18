/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Mon, 18th December 2023, 18:15
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package SortingAlgorithms;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;


public class SortingExample {

    public static void main(String[] args) {
        // Example 1: Sorting a list of integers using BubbleSort
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5);
        Sortable.sort(numbers, BubbleSort.getBubbleSortAlgorithm());
        System.out.println("Sorted List of Integers: " + numbers);

        // Example 2: Sorting an array (converted to an Iterable) using BubbleSort
        Integer[] numberArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        Sortable.sort(Arrays.asList(numberArray), BubbleSort.getBubbleSortAlgorithm());
        System.out.println("Sorted Array (as Iterable): " + Arrays.toString(numberArray));

        // Example 3: Sorting a list of Strings
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        Sortable.sort(words, BubbleSort.getBubbleSortAlgorithm());
        System.out.println("Sorted List of Strings: " + words);

        // Example 4: Sorting an array of Strings
        String[] wordArray = {"kiwi", "grape", "mango", "lemon"};
        List<String> wordList = Arrays.asList(wordArray);
        Sortable.sort(wordList, BubbleSort.getBubbleSortAlgorithm());
        System.out.println("Sorted Array of Strings: " + Arrays.toString(wordArray));
        // Example 5: Sorting a list of custom objects (Persons)
        List<Person> people = Arrays.asList(new Person("Alice", 30), new Person("Bob", 25), new Person("Charlie", 35));
        Sortable.sort(people, BubbleSort.getBubbleSortAlgorithm());
        System.out.println("Sorted List of Persons: " + people);

        // Example 6: Sorting a generic iterable (Set of Doubles)
        Set<Double> numbersSet = new HashSet<>(Arrays.asList(3.1, 2.2, 1.3));
        List<Double> sortedNumbers = Sortable.sort(numbersSet, BubbleSort.getBubbleSortAlgorithm());
        System.out.println("Sorted Set of Doubles: " + sortedNumbers);
    }
}
class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}



