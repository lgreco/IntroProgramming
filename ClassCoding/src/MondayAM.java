import java.util.Scanner;

public class MondayAM {

    /*
    Write a program that asks users to type letters (one letter at a
    time) and ends when the user types a number. When the user types
    a number, the program reports the two "largest" letters. Size is
    defined by the position of the letter in the alphabet. We assume
    that only lower case letters are entered. Smallest letter is 'a'
    and largest letter  is  'z'.  Your code  must have  at least two
    methods (including main).
     */

    public static void main(String[] args) {
        largestOfTwoLetters();
    }

    /*
    PSEUDOCODE
    largest <-- given by user
    next_largest <-- also given by user
    input <-- next item given by user
    while (input is NOT a number) {
      ensure that largest > next_largest
      find a way to replace largest or next_largest with input received just now, if that letter
        is greater than both largest and next_largest.
        - how to tell if input is greater than largest and next_largest?
          if input > max(largest, next_largest):
             now we know that one of these two numbers needs to be replaced
             next_largest <-- input
    }
    // report two largest letters


    TOOLS WE NEED:
    Scanner

     */

    public static boolean isNumber(String string) {
        char c = string.charAt(0);
        boolean result = c >= '0' && c <= '9';
        System.out.println(result);
        return result;
    }

    public static void largestOfTwoLetters() {
        Scanner s = new Scanner(System.in);
        String largest, next_largest, inputLetter;
        char large='a', next_large='a', input;
        // obtain initial letters expecting that the first two inputs are legit letters
        largest = s.next();
        next_largest = s.next();
        inputLetter = s.next();
        while (!isNumber(inputLetter)) {  // Telling if single letter string is not a number?
            // Convert inputs to chars
            large = largest.charAt(0);
            next_large = next_largest.charAt(0);
            // Ensure proper order between large and next_large
            if (next_large > large) {
                char temp = large;
                large = next_large;
                next_large = temp;
            }
            input = inputLetter.charAt(0);
            if (input > Math.max(large, next_large))
                next_large = input;
            inputLetter = s.next();
        }
        System.out.printf("%s %s", large, next_large);
    }
}
