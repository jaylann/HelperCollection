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

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjacencyMatrixGraph implements Iterable<AdjacencyMatrixGraph.Edge> {
    private int[][] adjacencyMatrix;
    private int numVertices;

    // Constructor for AdjacencyMatrixGraph
    public AdjacencyMatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    // Adds an edge to the graph
    public void addEdge(int source, int destination) {
        checkVertex(source);
        checkVertex(destination);

        adjacencyMatrix[source][destination] = 1; // Assuming 1 indicates an edge
        adjacencyMatrix[destination][source] = 1; // For undirected graph
    }

    // Removes an edge from the graph
    public void removeEdge(int source, int destination) {
        checkVertex(source);
        checkVertex(destination);

        adjacencyMatrix[source][destination] = 0;
        adjacencyMatrix[destination][source] = 0;
    }

    // Checks if an edge exists
    public boolean hasEdge(int source, int destination) {
        checkVertex(source);
        checkVertex(destination);

        return adjacencyMatrix[source][destination] == 1;
    }

    // Returns the number of vertices
    public int getNumVertices() {
        return numVertices;
    }

    // Helper method to check if vertex is valid
    private void checkVertex(int vertex) {
        if (vertex < 0 || vertex >= numVertices) {
            throw new IllegalArgumentException("Vertex " + vertex + " is out of bounds");
        }
    }

    @Override
    public Iterator<Edge> iterator() {
        return new GraphIterator();
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    private class GraphIterator implements Iterator<Edge> {
        private int currentRow = 0;
        private int currentCol = -1;
        private Edge nextEdge = null;

        public int getCurrentRow() {
            return currentRow;
        }

        public void setCurrentRow(int currentRow) {
            this.currentRow = currentRow;
        }

        public int getCurrentCol() {
            return currentCol;
        }

        public void setCurrentCol(int currentCol) {
            this.currentCol = currentCol;
        }

        public Edge getNextEdge() {
            return nextEdge;
        }

        public void setNextEdge(Edge nextEdge) {
            this.nextEdge = nextEdge;
        }

        @Override
        public boolean hasNext() {
            if (nextEdge != null) {
                return true;
            }
            nextEdge = findNextEdge();
            return nextEdge != null;
        }

        @Override
        public Edge next() {
            if (nextEdge == null && !hasNext()) {
                throw new NoSuchElementException();
            }
            Edge edge = nextEdge;
            nextEdge = null;
            return edge;
        }

        private Edge findNextEdge() {
            while (currentRow < numVertices) {
                while (++currentCol < numVertices) {
                    if (adjacencyMatrix[currentRow][currentCol] == 1) {
                        // Skip duplicate edges for undirected graph
                        if (currentRow < currentCol) {
                            return new Edge(currentRow, currentCol);
                        }
                    }
                }
                currentRow++;
                currentCol = -1;
            }
            return null;
        }
    }

    // Helper class to represent an edge
    public static class Edge {
        public final int source;

        public int getSource() {
            return source;
        }

        public int getDestination() {
            return destination;
        }

        public final int destination;

        public Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }

    }

    public static void main(String[] args) {

    }


}

