
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int number;      //number of guesses
        char answer;     // yes or no
        int guess = 0;   //the guess that the computer comes up with

        System.out.println("This program has you, the user, choose a number between 1 and 10. " +
                "Then I, the computer, will try my best to guess it.");


        //the range of  numbers that the computer can choose from must be between 10 and 1. then when the
        // computer types out it's question, the user has to be able to respond with a y or n

        number = r.nextInt(10);
        guess++;
        System.out.println("Is it " + number + "? (y/n) ");
        answer = s.next().charAt(0);

        //if the user doesn't say yes, the computer asks the question again with a new number
        // if the user answers yes, then the computer tells the number of guesses they've done along with their guess

        if (answer != 'y') {
            number = number + r.nextInt(10 - number);
        } else if (answer == 'y') {

        }
        guess++;
        System.out.println("Is it " + number + "? (y/n) ");
        answer = s.next().charAt(0);

        System.out.println("I got your number of " + number + " correct in " + guess + " guesses.");
    }
}
