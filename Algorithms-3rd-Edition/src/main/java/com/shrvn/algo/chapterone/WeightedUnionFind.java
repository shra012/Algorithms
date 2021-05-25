package com.shrvn.algo.chapterone;/* *****************************************************************************
 *  Name:              Shravankumar Nagarajan
 *  Project:           Algorithms In Java Journey
 *  Last modified:     May 24 Monday, 2021
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class WeightedUnionFind {
    public static void main(String[] args) {
        In in = new In();
        int N = in.readInt();
        int id[] = new int[N], sz[] = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
        while (!in.isEmpty()) {
            int i, j, p = in.readInt(), q = in.readInt();
            for (i = p; i != id[i]; i = id[i]) ;
            for (j = q; j != id[j]; j = id[j]) ;
            if (i == j) continue;
            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];
            }
            else {
                id[j] = i;
                sz[i] += sz[j];
            }
            StdOut.println(" " + p + "-" + q);
            StdOut.println(Arrays.toString(id));
            StdOut.println(Arrays.toString(sz));
        }
    }
}
