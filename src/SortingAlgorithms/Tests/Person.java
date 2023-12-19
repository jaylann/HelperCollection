package SortingAlgorithms.Tests;

public class Person implements Comparable<Person> {
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

    @Override
    public boolean equals(Object other) {
        if(other instanceof Person == false) return false;
        
        if(((Person)other).age == age && ((Person)other).name.equals(name)) return true; 
        return false;
    }
}