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

import java.util.*;


class RecursiveWeightedGraph {
    private Map<String, Node> nodes = new HashMap<>();

    // Method to add a node
    public void addNode(String id) {
        nodes.putIfAbsent(id, new Node(id));
    }

    // Method to add an edge
    public void addEdge(String fromId, String toId, double weight) {
        Node from = nodes.get(fromId);
        Node to = nodes.get(toId);

        if (from == null || to == null) {
            throw new IllegalArgumentException("Invalid node identifier.");
        }

        from.addEdge(to, weight);
    }

    public Map<String, Node> getNodes() {
        return nodes;
    }

    public void setNodes(Map<String, Node> nodes) {
        this.nodes = nodes;
    }

    // Recursive method to traverse the graph
    public void traverseGraph(String startId, Set<String> visited) {
        if (!nodes.containsKey(startId) || visited.contains(startId)) {
            return;
        }

        visited.add(startId);
        System.out.println("Visited node: " + startId);

        for (Edge edge : nodes.get(startId).edges) {
            traverseGraph(edge.to.id, visited);
        }
    }

    // Utility method to start traversal
    public void startTraversal(String startId) {
        traverseGraph(startId, new HashSet<>());
    }

    class Node {
        public String id;
        public List<Edge> edges;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<Edge> getEdges() {
            return edges;
        }

        public void setEdges(List<Edge> edges) {
            this.edges = edges;
        }

        public Node(String id) {
            this.id = id;
            this.edges = new ArrayList<>();
        }

        // Method to add an edge from this node
        public void addEdge(Node to, double weight) {
            edges.add(new Edge(this, to, weight));
        }
    }

    class Edge {
        public Node getFrom() {
            return from;
        }

        public void setFrom(Node from) {
            this.from = from;
        }

        public Node getTo() {
            return to;
        }

        public void setTo(Node to) {
            this.to = to;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public Node from;
        public Node to;
        public double weight;

        public Edge(Node from, Node to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}

