package com.nocli;

import java.util.ArrayList;

public class ArrayConditionalsAndMethods {
    public static void main(String[] args) {
        // Exercise 1

        /*
            Write a method that reverses any String and print to console
            Input should be a string
            Output should be reversed input
        */
//        String variable = "yradnoceS noognareS";

        // 0; -1 | 1
        // 1; -2 | 2
        // 2; -3 | 3

//        String[] reversedChars = new String[variable.length()];
//        for (int i = 0; i < variable.length(); i++) {
//            reversedChars[i] = Character.toString(variable.charAt(variable.length() - (i + 1)));
//        }
//        String reversedVariable = String.join("", reversedChars);
//        System.out.println(reversedVariable);

        /*
            Given the following String input
            String input = "   amig os cod e  "
            Write a program that transforms input into: Amigoscode
        */

//        String input = "   amig os cod e  ".replace(" ", "");
//        String[] inputArray = new String[input.length()];

//        for (int i = 0; i < input.length(); i++) {
//            inputArray[i] = Character.toString(i);
//        }
//        inputArray[0] = inputArray[0].toUpperCase();
//
//
//        System.out.println(input);

        /*
            Create a package called email
            Then have a method called validateEmail that return true of false if input is valid email
            Finally invoke validateEmail in main
                i.e. "hello@gmail.com" -> true
                i.e. "hellogmail.com" -> false
        */

//        boolean value = Emails.validate("tribui141108@gmail.com");
//
//        System.out.println(value);

        /*
            Write a method that finds the longest string in any given array.
            i.e. [] -> ""
            i.e. ["hello", "ola", "bye", "ciao"] -> hello
            i.e. ["hello", "hello", "ola", "bye", "ciao"] -> hello
            i.e. ["hello", "bingo", "ola", "bye", "ciao"] -> hello, bingo
        */

        String[] stringValues = {"Minh Tri", "Fredrick See", "Tristan Yew", "Ong Kang Xunvx", "Izzul Mohammad"};

        int longestValue = 0;
        for (String stringValue : stringValues) {
            if (longestValue < stringValue.length()) longestValue = stringValue.length();
        }

        ArrayList<String> highestStringValues = new ArrayList<>();
        for (String stringValue: stringValues) {
            if (stringValue.length() == longestValue) {
                highestStringValues.add(stringValue);
            }
        }

        System.out.println(highestStringValues.toString().replace("[", "").replace("]", ""));
    }
}
