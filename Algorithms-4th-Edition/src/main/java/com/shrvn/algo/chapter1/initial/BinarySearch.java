package com.shrvn.algo.chapter1.initial;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

import static edu.princeton.cs.algs4.StdOut.println;
//
// java -cp /Users/hiruzen/.gradle/caches/modules-2/files-2.1/edu.princeton.cs/algs4/1.0.4/198e45b1633a5c866fea303fb6c46e2806d1f406/algs4-1.0.4.jar edu.princeton.cs.algs4.RandomSeq 10
public class BinarySearch {
    public static void main(String[] args) {

        if(!StdIn.isEmpty()){
            String s = StdIn.readLine();
            System.out.println(s);
        }
        println(uniform(1,10));

        double a [] = {0.2,0.3,0.5,0.4};
        println(discrete(a));
    }

    public static double uniform(double a, double b){
         return a + StdRandom.uniform() * (b-a);
    }

    public static int discrete(double[] a) {
        // Entries in a[] must sum to 1.
        double r = StdRandom.uniform();
        double sum = 0.0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];
            if (sum >= r) return i;
        }
        return -1;
    }
}
