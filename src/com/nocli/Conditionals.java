package com.nocli;

public class Conditionals {
    public static void main(String[] args) {
        // Question 1

        // create an integer variable
//        int number = 11;
        // create a second integer variable
//        int number2 = 11;
        // create an `if` statement which compares the two variables and prints to the console if they are equal

//        if (number == number2) {
//            System.out.println("The numbers are equal!");
//        } else {
//            System.out.println("The numbers are NOT equal!");
//        }

        // Question 2

        // create a string variable
//        String text = "Hello World 123";
        // create a second string variable which has the same value as the first
//        String text2 = "Hello World";
        // create an `if` statement which compares the two variables and prints to the console if they are equal
//        if (text == text2) {
//            System.out.println("The two strings are equal!");
//        } else {
//            System.out.println("The two strings are NOT equal!");
//        }

        // Question 3

        // create a string variable using the `new` keyword
//        String stringVar = new String("Testing 1213");
        // create a second string variable which has the same value as the first, again using the `new` keyword
//        String stringVar2 = new String("Testing 1213");
        // create an `if` statement which compares the two variables and prints to the console if they are equal
//        if (stringVar.equals(stringVar2)) {
//            System.out.println("The two strings are equal!");
//        } else {
//            System.out.println("The two strings are NOT equal!");
//        }

        // Question 4

        // create two `int` variables. Assign them values
//        int number3 = 30;
//        int number4 = 20;
        // create an `if` statement which compares whether one value is greater than the other
//        if (number4 > number3) {
//            // print something to the console if the condition is met
//            System.out.println("Condition met!");
//        } else {
//            // create an `else` statement which prints to the console if the above condition is NOT met
//            System.out.println("Nope no no no!!!!");
//        }

        // Question 5

        // Question 6: Modify your answer to Question 5 to instead use an OR (||) operator. Play about with the values assigned to your three variables, noting how the behaviour changes.

        // create three `int` variables. Assign them values with the first value sitting between the other two
//        int frontNumber = 0;
//        int middleNumber = 15; // da first value
//        int backNumber = 20;
        // create an `if` statement which compares whether the first value is greater than the second AND less than the third

        // && = maybe true, maybe not
        // || = always true cause of this
//        if (middleNumber > frontNumber || middleNumber < backNumber) {
//            // print something to the console if the condition is met
//            System.out.println("Condition met!");
//        } else {
//            // create an `else` statement which prints to the console if the above condition is NOT met
//            System.out.println("Ayo WTF dude");
//        }

        // Question 7

        // create a String variable and assign it a value
        String string = "Fredrick";
        // create a `for` loop which wraps around your answer from Question 7
        for (int i = 0; i < string.length(); i++) {
            // modify your `if` statement to check the character at each index
            // Hint: use your internal, incrementing value of your `for` loop within the `.charAt()` method
            if (string.charAt(i) == 'F') {
                // print something to the console if the condition is met
                System.out.println("Condition met at character " + i);
            }
        }


    }
}
