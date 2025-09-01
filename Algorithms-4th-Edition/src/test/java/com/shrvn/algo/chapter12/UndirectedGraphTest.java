package com.shrvn.algo.chapter12;

import edu.princeton.cs.algs4.In;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link UndirectedGraph} class.
 * Uses the tinyG.txt sample graph for most tests.
 */
@Slf4j
class UndirectedGraphTest {
    private UndirectedGraph sampleGraph;

    /**
     * Loads the sample graph from tinyG.txt before each test.
     */
    @BeforeEach
    void setUp() {
        sampleGraph = new UndirectedGraph(new In("algs4-data/tinyG.txt"));
    }

    /**
     * Tests that the graph is created with the correct number of vertices and edges.
     */
    @Test
    void testGraphCreation() {
        assertEquals(13, sampleGraph.V());
        assertEquals(13, sampleGraph.E());
    }

    /**
     * Tests adjacency and edge addition for a sample vertex.
     */
    @Test
    void testAddEdgeAndAdjacency() {
        assertTrue(sampleGraph.adj(0).iterator().hasNext());
        assertTrue(sampleGraph.adj(0).iterator().hasNext());
        assertTrue(sampleGraph.degree(0) > 0);
    }

    /**
     * Tests the degree calculation for specific vertices.
     */
    @Test
    void testDegree() {
        assertEquals(4, sampleGraph.degree(0));
        assertEquals(1, sampleGraph.degree(7));
    }

    /**
     * Tests the maximum degree calculation in the sample graph.
     */
    @Test
    void testMaxDegree() {
        assertEquals(4, sampleGraph.maxDegree());
    }

    /**
     * Tests the detection of self-loops in a small custom graph.
     */
    @Test
    void testSelfLoop() {
        UndirectedGraph g = new UndirectedGraph(2);
        g.addEdge(0, 0);
        assertEquals(1, g.numberOfSelfLoops());
    }

    /**
     * Tests the string representation of the sample graph.
     */
    @Test
    void testToString() {
        String s = sampleGraph.toString();
        log.info(s);
        assertTrue(s.contains("0: 5 1 2 6"));
        assertTrue(s.contains("6: 4 0"));
    }

    /**
     * Tests that invalid vertex operations throw exceptions.
     */
    @Test
    void testInvalidVertex() {
        UndirectedGraph g = new UndirectedGraph(2);
        assertThrows(IllegalArgumentException.class, () -> g.addEdge(0, 2));
        assertThrows(IllegalArgumentException.class, () -> g.adj(-1));
        assertThrows(IllegalArgumentException.class, () -> g.degree(5));
    }
}
