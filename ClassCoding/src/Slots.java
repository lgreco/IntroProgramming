import java.util.Random;

public class Slots {

    public static final int POSITIONS = 5;
    public static final int TEN = 10;
    public static Random rng = new Random();


    public static String slots() {
        StringBuilder game = new StringBuilder();
        int digit = rng.nextInt(TEN);

        for (int i = 0; i < POSITIONS; i++) {
            int left = ((digit - (POSITIONS - i + 1))) % 10;
            int right = ((digit + (POSITIONS - i + 1))) % 10;
            int span = Math.abs(right - left);
            //System.out.printf("\n left=%d, right=%d, range=%d, previous=%d", left, right, span, digit);
            digit = Math.abs((left + rng.nextInt(span))) % 10;
            game.append(digit);
        }
        return game.toString();
    }

    public static void main(String[] args) {
        System.out.println(slots());
    }
}
