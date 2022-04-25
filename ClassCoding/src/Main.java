import java.util.Scanner;

//Main.java
public class Main {
    //Method being used
    public static void triangularSum() {
        //inputs of double number
        //variables
        double num = -1;
        Scanner scan = new Scanner(System.in);
        while (!(num >= 1 && num <= 2)) {
            //First number 1.5 between 1-2
            System.out.print("Enter a double number 1-2: ");
            num = scan.nextDouble();
            //incorrect input when num>1 and num <=2

            if (num == 0) {
                System.exit(1);
            } else if (!(num >= 1 && num <= 2)) {
                //anything under 1 and anything over 2 will be an incorrect output
                //example would be like 3 or 5 or 10 or 100 or 0.5
                System.out.println("Incorrect input.");
            }

        }
        //denmoniator would be 1
        double res = 0;
        //res would be 0
        int denominator = 1;
        //counter has to be 2

        int counter = 2;
        while (res <= num) {
            res += 1 / (double) denominator;
            if (denominator != 1) {
                System.out.print("1/" + denominator);
            } else {
                System.out.print("1");
            }
            //anything under the demominator and anything over the counter would be inccorect
            denominator += counter;
            counter++;

            if (res >= num) {
                break;
            } else {
                System.out.print(" + ");
            }

        }
        //plug in of method Math.pow
        double scale = Math.pow(10, 6);
        System.out.println(" = " + (Math.round(res * scale) / scale) + "\n");

    }

    // Entry point of program method
    public static void main(String[] args) {

        while (true) {
            triangularSum();
            //output should be between numbers 1-2
        }
    }

}
