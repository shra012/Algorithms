package com.shrvn.algo.chapter1.initial;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickUnion {
    private final int count;
    private final int[] items;

    public QuickUnion(int n) {
        count = n;
        items = IntStream.range(0, n).toArray();
    }

    private int root(int i) {
        while(items[i] != i)
            i = items[i];
        return i;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        items[pRoot] = qRoot;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
