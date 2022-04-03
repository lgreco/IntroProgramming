import java.util.Scanner;

public class BoringNumbers {

    static int bruteForce(int left, int right) {
        int count = 0;
        for (int n = left; n <= right; n++) {
            if (isBoring(n)) {
                count++;
                //System.out.println(n);
            }
        }
        return count;
    }  // method bruteForce


    static boolean isBoring(int n) {
        boolean odd = true, even = true;
        int digits = (int) Math.log10(n);
        for (int i = 0; i <= digits; i++) {
            int position = i+1;
            int powerOfTen = (int) Math.pow(10.0, digits-i);
            int thisDigit = (n/powerOfTen) % 10;
            boolean positionIsOdd = position%2 == 1;
            if (positionIsOdd && odd)
                odd = thisDigit%2 == 1 ? odd : !odd;
            if (!positionIsOdd && even)
                even = thisDigit%2 == 0 ? even : !even;

        }
        return odd && even;
    }

    public static void main(String[] args) {
        for (int power = 2; power <= 9; power++) {
            int right = (int) Math.pow(10, power);
            long start = System.nanoTime();
            int c = bruteForce(0, right);
            long finish = System.nanoTime();
            long duration = finish-start;
            double seconds = duration/1_000_000_000.00;
            System.out.printf("\n0-%12d has %7d boring numbers found in %15.11f seconds",
                    right, c, seconds);
        }
    }
}
