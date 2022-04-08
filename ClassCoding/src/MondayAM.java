import java.util.Scanner;

public class MondayAM {

    public static final String PROMPT = "Enter a lower case letter: ";

    public static char maxChar(char a, char b) {
        return (a > b) ? a : b;
    }

    public static char minChar(char a, char b) {
        return (a < b) ? a : b;
    }

    public static char getFromKeyboard(Scanner scanner) {
        System.out.printf("\n%s", PROMPT);
        return scanner.nextLine().charAt(0);
    }

    public static boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    public static void findTwoLargestLetters() {
        // Set up a scanner
        Scanner sc = new Scanner(System.in);
        // Set up two variables to track the two largest letters and obtain initial values
        char largest = sc.next().charAt(0);
        char nextLargest = sc.next().charAt(0);
        // set up a variable for the recurring entries
        char entered = sc.next().charAt(0);
        // Run a loop as long as entered is a lower case letter
        while (entered >= 'a' && entered <= 'z') {
            // Make sure that largest is always > nextLargest
            if (nextLargest > largest) {
                // Otherwise, swap them
                char temporary = largest;
                largest = nextLargest;
                nextLargest = temporary;
            }
            // Is newly entered letter greater than either of large letters?
            if (entered > largest || entered > nextLargest) {
                // replace smallest of the two largest letters with newly entered one
                nextLargest = entered;
            }
            // Get a new character and try again
            entered = sc.next().charAt(0);
        }
        // After loop ends, print the two largest letters
        System.out.printf("The two largest letters are %s and %s", largest, nextLargest);
    }



    public static void main(String[] args) {
        findTwoLargestLetters();
    }
}
