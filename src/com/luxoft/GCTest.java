package com.luxoft;

/**
 * Created by 2 on 11/23/2015.
 */
public class GCTest {

    static int iter;
    static int i = 100000000;
    //static String s = " ";


    public static void main(String[] args) {

        GCTest[] arr = new GCTest[i];

        for (iter = 0; iter < i; iter++) {

            GCTest gCTest = new GCTest();
            arr[iter] = gCTest;
            //s = s + s;
            // 1768684 100m
            // 3689612 200m
            // VM options -Xmx1000m : OutOfMemoryError



        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(iter);

    }
}
