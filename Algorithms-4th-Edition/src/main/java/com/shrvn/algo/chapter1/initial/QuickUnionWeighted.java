package com.shrvn.algo.chapter1.initial;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickUnionWeighted {
    private final int count;
    private final int[] items;
    private final int[] size;

    public QuickUnionWeighted(int n) {
        count = n;
        items = IntStream.range(0, n).toArray();
        size = IntStream.generate(() -> 1).limit(n).toArray();
    }

    private int root(int i) {
        while(items[i] != i) {
            items[i] = items[items[i]];
            i = items[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if(size[pRoot] < size[qRoot]) {
            items[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        } else {
            items[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }

 

    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
