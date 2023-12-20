/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed, 20th December 2023, 17:00
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package RecursiveDataTypes;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RecursiveUndirectedGraph {

    public Map<Integer, Set<Integer>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(Map<Integer, Set<Integer>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    private Map<Integer, Set<Integer>> adjacencyList;

    public RecursiveUndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    public void addVertex(int vertex) {
        adjacencyList.putIfAbsent(vertex, new HashSet<>());
    }

    public void addEdge(int vertex1, int vertex2) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2)) {
            throw new IllegalArgumentException("Both vertices must be in the graph.");
        }
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    public boolean hasVertex(int vertex) {
        return adjacencyList.containsKey(vertex);
    }

    public boolean hasEdge(int vertex1, int vertex2) {
        return adjacencyList.containsKey(vertex1) && adjacencyList.get(vertex1).contains(vertex2);
    }

    public void removeVertex(int vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex does not exist.");
        }
        adjacencyList.values().forEach(e -> e.remove(vertex));
        adjacencyList.remove(vertex);
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (!adjacencyList.containsKey(vertex1) || !adjacencyList.containsKey(vertex2)) {
            throw new IllegalArgumentException("Both vertices must be in the graph.");
        }
        adjacencyList.get(vertex1).remove(vertex2);
        adjacencyList.get(vertex2).remove(vertex1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int vertex : adjacencyList.keySet()) {
            sb.append(vertex).append(": ").append(adjacencyList.get(vertex)).append("\n");
        }
        return sb.toString();
    }
}

