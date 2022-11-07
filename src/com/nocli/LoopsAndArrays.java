package com.nocli;

import java.util.Arrays;

public class LoopsAndArrays {
    public static void main(String[] args) {
        /*
            Question 1:
            Declare an empty integer array of length = 3
            Print the contents to the console
         */
//        int[] numbers = new int[3];
//        System.out.println(Arrays.toString(numbers));

        /*
            Question 2:
            Fill it with the number `4`
            Print the array to the console
         */
//        Arrays.fill(numbers, 4);
//        System.out.println(Arrays.toString(numbers));


        /*
            Question 3:
            Declare an empty integer array of length = 3
            Fill it with the number `4`
            Reassign the second value in the array to the number `17`
            Print the array to the console
         */
//        int[] numbers2 = new int[3];
//        Arrays.fill(numbers2, 4);
//        numbers2[1] = 17;
//        System.out.println(Arrays.toString(numbers2));

        /*
            Question 4:
            What happens when you try to re-assign index 5 to any integer?
            Ans: An error "Array index out of bounds" will occur
         */
//        int[] numbers = {1, 2, 3, 4, 5};
//        numbers[0] = numbers[5];

        /*
            Question 5:
            Declare and initialize a String array which holds the values "a", "b", "c" and "d"
            Print the array to the console
         */
//        String[] alphabets = {"a", "b", "c", "d"};
//        System.out.println(Arrays.toString(alphabets));

        /*
            Using your answer to question above, create a second array which is initialized using your original array
            Hint: instead of using the `new` keyword, try simply giving the name of your original array
            Change the value at index 0 of the new array to "z"
            Print both of your arrays and compare
         */

        // Pass by Reference
//        String[] alphabets2 = alphabets;
//
//        alphabets2[0] = "z";
//
//        System.out.println(Arrays.toString(alphabets));
//        System.out.println(Arrays.toString(alphabets2));

        // Why is this output maybe not what you were expecting?
        // Ans: The arrays are being passed by reference instead of being passed by value

        // TODO refer to declare and initialize a String array which holds the values "a", "b", "c" and "d"
//        String[] alphabets3 = {"a", "b", "c", "d"};

        // using your answer to Q5, create another array which is A COPY off of your original array (using the `Arrays.copyOf()` method)
        // NOTE that the `.copyOf()` method accepts two arguments, first being the array that's being copied and second being the length of the new array
        // change the value at index 0 of the new array to "z"
        // print both of the arrays and compare

        // Pass by Value
//        String[] alphabets4 = Arrays.copyOf(alphabets3, alphabets3.length);
//
//        alphabets4[0] = "z";
//
//        System.out.println(Arrays.toString(alphabets3));
//        System.out.println(Arrays.toString(alphabets4));

        // using your array from Q5, create a `for` loop which prints each item in the array
//        for (String alphabet : alphabets) {
//            System.out.println(alphabet);
//        }

        // create a for loop which goes from 0 to 10
        // print each value
//        for (int i = 0; i <= 10; i++) {
//            System.out.println(i);
//        }

        // create a for loop which goes from 10 down to 0
        // print each value
//        for (int i = 10; i >= 0 ; i--) {
//            System.out.println(i);
//        }

        // create a for loop which goes from 0 to 20
        // print each even value
//        for (int i = 0; i <= 20; i++) {
//            if (i % 2 == 0) {
//                System.out.println(i);
//            }
//        }

        // create an array. Remember to manually set the size
        // create a for loop which goes from 0 to 10, adding each value to an array
        // print our array

//        int[] numbers = new int[10];
//
//        for (int i = 0; i < 10; i++) {
//            numbers[i] = i;
//        }
//
//        System.out.println(Arrays.toString(numbers));

        // create an array of n numbers
        // create a sum variable
        // create a loop
        // add each item to the sum value
        // outside the loop print the total sum

//        int[] numbers = {10, 10, 34, 83, 100};
//        int sum = 0;
//        boolean running = true;
//
//        for (int number : numbers) {
//            sum += number;
//        }
//
//        System.out.println(sum);


        // create a variable
        // create a for loop which goes through each string in our array
        // make each word uppercase
        // assign the value in the array to the uppercase string
        // print our resulting array
//        String[] array = {"i", "sure", "do", "love", "bees"};
//
//        for (int i = 0; i < array.length; i++) {
//            array[i] = array[i].toUpperCase();
//        }
//
//        System.out.println(Arrays.toString(array));


        // create a for loop which goes through each string in our array
        // grab the first letter of our word
        // capitalise the first letter
        // add the capitalised letter to the rest of the provided word
        // assign the value to an array
        // print our resulting array
//        String[] words = {"i", "sure", "do", "love", "bees"};
//        String[] capitalizedWords = capitalizeArrayString(words);
//
//        System.out.println(Arrays.toString(capitalizedWords));

        // create a for loop which goes through number in our array
        // check whether the value is greater than the current greatest value
        // reassign the current greatest value if true
        // print the greatest value
//        int[] numbers = {1, 6, 17, 30, 9, 20, 5};
//        int maxNumber = getMaxNumber(numbers);
//        System.out.println(maxNumber);


        /*
            Write a program that reverses an array of Strings
            String[] content = {"you", "are", "how", "hello"}
            Tip. Use for loop and you to start at highest index.
            Output should be: hello how are you?. Note question mark at the end
        */
//        String[] content = {"feeling", "you", "are", "how", "hello"};
//        String[] reversedContent = reverseString(content);
//
//        System.out.println(Arrays.toString(reversedContent));

        /*
            Write a program that adds total amount for this string "0.90, 1.00, 9.00, 8.78, 0.01".

            Tip:
            - String input = "0.90, 1.00, 9.00, 8.78, 0.01";
            - create variable to store result. double result = 0;
            - convert string to array.
            - then loop.
            - convert each string to decimal and add to current result
        */

//        String sumOfNumbersString = "0.90, 1.00, 9.00, 8.78, 0.01";
//
//        double result = getSumNumbers(sumOfNumbersString, ", ");
//
//        System.out.println(result);

        /*
            Write a program that takes arguments from the program args and loops through args and prints each item in args
            Compile using: javac and run using: java
            i.e. javac Exercise5.java | java Exercise5 foo bar baz
        */

//        for (String arg : args) {
//            System.out.println(arg);
//        }
    }

    public static String[] capitalizeArrayString(String[] array) {
        String[] capitalizedArray = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            String firstLetter = array[i].substring(0, 1);
            String restOfTheWord = array[i].substring(1, array[i].length());

            String firstLetterCapitalized = firstLetter.toUpperCase();
            capitalizedArray[i] = firstLetterCapitalized + restOfTheWord;
        }

        return capitalizedArray;
    }

    public static int getMaxNumber(int[] array) {
        int maxNum = 0;

        for (int num : array) {
            if (num > maxNum) maxNum = num;
        }

        return maxNum;
    }

    public static String[] reverseString(String[] array) {
        String[] reversedContent = new String[array.length];

        for (int i = 0; i < array.length; i++) {
            reversedContent[(array.length - 1) + 1 * -i] = array[i];
        }

        return reversedContent;
    }

    public static double getSumNumbers(String numbersInString, String splitRegex) {
        String[] resultInArray = numbersInString.split(splitRegex);

        double result = 0;

        for (String num : resultInArray) {
            double number = Double.parseDouble(num);
            result += number;
        }

        return result;
    }
}
