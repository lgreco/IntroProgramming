import java.util.Random;
import java.util.Scanner;

public class e2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();
        boolean found = false;
        int attempts = 0;
        while (!found) {
            System.out.printf("\nIs it %d? ", rng.nextInt(10));
            found = (sc.next().toLowerCase().charAt(0) == 'y');
            attempts++;
        }
        System.out.printf("\nFound after %d attempts.\n", attempts);
    }
}