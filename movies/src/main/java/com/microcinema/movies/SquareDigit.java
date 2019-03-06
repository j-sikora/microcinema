package com.microcinema.movies;

import org.apache.commons.math.stat.descriptive.summary.Sum;

import java.util.HashMap;
import java.util.Map;

public class SquareDigit {

    public static int squareDigits(int n) {
        String text = String.valueOf(n);
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(text);
        for (int i = 0; i < text.length(); i++) {
            int digit = Character.getNumericValue(text.charAt(i));
            System.out.println(digit);
            stringBuilder.append(digit * digit);
        }
        return Integer.parseInt(stringBuilder.toString());
    }

//    public static void main(String[] args) {
//        System.out.println(SquareDigit.squareDigits(3));
//    }

    public static String Tickets(int[] peopleInLine)
    {
        Integer count25 = 0;
        Integer count50 = 0;
        for (int cash: peopleInLine) {
            switch (cash) {
                case 25:
                    count25++;
                    break;
                case 50:
                    if(count25 <= 0) {
                        return "NO";
                    }
                    count25--;
                    count50++;
                    break;
                case 100:
                    if(count50 >= 1 && count25 >= 1) {
                        count50--;
                        count25--;
                    }
                    else if(count25 >= 3) {
                        count25 = count25 - 3;
                    }
                    else {
                        return "NO";
                    }
            }
        }
        return "YES";
    }


    public static int GetSum(int a, int b)
    {
        int start;
        int end;
        if(a < b) {
            start = a;
            end = b;
        }
        else {
            start = b;
            end = a;
        }
        int result = 0;
        System.out.println(start);
        System.out.println(end);
        for (int i = start; i < end; i++) {
            System.out.println("i="+i);
            result += i;
        }
        return result;
    }

    public static String accum(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringBuilder.append(String.valueOf(c).toUpperCase());
            for (int j = 0; j < i; j++) {
                stringBuilder.append(String.valueOf(c).toLowerCase());
            }
            if(i < s.length() - 1) {
                stringBuilder.append("-");
            }
        }
        return stringBuilder.toString();
    }

    public static String whoLikesIt(String... names) {
        StringBuilder stringBuilder = new StringBuilder();
        if(names.length == 0) {
            return ("no one likes this");
        }

        for (int i = 0; i < names.length; i++) {
            stringBuilder.append(names[i]);
            if(i > 3) {
                break;
            }
            stringBuilder.append(", ");
        }
        if(names.length == 1) {
            return stringBuilder.append(" likes it").toString();
        }
        else if(names.length > 3) {
            return stringBuilder.append(" and ").append(names.length - 3).append(" others like it").toString();
        }
        else {
            return stringBuilder.append(" like it").toString();
        }
    }

    public static void main(String[] args) {
//        System.out.println(GetSum(0, -1));
        System.out.println(accum("ZpglnRxqenU"));
    }

}