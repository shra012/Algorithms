package com.shrvn.algo.chapter12;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


class UndirectedGraphTest {
    private UndirectedGraph sampleGraph;

    @BeforeEach
    void setUp() {
        sampleGraph = new UndirectedGraph(new In("algs4-data/tinyG.txt"));
    }

    @Test
    void testGraphCreation() {
        assertEquals(13, sampleGraph.V());
        assertEquals(13, sampleGraph.E());
    }

    @Test
    void testAddEdgeAndAdjacency() {
        assertTrue(sampleGraph.adj(0).iterator().hasNext());
        assertTrue(((Iterable<Integer>)sampleGraph.adj(0)).iterator().hasNext());
        assertTrue(sampleGraph.degree(0) > 0);
    }

    @Test
    void testDegree() {
        assertEquals(4, sampleGraph.degree(0));
        assertEquals(1, sampleGraph.degree(7));
    }

    @Test
    void testMaxDegree() {
        assertEquals(4, sampleGraph.maxDegree());
    }

    @Test
    void testSelfLoop() {
        UndirectedGraph g = new UndirectedGraph(2);
        g.addEdge(0, 0);
        assertEquals(1, g.numberOfSelfLoops());
    }

    @Test
    void testToString() {
        String s = sampleGraph.toString();
        assertTrue(s.contains("0: 5 1 2 6"));
        assertTrue(s.contains("6: 4 0"));
    }

    @Test
    void testInvalidVertex() {
        UndirectedGraph g = new UndirectedGraph(2);
        assertThrows(IllegalArgumentException.class, () -> g.addEdge(0, 2));
        assertThrows(IllegalArgumentException.class, () -> g.adj(-1));
        assertThrows(IllegalArgumentException.class, () -> g.degree(5));
    }
}
