package com.shrvn.algo.chapter12;

import edu.princeton.cs.algs4.In;

import java.util.*;
import java.util.stream.IntStream;

/**
 * This class represents an undirected graph using an adjacency list representation.
 */
public class UndirectedGraph {
    private final List<List<Integer>> adj;
    private final int V;
    private int E;

    /**
     * Initializes an empty undirected graph with V vertices.
     *
     * @param V number of vertices
     * @throws IllegalArgumentException if V is negative
     */
    public UndirectedGraph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertex must be non-negative");
        this.V = V;
        this.E = 0;
        adj = new ArrayList<>(V);
        for (int v = 0; v < V; v++) {
            adj.add(new ArrayList<>());
        }
    }

    /**
     * Initializes a graph from input stream.
     *
     * @param in input stream
     * @throws IllegalArgumentException if input is invalid
     */
    public UndirectedGraph(In in) {
        Objects.requireNonNull(in, "Input stream cannot be null");
        try {
            this.V = in.readInt();
            if (V < 0) throw new IllegalArgumentException("Number of vertex must be non-negative");
            adj = new ArrayList<>(V);
            for (int v = 0; v < V; v++) {
                adj.add(new ArrayList<>());
            }
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("Number of edges must be non-negative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w);
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("Invalid input format", e);
        }
    }

    /**
     * Returns the number of vertices in the graph.
     *
     * @return number of vertices
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in the graph.
     *
     * @return number of edges
     */
    public int E() {
        return E;
    }

    /**
     * Adds an undirected edge between v and w.
     *
     * @param v one vertex
     * @param w the other vertex
     * @throws IllegalArgumentException if vertex is invalid
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj.get(v).add(w);
        adj.get(w).add(v);
        E++;
    }

    /**
     * Returns the vertices adjacent to vertex v.
     *
     * @param v the vertex
     * @return iterable of adjacent vertices
     * @throws IllegalArgumentException if vertex is invalid
     */
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return Collections.unmodifiableList(adj.get(v));
    }

    /**
     * Validates that v is a valid vertex.
     *
     * @param v the vertex
     * @throws IllegalArgumentException if vertex is invalid
     */
    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
        }
    }

    /**
     * Returns the degree of vertex v.
     *
     * @param v the vertex
     * @return degree of v
     * @throws IllegalArgumentException if vertex is invalid
     */
    public int degree(int v) {
        validateVertex(v);
        return adj.get(v).size();
    }

    /**
     * Returns the maximum degree among all vertices.
     *
     * @return maximum degree
     */
    public int maxDegree() {
        return V == 0 ? 0 : IntStream.range(0, V)
                .map(v -> adj.get(v).size())
                .max()
                .orElse(0);
    }

    public int averageDegree() {
        return 2 * E / V;
    }

    public int numberOfSelfLoops() {
        int matches = 0;
        for (int v = 0; v < V; v++) {
            for (int w : adj.get(v)) {
                if (w == v) {
                    matches++;
                }
            }
        }
        return matches / 2;
    }


    public String toString() {
        StringBuilder s = new StringBuilder(V + " vertices, " + E + " edges\n");
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : this.adj(v))
                s.append(w).append(" ");
            s.append("\n");
        }
        return s.toString();
    }
}
