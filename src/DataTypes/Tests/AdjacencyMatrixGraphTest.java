/*
 * - Lanfermann, Justin (jaylann). "HelperCollection." GitHub repository.
 *   https://github.com/jaylann/HelperCollection.
 *   Last commit: Wed, 20th December 2023, 17:00
 *
 * This file is part of the "HelperCollection" project, developed and maintained by
 * Justin Lanfermann (jaylann). For more information, updates, collaborators and terms of use,
 * please visit the GitHub repository.
 */
package DataTypes.Tests;

import DataTypes.AdjacencyMatrixGraph;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjacencyMatrixGraphTest {

    private AdjacencyMatrixGraph graph;

    @BeforeEach
    void setUp() {
        graph = new AdjacencyMatrixGraph(5); // initializing the graph with 5 vertices
    }

    @Test
    void testAddAndRemoveEdges() {
        // Test adding and removing edges
        assertFalse(graph.hasEdge(0, 1));
        graph.addEdge(0, 1);
        assertTrue(graph.hasEdge(0, 1));

        graph.removeEdge(0, 1);
        assertFalse(graph.hasEdge(0, 1));
    }

    @Test
    void testAddEdgeInvalidVertices() {
        // Test adding an edge with invalid vertices
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(-1, 5));
    }

    @Test
    void testRemoveEdgeInvalidVertices() {
        // Test removing an edge with invalid vertices
        graph.addEdge(0, 1);
        assertThrows(IllegalArgumentException.class, () -> graph.removeEdge(-1, 5));
    }

    @Test
    void testHasEdgeInvalidVertices() {
        // Test checking an edge with invalid vertices
        assertThrows(IllegalArgumentException.class, () -> graph.hasEdge(-1, 5));
    }

    @Test
    void testGetNumVertices() {
        // Test number of vertices
        assertEquals(5, graph.getNumVertices());
    }

    @Test
    void testIterator() {
        // Test the iterator to ensure it correctly iterates over edges
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        Iterator<AdjacencyMatrixGraph.Edge> it = graph.iterator();
        assertTrue(it.hasNext());
        assertNotNull(it.next());
        assertTrue(it.hasNext());
        assertNotNull(it.next());
        assertTrue(it.hasNext());
        assertNotNull(it.next());
        assertFalse(it.hasNext());

        // Test the iterator's failsafe mechanism
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void testIteratorNoEdges() {
        // Test the iterator when there are no edges
        Iterator<AdjacencyMatrixGraph.Edge> it = graph.iterator();
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }
}
