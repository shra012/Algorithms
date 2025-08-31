package com.shrvn.algo.chapter1.initial;

import edu.princeton.cs.algs4.StdIn;

import java.util.function.BiConsumer;

public class QFRunner {
    public static void main(String[] args) {
        System.out.println("Number of connection components");
        int count = Integer.parseInt(StdIn.readLine());
        QuickFind uf = new QuickFind(count);
        BiConsumer<Integer, Integer> union = (p, q) -> {
            if (uf.connected(p, q)) {
                uf.union(p, q);
            } else {
                System.out.println("Already connected");
            }
        };
        BiConsumer<Integer, Integer> find = (p, q) -> {
            if (uf.connected(p, q)) {
                System.out.printf("%d %d is not connected%n", p, q);
            } else {
                System.out.printf("%d %d is connected%n", p, q);
            }
        };
        System.out.println("Enter values of p and q like 1 2 they should within the connected compound range");
        run(uf, union);
        System.out.println("Enter to check connection");
        run(uf, find);
    }

    static void run(QuickFind uf, BiConsumer<Integer, Integer> fn) {
        while (true) {
            String line = StdIn.readLine();
            String[] values = line.split(" ");
            int p = Integer.parseInt(values[0]);
            int q = Integer.parseInt(values[1]);
            fn.accept(p, q);
            System.out.println("Do you want to continue ? Y/N");
            String decision = StdIn.readLine();
            if (!decision.equalsIgnoreCase("Y")) {
                break;
            }
            System.out.println(uf);
        }
    }


}
