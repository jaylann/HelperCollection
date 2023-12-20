/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Mon, 18th December 2023, 18:15
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package RecursiveDataTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecursiveDirectedGraph {
    private Map<Integer, Node> nodeLookup = new HashMap<>();

    public static class Node {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<Node> getAdjacent() {
            return adjacent;
        }

        public void setAdjacent(List<Node> adjacent) {
            this.adjacent = adjacent;
        }

        List<Node> adjacent = new ArrayList<>();

        private Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id) {
        return nodeLookup.computeIfAbsent(id, k -> new Node(id));
    }

    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public void removeEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.remove(d);
    }

    // Additional functionalities like removing a node, finding a node, etc. can be added here.

    public Map<Integer, Node> getNodeLookup() {
        return nodeLookup;
    }

    public void setNodeLookup(Map<Integer, Node> nodeLookup) {
        this.nodeLookup = nodeLookup;
    }

    // Example recursive method (e.g., to check if a path exists between two nodes)
    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        Map<Integer, Boolean> visited = new HashMap<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node source, Node destination, Map<Integer, Boolean> visited) {
        if (visited.getOrDefault(source.id, false)) {
            return false;
        }

        visited.put(source.id, true);

        if (source == destination) {
            return true;
        }

        for (Node child : source.adjacent) {
            if (hasPathDFS(child, destination, visited)) {
                return true;
            }
        }

        return false;
    }

    // Main method for demonstration purposes
    public static void main(String[] args) {
        RecursiveDirectedGraph graph = new RecursiveDirectedGraph();
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Path exists from 1 to 4: " + graph.hasPathDFS(1, 4));
    }
}

