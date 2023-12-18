package DataTypes;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjacencyMatrixGraph {
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

    // Inner class for implementing Iterator
    private class AdjacencyMatrixIterator implements Iterator<Integer> {
        private int row;
        private int nextCol;

        public AdjacencyMatrixIterator(int row) {
            this.row = row;
            this.nextCol = -1;
            advance();
        }

        private void advance() {
            nextCol++;
            while (nextCol < numVertices && adjacencyMatrix[row][nextCol] == 0) {
                nextCol++;
            }
        }

        @Override
        public boolean hasNext() {
            return nextCol < numVertices;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int currentCol = nextCol;
            advance();
            return currentCol;
        }
    }

    // Provides an iterator for a given vertex
    public Iterator<Integer> iterator(int vertex) {
        checkVertex(vertex);
        return new AdjacencyMatrixIterator(vertex);
    }

    // For debugging: Prints the adjacency matrix
    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

