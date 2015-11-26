package com.luxoft;

/**
 * Created by 2 on 11/23/2015.
 */
public class Task3 {

    public static void main(String[] args) {
        int j;
        int[] arr = new int[50];
        for (int i = 0; i < 50; ) {
            j = ++i;
            arr[i-1] = j;
            if (i % 3 == 0)
                System.out.println("Число " + j + " кратно 3");
        }
        System.out.println();
        System.out.println(avg(arr));


    }

    private static double avg(int[] arr){
        double d = 0;
        for (int k : arr) {
            //System.out.print(d + "+" + k + "=");
            d += k;
            //System.out.println(d);
        }

        return d / arr.length;
    }
}
