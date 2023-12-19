/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Mon, 18th December 2023, 18:15
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package DataTypes;

import java.util.*;

public class AdjacencyGraph<T> implements Iterable<T> {
    private Map<T, List<T>> adjacencyList;

    public AdjacencyGraph() {
        this.adjacencyList = new HashMap<>();
    }

    // Adds a new vertex to the graph
    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new LinkedList<>());
    }

    // Adds an edge between two vertices
    public void addEdge(T source, T destination) {
        if (!adjacencyList.containsKey(source)) {
            throw new IllegalArgumentException("Source doesn't exist in graph");
        }
        if (!adjacencyList.containsKey(destination)) {
            throw new IllegalArgumentException("Destination doesn't exist in graph");

        }
        if (adjacencyList.get(source).contains(destination)) {
            return;
        }
        adjacencyList.get(source).add(destination);
    }

    // Removes a vertex and all associated edges
    public void removeVertex(T vertex) {
        adjacencyList.values().forEach(e -> e.remove(vertex));
        adjacencyList.remove(vertex);
    }

    // Removes an edge between two vertices
    public void removeEdge(T source, T destination) {
        if (destination == null || source == null) {
            throw new IllegalArgumentException("Source and Destination must both be not null");
        }
        if (adjacencyList.containsKey(source) && adjacencyList.containsKey(destination)) {
            adjacencyList.get(source).remove(destination);
        }
    }

    // Returns a list of adjacent vertices for a given vertex
    public List<T> getAdjVertices(T vertex) {
        List<T> adjVertices = adjacencyList.get(vertex);
        if (adjVertices == null) {
            return new ArrayList<>();
        }
        return adjVertices;
    }
    // Method to get the set of all vertices
    public Set<T> vertexSet() {
        return new HashSet<>(adjacencyList.keySet());
    }
    public Set<List<T>> edgeSet() {
        return new HashSet<>(adjacencyList.values());
    }


    // Iterator implementation
    @Override
    public Iterator<T> iterator() {
        return adjacencyList.keySet().iterator();
    }

    // Helper function to print the graph (optional)
    public void printGraph() {
        for (T vertex : adjacencyList.keySet()) {
            System.out.print(vertex.toString() + " -> ");
            for (T w : adjacencyList.get(vertex)) {
                System.out.print(w.toString() + " ");
            }
            System.out.println();
        }
    }
    // ... [previous class code] ...

    // Checks if a vertex exists in the graph
    public boolean containsVertex(T vertex) {
        return adjacencyList.containsKey(vertex);
    }

    // Checks if an edge exists between two vertices
    public boolean containsEdge(T source, T destination) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) {
            return false;
        }
        return adjacencyList.get(source).contains(destination);
    }

    // Usage Example
    public static void main(String[] args) {
        AdjacencyGraph<String> graph = new AdjacencyGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "A");
        graph.addEdge("A", "B");
        // Should return A, C
        System.out.println(graph.getAdjVertices("B"));
        // Should return B
        System.out.println(graph.getAdjVertices("A"));
        // True
        System.out.println(graph.containsVertex("A"));
        System.out.println(graph.containsEdge("A", "B"));
        // False
        System.out.println(graph.containsEdge("A", "C"));
        graph.removeVertex("B");
        System.out.println(graph.containsVertex("B"));
        for (String current : graph) {
            System.out.println(current);
        }


    }

    public Map<T, List<T>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(Map<T, List<T>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
}