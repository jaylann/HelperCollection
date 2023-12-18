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
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
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
        if (adjacencyList.containsKey(source) && adjacencyList.containsKey(destination)) {
            adjacencyList.get(source).remove(destination);
        }
    }

    // Returns a list of adjacent vertices for a given vertex
    public List<T> getAdjVertices(T vertex) {
        return adjacencyList.get(vertex);
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
}