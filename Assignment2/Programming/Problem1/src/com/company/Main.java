package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // array of progressively larger test sizes for arrays
        int[] n = {128, 256, 512, 1024, 2048, 4096, 8192};//, 16384};//, 32768};//, 65539};
        // tracks the execution times for above array sizes using version 1
        long[] version1Times = new long[n.length];
        // tracks the execution times for above array sizes using version 1
        long[] version2Times = new long[n.length];

        // for the generation of random integers
        Random rand = new Random();

        // for each array size to test
        for(int i = 0; i < n.length; i++) {

            // make a blank array of the appropriate size
            int[][] a = new int[n[i]][n[i]];
            int[][] b = new int[n[i]][n[i]];
            int[][] c = new int[n[i]][n[i]];

            // fill arrays a abd b with random ints
            for (int j = 0; j < n.length; j++) {
                for (int k = 0; k < n.length; k++) {
                    a[j][k] = rand.nextInt(128);
                    b[j][k] = rand.nextInt(128);
                }
            }

            // save the start time
            long version1StartTime = System.nanoTime();
            // fill array c with version 1
            for (int l = 0; l < n.length; l++) {
                for (int m = 0; m < n.length; m++) {
                    c[l][m] = a[l][m]+b[l][m];
                }
            }
            // save end time
            long version1endTime = System.nanoTime();
            //record duration
            version1Times[i]=version1endTime-version1StartTime;

            // save the start time
            long version2StartTime = System.nanoTime();
            // fill array c with version 1
            for (int p = 0; p < n.length; p++) {
                for (int o = 0; o < n.length; o++) {
                    c[o][p] = a[o][p]+b[o][p];
                }
            }
            // save end time
            long version2endTime = System.nanoTime();
            //record duration
            version2Times[i]=version2endTime-version2StartTime;

            // deallocate the three arrays
            a = null;
            b = null;
            c = null;
        }

        //print the results
        for(int q = 0; q < n.length; q++) {
            System.out.format("Size: %05d | version 1: %05d | version 2: %05d%n",n[q],version1Times[q],version2Times[q]);
        }
    }
}
