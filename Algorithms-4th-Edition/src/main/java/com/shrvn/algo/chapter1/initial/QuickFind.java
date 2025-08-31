package com.shrvn.algo.chapter1.initial;

import java.util.Arrays;
import java.util.stream.IntStream;

public class QuickFind {
    private final int count;
    private final int[] items;

    public QuickFind(int n) {
        count = n;
        items = IntStream.range(0, n).toArray();
    }

    public void union(int p, int q) {
        int pVal = items[p];
        int qVal = items[q];
        for (int i =0; i < count; i++){
            if (items[i] == pVal) {
                items[i] = qVal;
            }
        }
    }

    public boolean connected(int p, int q) {
        return items[p] != items[q];
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
