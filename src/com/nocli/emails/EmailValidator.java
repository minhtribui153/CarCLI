package com.nocli.emails;

/*
    Create a package called email and inside create a class called EmailValidator with one public method.
    This method should accept a string and perform some validation checking.
*/
public class EmailValidator {
    public static void main (String[] args) {
        System.out.println(validate(args[0]));
        /*
            Now change the your public method to private and try to run. What happens?
            Do the same but this time change your method to have no access modifier
         */
        // The method will return an error of "has private access in 'com.nocli.emails.EmailValidator'", which means the method is private and cannot be accessed
        // 'validate(java.lang.String)' is only public in com.nocli package, not outside of it since this method is under the com.nocli package

    }
    static boolean validate (String email) {
        /*
            If the email does not contain the @ symbol for instance, return false; if the email is valid return true.
            Call this method from your Main method which should be outside the package you have just created
        */
        String[] regex = email.split("@");
        return regex.length == 2;
    }
}
