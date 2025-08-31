package com.shrvn.algo.chapter12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class UndirectedGraphTest {
    private UndirectedGraph sampleGraph;

    @BeforeEach
    void setUp() {
        sampleGraph = new UndirectedGraph(3);
        sampleGraph.addEdge(0, 1);
        sampleGraph.addEdge(1, 2);
    }

    @Test
    void testGraphCreation() {
        assertEquals(3, sampleGraph.V());
        assertEquals(2, sampleGraph.E());
    }

    @Test
    void testAddEdgeAndAdjacency() {
        assertEquals(2, sampleGraph.E());
        assertTrue(sampleGraph.adj(1).iterator().hasNext());
        assertTrue(((Iterable<Integer>)sampleGraph.adj(1)).iterator().hasNext());
    }

    @Test
    void testDegree() {
        assertEquals(2, sampleGraph.degree(1));
        assertEquals(1, sampleGraph.degree(0));
        assertEquals(1, sampleGraph.degree(2));
    }

    @Test
    void testMaxDegree() {
        // For sampleGraph, vertex 1 has degree 2
        assertEquals(2, sampleGraph.maxDegree());
    }

    @Test
    void testSelfLoop() {
        UndirectedGraph g = new UndirectedGraph(2);
        g.addEdge(0, 0);
        assertEquals(1, g.numberOfSelfLoops());
    }

    @Test
    void testToString() {
        UndirectedGraph g = new UndirectedGraph(2);
        g.addEdge(0, 1);
        String s = g.toString();
        assertTrue(s.contains("0: 1"));
        assertTrue(s.contains("1: 0"));
    }

    @Test
    void testInvalidVertex() {
        UndirectedGraph g = new UndirectedGraph(2);
        assertThrows(IllegalArgumentException.class, () -> g.addEdge(0, 2));
        assertThrows(IllegalArgumentException.class, () -> g.adj(-1));
        assertThrows(IllegalArgumentException.class, () -> g.degree(5));
    }
}
