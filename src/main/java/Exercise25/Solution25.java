/*
 *  UCF COP3330 Fall 2021 Assignment 25 Solutions
 *  Copyright 2021 Garrett Adams
 */

package Exercise25;

//Import all java util
import java.util.*;

public class Solution25 {
    //Creates function passwordValidator
    public static void passwordValidator(String UserPassword)
    {
        //Initializes the variables we will be using in the function passwordValidator
        char[] ArrayCheck;
        int InputLength;
        //Stores the length of the password
        InputLength = UserPassword.length();
        //Defines all the special characters
        Set<Character> Specials = new HashSet<>(
                Arrays.asList('%', '^', '#', '*', '!', '@', '(', '$', '&', '+', ')', '-'));
        //Initializes NumberCheck to false
        boolean NumberCheck = false;
        //Initializes LetterCheck to false
        boolean LetterCheck = false;
        //Initializes SpecialCharacterCheck to false
        boolean SpecialCharacterCheck = false;

        //Sets variable ArrayCheck to a character array of the user input
        ArrayCheck = UserPassword.toCharArray();
        //For loop to check for each element of the array
        for (char i : ArrayCheck)
        {
            //If password has a number
            if (Character.isDigit(i))
                NumberCheck = true;
            //If password has a letter
            if (Character.isLetter(i))
                LetterCheck = true;
            //If password has any special characters
            if (Specials.contains(i))
                SpecialCharacterCheck = true;
        }

        //If password has a number, letter, special character, and a length of at least 8
        if (NumberCheck && LetterCheck && SpecialCharacterCheck && (InputLength >= 8))
            System.out.println("The password " + UserPassword + " is a very strong password.");
        //If password has a number, letter, and a length of at least 8
        else if ((LetterCheck && NumberCheck) && (InputLength >= 8))
            System.out.println("The password " + UserPassword + " is a strong password.");
        //If password has a letter and a length of less than 8
        else if(LetterCheck && (InputLength < 8))
            System.out.println("The password " + UserPassword + " is a weak password.");
        //If password has a number and a length of less than 8
        else if(NumberCheck && (InputLength < 8))
            System.out.println("The password " + UserPassword + " is a very weak password.");
        //If none of the conditions are met
        else
            System.out.println("The password " + UserPassword + " is a password of unknown strength.");

    }

    //Main function
    public static void main(String[] args)
    {
        //Initializes the string UserPassword
        String UserPassword;
        //Sets up the scanner
        Scanner ScanWord = new Scanner(System.in);
        //Asks user for input
        System.out.println("Please enter your password ");
        //Scans the users input to UserPassword
        UserPassword=ScanWord.nextLine();
        //Calls the passwordValidator function with the users input as a parameter
        passwordValidator(UserPassword);
    }
}