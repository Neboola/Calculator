package com.luxoft;

import java.util.Random;

/**
 * Created by 2 on 11/23/2015.
 */
public class Task4 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] counter = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int random = (int)(Math.random() * 3);
            switch (random){
                case 0:
                    arr[i] = 3;
                    break;
                case 1:
                    arr[i] = 7;
                    break;
                case 2:
                    arr[i] = 9;
                    break;
            }
        }

        System.out.println();


        for(int j : arr){
            System.out.println(j);
            counter[j]++;
        }

        System.out.println();
        System.out.println(counter[3]);
        System.out.println(counter[7]);
        System.out.println(counter[9]);
    }
}
