package com.shrvn.algo.chapter12;

/**
 * A simple interface for a graph.
 * Provides basic graph operations and queries.
 */
public interface Graph {
    /**
     * Returns the number of vertices in the graph.
     * @return the number of vertices
     */
    int V();

    /**
     * Returns the number of edges in the graph.
     * @return the number of edges
     */
    int E();

    /**
     * Adds an undirected edge between vertices v and w.
     * @param v one vertex
     * @param w the other vertex
     */
    void addEdge(int v, int w);

    /**
     * Returns the vertices adjacent to vertex v.
     * @param v the vertex
     * @return an iterable of vertices adjacent to v
     */
    Iterable<Integer> adj(int v);

    /**
     * Returns the degree of vertex v.
     * @param v the vertex
     * @return the degree of vertex v
     */
    int degree(int v);

    /**
     * Returns the maximum degree among all vertices.
     * @return the maximum degree
     */
    int maxDegree();

    /**
     * Returns the average degree of the graph (integer division).
     * @return the average degree
     */
    int averageDegree();

    /**
     * Returns the number of self-loops in the graph.
     * @return the number of self-loops
     */
    int numberOfSelfLoops();

    /**
     * Returns a string representation of the graph.
     * @return a string representation
     */
    String toString();
}
