package com.luxoft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;

/**
 * Created by 2 on 11/20/2015.
 */
public class Calculator {

    private static String[] availableOperations = {"+", "-", "/", "x"};

    public static void main(String[] args) {

        if(args.length < 3){
            System.out.println("число аргументов меньше 3 !");
            return;
        }

        calculation(args[0], args[1], args[2]);

        System.out.println(1.01 / 0);

        {
            System.out.println(1);
        int i = 2_000_000_000;
        System.out.println("int i = 2_000_000_000 : " + i);
        long j = 10_000_000_000L;
        System.out.println("long j = 10_000_000_000L : " + j);
        long k = i++ + ++j;
        System.out.println("long k = i++ + ++j : " + k);
        System.out.println("i : " + i);
        k /= i;
        System.out.println("k /= i : " + k);
        }

        {
            System.out.println(2);
        int mask = 0xFF000000;
        System.out.println("int mask = 0xFF000000 : " + Integer.toHexString(mask));
        int i = mask >> 16;
        System.out.println("int i = mask >> 16 : " + Integer.toHexString(i));
        int j = mask >> 24;
        System.out.println("int j = mask >> 24 : " + Integer.toHexString(j));
        int k = mask >> 33;
        System.out.println("int k = mask >> 33 : " + Integer.toHexString(k));
            System.out.println("сдвиги совершаются не по всей длине, а по части: int на 5, long на 6");
        }

        {
            System.out.println(3);
            int m = ~0;
            System.out.println("int m = ~0 : " + Integer.toBinaryString(m));
            m >>>= 1;
            System.out.println("m >>>= 1 : " + Integer.toBinaryString(m));
            int n = ~m;
            System.out.println("int n = ~m : " + Integer.toBinaryString(n) + " int : " + n);

        }






    }

    public static void calculation(String operand1, String operation, String operand2){
        double o1 = 0, o2 = 0;
        char oper = operation.charAt(0);
        //System.out.println("operand: " + oper);

        if(isInt(operand1) && isInt(operand2)){
            o1 = Double.valueOf(operand1);
            o2 = Double.valueOf(operand2);
        } else {
            System.out.println("операнды – не числа !");
            return;
        }

        if (isAvailableOperation(operation)){

            calculate(o1, oper, o2);

        } else {
            System.out.println("операция не +,-,x,\\ !");
            return;

        }
    }


    private static void calculate(double operand1, char operation, double operand2) {
        switch (operation) {
            case '+':
                System.out.println(operand1 + " + " + operand2 + " = " + (operand1 + operand2));
                break;
            case '-':
                System.out.println(operand1 + " - " + operand2 + " = " + (operand1 - operand2));
                break;
            case 'x':
                System.out.println(operand1 + " * " + operand2 + " = " + (operand1 * operand2));
                break;
            case '/':
                System.out.println(operand1 + " / " + operand2 + " = " + (operand1 / operand2));
                break;
        }

/*
        if(operation == '+'){
            System.out.println(operand1 + " + " + operand2 + " = " + (operand1 + operand2));
         }
        if(operation == '-'){
            System.out.println(operand1 + " - " + operand2 + " = " + (operand1 - operand2));
        }
        if(operation == 'x'){
            System.out.println(operand1 + " x " + operand2 + " = " + (operand1 * operand2));
        }
        if(operation == '/'){
            System.out.println(operand1 + " / " + operand2 + " = " + (operand1 / operand2));
        }
*/
    }

    public static boolean isInt(String str)
    {
        try         {
            double i = Double.parseDouble(str);

        }         catch(NumberFormatException e)         {
            return false;
        }
        return true;
    }

    private static boolean isAvailableOperation(String str){
        String operation;
        for (int i = 0; i < availableOperations.length; i++) {
            operation = availableOperations[i];
            if(operation.equals(str)) { return true; }
        }
        return false;
    }

}
