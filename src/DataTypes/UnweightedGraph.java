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

public class UnweightedGraph<T> implements Iterable<T> {
    public Map<T, List<T>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(Map<T, List<T>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    private Map<T, List<T>> adjacencyList;

    public UnweightedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add a new vertex to the graph
    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new LinkedList<>());
    }

    // Add an edge between two vertices
    public void addEdge(T source, T destination) {
        if (!adjacencyList.containsKey(source)) addVertex(source);
        if (!adjacencyList.containsKey(destination)) addVertex(destination);

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Remove an edge between two vertices
    public void removeEdge(T source, T destination) {
        if (!adjacencyList.containsKey(source) || !adjacencyList.containsKey(destination)) return;

        adjacencyList.get(source).remove(destination);
        adjacencyList.get(destination).remove(source);
    }

    // Remove a vertex and all connected edges
    public void removeVertex(T vertex) {
        adjacencyList.values().forEach(e -> e.remove(vertex));
        adjacencyList.remove(vertex);
    }

    @Override
    public Iterator<T> iterator() {
        return new GraphIterator();
    }

    private class GraphIterator implements Iterator<T> {
        private Iterator<T> vertexIterator;

        public Iterator<T> getVertexIterator() {
            return vertexIterator;
        }

        public void setVertexIterator(Iterator<T> vertexIterator) {
            this.vertexIterator = vertexIterator;
        }

        public GraphIterator() {
            this.vertexIterator = adjacencyList.keySet().iterator();
        }

        @Override
        public boolean hasNext() {
            return vertexIterator.hasNext();
        }

        @Override
        public T next() {
            return vertexIterator.next();
        }
    }

    // Example usage: Display all vertices and their connected edges
    public void displayGraph() {
        for (T vertex : adjacencyList.keySet()) {
            System.out.print(vertex + " -> ");
            for (T edge : adjacencyList.get(vertex)) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
}

