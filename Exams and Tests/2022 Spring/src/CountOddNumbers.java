/*
Write a complete Java program that includes a main method and optionally other helper methods that work as
described here. The program reads in all the lines in a file called inputNumbers.txt. Then, computes three values while
reading the file and prints them out when finished: the count of odd numbers in the file, the smallest odd number in the
file, the largest odd number in the file. Your code must work with files of any length. The example file provided is
just that: an example. Your program should work with files that may have more or fewer numbers. You may assume that
the file contains only numbers and that it has at least one number.
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CountOddNumbers {

    /**
     * Main method implements this basic pseudocode:
     * while file not empty:
     *   read the next number from the file
     *   if number is odd:
     *     update count of odd numbers
     *     if number is less than current smallest number, update smallest
     *     if number is more than current largest number, update largest
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("inputNumbers.txt"));
        // Initialize a counter
        int count = 0;
        // Initialize min, max variables
        int small = Integer.MAX_VALUE;
        int large = Integer.MIN_VALUE;
        // Scan the file until we reach its end
        while (file.hasNextInt()) {
            int numberRead = file.nextInt();
            // Is this number odd. Remember that negative odds have a neg. remainder
            if (Math.abs(numberRead % 2) == 1) {
                count++;
                // Update small, large variables
                small = Math.min(small, numberRead);
                large = Math.max(large, numberRead);
            }
        }
        // Report:
        System.out.printf("\nThere are %d odd numbers in the file\n\t" +
                        "The smallest odd number is %d and the\n\t" +
                        "largest odd is %d\n",
                count, small, large);
    }  // method main
}  // class CountOddNumbers
