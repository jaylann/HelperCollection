package DataTypes;

import java.util.*;

public class DirectedGraph<T> {
    private Map<T, List<T>> adjacencyList;

    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(T vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge from vertex source to vertex destination
    public void addEdge(T source, T destination) {
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
    }

    // Remove a vertex and all associated edges
    public void removeVertex(T vertex) {
        adjacencyList.values().forEach(e -> e.remove(vertex));
        adjacencyList.remove(vertex);
    }

    // Remove an edge from the graph
    public void removeEdge(T source, T destination) {
        List<T> edges = adjacencyList.get(source);
        if (edges != null) {
            edges.remove(destination);
        }
    }

    // Iterator for traversing the graph
    public Iterator<T> iterator(TraversalOrder order) {
        return new GraphIterator(order);
    }

    private class GraphIterator implements Iterator<T> {
        private Set<T> visited;
        private Stack<T> stack;
        private TraversalOrder order;

        public GraphIterator(TraversalOrder order) {
            visited = new HashSet<>();
            stack = new Stack<>();
            this.order = order;
            for (T vertex : adjacencyList.keySet()) {
                if (!visited.contains(vertex)) {
                    traverse(vertex);
                }
            }
        }

        private void traverse(T current) {
            visited.add(current);
            switch (order) {
                case PRE_ORDER:
                    stack.push(current);
                    adjacencyList.getOrDefault(current, Collections.emptyList())
                            .forEach(neighbor -> {
                                if (!visited.contains(neighbor)) {
                                    traverse(neighbor);
                                }
                            });
                    break;
                case POST_ORDER:
                    adjacencyList.getOrDefault(current, Collections.emptyList())
                            .forEach(neighbor -> {
                                if (!visited.contains(neighbor)) {
                                    traverse(neighbor);
                                }
                            });
                    stack.push(current);
                    break;
                case IN_ORDER:
                default:
                    // For directed graphs, in-order doesn't naturally apply.
                    // Treating as a variant of depth-first traversal.
                    stack.push(current);
                    break;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            return stack.pop();
        }
    }

    public enum TraversalOrder {
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }
}

