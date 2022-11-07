package com.nocli;

import java.awt.*;

public class GettingStarted {
    public static void main(String[] args) {
        /*  Write a program that compares two numbers. Use any comparison operator
            Create 3 variables.
            2 variables to store both numbers and 1 variable store the result
            Print the result
        */

//        int number1 = 3;
//        int number2 = 2;
//        boolean result = number2 <= number1;
//        number1 = 1;
//
//        System.out.println(result);

        /*  Write a program that compares two String contents.
            Create 3 variables.
            2 to store both strings and 1 to store the result
            Print the result
        */

//        String text1 = "NoCli";
//        String text2 = "nocli";
//        boolean result = text1.contains(text2);
//
//        System.out.println(result);
        // Write a program that transform "Amigoscode" to "AMIGOSCODE"
//        String courseCreator = "Amigoscode";
//        String courseCreatorUpper = courseCreator.toUpperCase();
//
//        System.out.println(courseCreatorUpper);

        // Write a program that transform "amigoscode" to "Amigoscode"
//        String courseCreator = "amigoscode";
//
//        String firstChar = courseCreator.substring(0, 1).toUpperCase();
//        String restChar = courseCreator.substring(1, courseCreator.length());
//
//
//        System.out.println(firstChar + restChar);

        /*
            Write a program that compares two numbers. i.e x > y
            Create 3 variables.
            2 to store both numbers and 1 to store the result
            Print the result
        */

        Point pointA = new Point(2, 10);
        Point pointB = new Point(10, 10);
        boolean result = pointA.x > pointA.y;

        System.out.println(result);
    }
}