/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed, 20th December 2023, 17:00
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package DataTypes;

import java.util.*;

public class WeightedGraph {
    public Map<Integer, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(Map<Integer, List<Edge>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    private class Edge {
        int source;
        int destination;

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getDestination() {
            return destination;
        }

        public void setDestination(int destination) {
            this.destination = destination;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        double weight;

        public Edge(int source, int destination, double weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    private Map<Integer, List<Edge>> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void insertEdge(int source, int destination, double weight) {
        this.adjacencyList.putIfAbsent(source, new ArrayList<>());
        this.adjacencyList.putIfAbsent(destination, new ArrayList<>());
        this.adjacencyList.get(source).add(new Edge(source, destination, weight));
    }

    public void deleteEdge(int source, int destination) {
        this.adjacencyList.getOrDefault(source, new ArrayList<>())
                .removeIf(edge -> edge.destination == destination);
    }

    public Iterator<Integer> iterator(TraversalOrder order) {
        return new GraphIterator(order);
    }

    private class GraphIterator implements Iterator<Integer> {
        private Set<Integer> visited;

        public Set<Integer> getVisited() {
            return visited;
        }

        public void setVisited(Set<Integer> visited) {
            this.visited = visited;
        }

        public Stack<Integer> getStack() {
            return stack;
        }

        public void setStack(Stack<Integer> stack) {
            this.stack = stack;
        }

        public TraversalOrder getOrder() {
            return order;
        }

        public void setOrder(TraversalOrder order) {
            this.order = order;
        }

        private Stack<Integer> stack;
        private TraversalOrder order;

        public GraphIterator(TraversalOrder order) {
            this.visited = new HashSet<>();
            this.stack = new Stack<>();
            this.order = order;
            if (!adjacencyList.isEmpty()) {
                this.stack.push(adjacencyList.keySet().iterator().next());
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public Integer next() {
            if (!hasNext()) throw new NoSuchElementException();
            int current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                for (Edge edge : adjacencyList.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(edge.destination)) {
                        stack.push(edge.destination);
                    }
                }
                return current;
            }
            return next();
        }
    }

    public enum TraversalOrder {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }
}

