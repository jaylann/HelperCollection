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

public class UndirectedGraph<T> {
    private Map<T, List<T>> adjList;

    public Map<T, List<T>> getAdjList() {
        return adjList;
    }

    public void setAdjList(Map<T, List<T>> adjList) {
        this.adjList = adjList;
    }

    public UndirectedGraph() {
        adjList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(T vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge to the graph
    public void addEdge(T vertex1, T vertex2) {
        adjList.putIfAbsent(vertex1, new ArrayList<>());
        adjList.putIfAbsent(vertex2, new ArrayList<>());
        adjList.get(vertex1).add(vertex2);
        adjList.get(vertex2).add(vertex1);
    }

    // Remove a vertex from the graph
    public void removeVertex(T vertex) {
        adjList.values().forEach(e -> e.remove(vertex));
        adjList.remove(vertex);
    }

    // Remove an edge from the graph
    public void removeEdge(T vertex1, T vertex2) {
        List<T> eV1 = adjList.get(vertex1);
        List<T> eV2 = adjList.get(vertex2);
        if (eV1 != null) eV1.remove(vertex2);
        if (eV2 != null) eV2.remove(vertex1);
    }

    // Custom iterator for different traversal orders
    public Iterator<T> iterator(TraversalOrder order) {
        return new GraphIterator(order);
    }

    private class GraphIterator implements Iterator<T> {
        private Set<T> visited;

        public Set<T> getVisited() {
            return visited;
        }

        public void setVisited(Set<T> visited) {
            this.visited = visited;
        }

        public Stack<T> getStack() {
            return stack;
        }

        public void setStack(Stack<T> stack) {
            this.stack = stack;
        }

        public TraversalOrder getOrder() {
            return order;
        }

        public void setOrder(TraversalOrder order) {
            this.order = order;
        }

        private Stack<T> stack;
        private TraversalOrder order;

        public GraphIterator(TraversalOrder order) {
            this.order = order;
            visited = new HashSet<>();
            stack = new Stack<>();
            if (!adjList.isEmpty()) {
                stack.push(adjList.keySet().iterator().next());
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();

            T current = stack.pop();
            visited.add(current);

            for (T neighbor : adjList.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }

            return current;
        }
    }

    public enum TraversalOrder {
        IN_ORDER, POST_ORDER, PRE_ORDER
    }

    // Additional methods can be added as required
}

