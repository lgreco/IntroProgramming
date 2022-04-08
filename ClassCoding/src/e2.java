import java.util.Random;
import java.util.Scanner;

public class e2 {
    public static void main(String[] args) {
        triangular(1.81);
    }

    public static void triangular(double target) {
        double sum = 1.0;
        int n = 1;
        int step = 2;
        System.out.printf("%d", n);
        while (sum < target) {
            n = n+step;
            step++;
            sum += 1.0/((double) n);
            System.out.printf(" + 1/%d", n);
        }
        System.out.printf(" = %f", sum);
    }


    public static void specialSum(double target) {
        double sum = 0;
        int n = 0;
        int one = -1, minusOne = -1;
        System.out.print(n);
        while (sum < target && n < Integer.MAX_VALUE) {
            n++;
            sum = sum + ((double)one)*(1.0/((double) n));
            /*if (one == minusOne)
                System.out.printf(" - 1/%d", n);
            else
                System.out.printf(" + 1/%d", n); */
            System.out.println(sum);

            one *= minusOne;
        }
        if (n == Integer.MAX_VALUE)
            System.out.println("Sum cannot be computed");
        else
            System.out.printf(" = %f", sum);
    }

    public static int prompt(Scanner scanner) {
        final String PROMPT = "\nEnter an non neg integer: ";
        System.out.printf("%s", PROMPT);
        return scanner.nextInt();
    }


    /**
     * Finds two smallest numbers from console input.
     *
     * The method asks for console input until a negative number is entered.
     * Upon entry of a negative number, the method returns the two smallest
     * numbers of those entered up to and NOT including the negative value.
     * We assume that the first two numbers entered are non-negative.
     *
     * In the return array we guarantee that small[0] <= small[1] always.
     *
     * @param scanner Scanner for the console input.
     * @return int array with the two smallest numbers entered.
     */
    public static int[] smallestTwo(Scanner scanner) {
        // Set up array to return.
        int[] small = new int[2];
        // Read first two numbers
        small[0] = prompt(scanner);
        small[1] = prompt(scanner);
        // Reorder as needed to ensure that small[0] <= small[1] always.
        if (small[1] < small[0])
            small = swap(small);
        // Read a number -- if negative, method ends.
        int current = prompt(scanner);
        while (current >= 0) {
            // If current is less than the second smallest number, it takes over it.
            if (current < small[1]) {
                small[1] = current;
                // Reorder as needed to ensure that small[0] <= small[1] always.
                if (small[1] < small[0])
                    small = swap(small);
            }
            // obtain a new value -- if neg. method will end.
            current = prompt(scanner);
        }
        return small;
    }  // method smallestTwo

    public static int[] swap(int a[]) {

            int tmp = a[0];
            a[0] = a[1];
            a[1] = tmp;

        return a;
    }

    public static void fractionSum(double target) {
        double sum = 1.0;  // min. possible value of sum
        int n = 1;  // first term in the sequence
        System.out.print(n);  // print the first term
        while (sum < target) {  // Keep adding until sum exceeds or equals target
            n++;  // move to the next term;
            sum += 1.0/((double) n*n);  // update sum
            //System.out.printf(" + 1/%d", n*n);  // print term
            System.out.println(sum);
        }  // done with while loop
        System.out.printf(" = %f", sum);  // print sum
    }  // method fractionSum


    public static void oddFractionSum(double target) {
        double sum = 1.0;  // min. possible value of sum
        int n = 1;  // first term in the sequence
        System.out.print(n);  // print the first term
        for (n=1; sum < target; n++) {  // Keep adding until sum exceeds or equals target
            sum += 1.0/((double) (2*n+1));  // update sum
            System.out.printf(" + 1/%d", 2*n+1);  // print term
        }  // done with while loop
        System.out.printf(" = %f", sum);  // print sum
    }  // method fractionSum



}