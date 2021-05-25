package com.shrvn.algo.chapterone;/* *****************************************************************************
 *  Name:              Shravankumar Nagarajan
 *  Project:           Algorithms In Java Journey
 *  Last modified:     May 22 Saturday, 2021
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * 3-4
 * 4-9
 * 8-0
 * 2-3
 * 5-6
 * 2-9
 * 7-3
 * 4-8
 * 5-6
 * 0-2
 * 6-1
 */
public class QuickFind {
    public static void main(String[] args) {
        In in = new In();
        int N = in.readInt();
        int id[] = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
        while (!in.isEmpty()) {
            int p = in.readInt(), q = in.readInt();
            if (id[p] == id[q]) continue;
            for (int i = 0; i < N; i++)
                if (id[i] == id[p]) id[i] = id[q];
            StdOut.println(" " + p + "-" + q);
            StdOut.println(Arrays.toString(id));
        }
    }
}
