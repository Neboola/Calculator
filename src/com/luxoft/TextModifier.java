package com.luxoft;

/**
 * Created by 2 on 11/23/2015.
 */
public class TextModifier {

    public static void main(String[] args) {
        String s = args[0];
        System.out.println("Исходная строка " + s);

        System.out.println("Конечная строка " + edit(s));


    }

    private static String edit(String s){
        char[] cArr = s.toCharArray();
        StringBuffer sb = new StringBuffer();

        for(char c : cArr){
            //System.out.println(c);
            if (!Character.isDigit(c)) {
                sb.append(c);
            }
            if (c == '+' || c == '-') {
                sb.append(c);

            }
            // DELETED 0
        }

/*
        DELETED 1
*/


        return sb.toString();
/*
        DELETED 2
*/
    }

}
