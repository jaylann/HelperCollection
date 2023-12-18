package DataTypes.Tests;

import static org.junit.Assert.*;

import DataTypes.AdjacencyGraph;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.*;

public class AdjacencyGraphTest {

    private AdjacencyGraph<String> graph;

    @Before
    public void setUp() {
        graph = new AdjacencyGraph<>();
    }

    @Test
    public void testAddVertex() {
        graph.addVertex("A");
        assertTrue(graph.containsVertex("A"));
    }

    @Test
    public void testAddEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");
        assertTrue(graph.containsEdge("A", "B"));
    }

    @Test
    public void testRemoveVertex() {
        graph.addVertex("A");
        graph.removeVertex("A");
        assertFalse(graph.containsVertex("A"));
    }

    @Test
    public void testRemoveEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");
        graph.removeEdge("A", "B");
        assertFalse(graph.containsEdge("A", "B"));
    }

    @Test
    public void testGetAdjVertices() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");
        List<String> adjVertices = graph.getAdjVertices("A");
        assertTrue(adjVertices.contains("B"));
        assertEquals(1, adjVertices.size());
    }

    @Test
    public void testIterator() {
        graph.addVertex("A");
        graph.addVertex("B");
        Iterator<String> iterator = graph.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
    }

    @Test
    public void testGraphWithNoVerticesOrEdges() {
        assertFalse(graph.iterator().hasNext());
        assertTrue(graph.getAdjVertices("A").isEmpty());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNoSuchElement() {
        graph.addVertex("A");
        Iterator<String> iterator = graph.iterator();
        iterator.next(); // A
        iterator.next(); // Should throw NoSuchElementException
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeNonExistentVertices() {
        graph.addEdge("A", "B"); // Should throw IllegalArgumentException because vertices don't exist
    }

    @Test
    public void testRemoveNonExistentVertex() {
        graph.removeVertex("A"); // Should return false as the vertex does not exist
    }

    @Test
    public void testRemoveNonExistentEdge() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.removeEdge("A", "C"); // Should return false as the edge does not exist
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeWithNullVertex() {
        graph.addEdge("A", null); // Should throw IllegalArgumentException because one vertex is null
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveEdgeWithNullVertex() {
        graph.addVertex("A");
        graph.removeEdge("A", null); // Should throw IllegalArgumentException because one vertex is null
    }


    @Test
    public void testLargeGraph() {
        // This test checks the graph's integrity after a large number of operations
        for (int i = 0; i < 1000; i++) {
            graph.addVertex("V" + i);
        }
        for (int i = 0; i < 999; i++) {
            graph.addEdge("V" + i, "V" + (i + 1));
        }
        assertEquals(1000, graph.vertexSet().size());
        assertEquals(1000, graph.edgeSet().size());
    }


    @Test
    public void testSelfLoop() {
        graph.addVertex("A");
        graph.addEdge("A", "A"); // Assuming self-loops are allowed
        assertTrue(graph.containsEdge("A", "A"));
    }

    @Test
    public void testGraphClear() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B");
        graph.removeVertex("A"); // Assuming a method to clear the graph exists
        graph.removeVertex("B"); // Assuming a method to clear the graph exists
        graph.removeEdge("A", "B");
        assertFalse(graph.containsVertex("A"));
        assertFalse(graph.containsVertex("B"));
        assertFalse(graph.iterator().hasNext());
    }

}
