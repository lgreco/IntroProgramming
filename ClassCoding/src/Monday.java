import java.util.Random;

public class Monday {

    /**
     * Computes pi by throwing N points, at random, inside a square and counting how many
     * fall within an inscribed circle.
     *
     * @param N int number of random points to throw inside the square
     * @return an approximate value of pi
     */
    public static double pi(int N) {
        // Set up a random number generator
        Random rng = new Random();
        // Radius of inscribed circle; also determines size of square
        double r = 1.0;
        // Initialize counter of points inside circle
        int M = 0;
        // Set up loop to try N random points
        for (int i = 0; i < N; i++) {
            // Obtain coordinates for random point
            double x = -r + 2.0*r*rng.nextDouble();
            double y = -r + 2.0*r*rng.nextDouble();
            // Distance of random point from center
            double z = Math.sqrt(x*x+y*y);
            // If this point is within circle, update count
            if (z <= r)
                M++;
        }
        return 4.0*((double) M/(double)N);
    }


    public static void main(String[] args) {
        System.out.println(pi(2_000_000_000));
    }
}
