/*
Write a complete Java program with a main method and a method called different, to work as follows. main will prompt the
user to enter a String with any two letters between A and Z, inclusive. If the user enters a longer or shorter string
or a string with anything other than the correct letters, main will continue to prompt the user until a correct input is
given.  Call the method different and print out either of these messages from the main method:

"Both your letters are the same" or "Your two letters are different by x positions"

Where x above is the difference between two different letters. The method different must take a String as input and
return an integer value. The return value is true when both letters in the input are different. The return value is 0
when both letters are the same, and between 1 and 25 when the numbers are not the same. Do not print from inside
different. For example

different("NN") shall return 0 and
different("AC") shall return 2

Hint: Strings are made from char primitive values and that char values from A to Z are all consecutive. You may write
additional methods, as you need. Name your class CountDifferent.
 */

import java.util.Scanner;

/**
 * The class implements a solution across three methods. The main method enforces the
 * string length and content requirement. Length is verified in situ, and content is
 * checked by boolean method isLetter. Strings read from the keyboard are converted to
 * lower case to keep comparisons simple.
 */
public class CountTheDifference {

    /** Class constants: they mame magic values disappear! */
    public static final int DESIRED_LENGTH = 2;
    public static final int ASCII_a = 'a';
    public static final int ASCII_z = 'z';
    public static final String POS_SINGULAR = "position";
    public static final String POS_PLURAL = "positions";


    /**
     * Driver code, implements the following simple pseudocode.
     * while input string has not 2 characters and contains non letters:
     *   keep asking for a proper string
     * compute difference between letters
     * report the results
     */
    public static void main(String[] args) {
        // Connect a scanner to the keyboard
        Scanner sc = new Scanner(System.in);
        // Initialize a string to read from the keyboard
        String letters = "";
        // Set up a boolean to control the loop
        boolean conditionsMet = false;
        // Keep asking for a string with two letters until you get one.
        while (!conditionsMet) {
            System.out.printf("\nEnter a string with two letters: ");
            // Convert it to lowercase to keep comparisons simple
            letters = sc.next().toLowerCase();
            conditionsMet = letters.length() == DESIRED_LENGTH &&
                    isLetter(letters.charAt(0)) &&
                    isLetter(letters.charAt(1));
        }
        // Exiting the while loop means that our conditions have been met.
        // Computer the difference between twe two characters
        int diff = difference(letters.charAt(0), letters.charAt(1));
        // Set up a singular/plural form for the report
        String position = (diff > 1) ? POS_PLURAL : POS_SINGULAR;
        // Report
        if (diff == 0)
            System.out.printf("\nBoth your letters are the same\n");
        else
            System.out.printf("\nYour letters differ by %d %s.\n", diff, position);
    }  // method main


    /**
     * Returns a non-negative number showing the difference in positions between two characters.
     * Method will accept any two characters.
     * @param c1 first char
     * @param c2 second char
     * @return difference in numeric codes representing characters
     */
    public static int difference(char c1, char c2) {
        // Math.abs guarantees a non-neg value
        return Math.abs(c1-c2);
    }  // method difference


    /**
     * Returns true if a character is a letter. It expects a lower case character.
     * @param c char to check if it is alphabetical
     * @return true if input is a letter.
     */
    public static boolean isLetter(char c) {
        return c >= ASCII_a && c <= ASCII_z;
    }  // method isLetter

}  // class CountTheDifference