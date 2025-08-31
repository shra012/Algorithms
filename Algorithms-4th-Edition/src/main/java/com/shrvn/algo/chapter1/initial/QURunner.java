package com.shrvn.algo.chapter1.initial;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class QURunner {
    public static void main(String[] args) {

        StdOut.println("Enter the total number of connections");
        int count = Integer.parseInt(StdIn.readLine());
        QuickUnionWeighted uf = new QuickUnionWeighted(count);
        StdOut.println("Connect the pairs");
        while(true){
            String line = StdIn.readLine();
            String[] values = line.split(" ");
            if (values.length < 2) {
                break;
            }
            int p = Integer.parseInt(values[0]);
            int q = Integer.parseInt(values[1]);
            if(!uf.connected(p, q)){
                uf.union(p, q);
            }else{
                StdOut.println("Already connected");
            }
            StdOut.println(uf);
        }
        StdOut.println("Check connection of the pairs");
        while(true){
            String line = StdIn.readLine();
            String[] values = line.split(" ");
            int p = Integer.parseInt(values[0]);
            int q = Integer.parseInt(values[1]);
            if(uf.connected(p, q)){
                StdOut.println("Connected");
            }else{
                StdOut.println("Not connected");
            }
        }
    }
}
