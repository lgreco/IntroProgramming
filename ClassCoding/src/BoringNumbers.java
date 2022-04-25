/**
 * An attempted recursive solution to the boring numbers problem
 */

public class BoringNumbers {

    /**
     * Driver method
     * @param args
     */
    public static void main(String[] args) {
        int startingNumber = 123456781; // should be the lower of the 2 values
        int endingNumber = 123456783;   // should be the higher of the 2 values
        endingNumber += 1;              // to make the range inclusive
        // check number of boring less than ending
        int lessThanEnding = boringLessThan(endingNumber, endingNumber, true);
        System.out.println("boring less than ending = " + lessThanEnding + "\n\n");
        // check number of boring less than starting
        int lessThanStarting = boringLessThan(startingNumber, startingNumber, true);
        System.out.println("boring less than starting = " +lessThanStarting + "\n\n");
        // calculate the number of boring in the range
        int boring = lessThanEnding - lessThanStarting;
        System.out.println("# boring = " + boring);
    }

    /**
     * A method to find the number of boring numbers strictly less than the number passed as a param
     * Its functionality is (maybe) best described by examples:
     *      If number = 347:
     *      boringLessThan analyzes the number as 300 on the 1st recursion
     *                                             40 on the 2nd recursion
     *                                              7 on the 3rd recursion
     *                      always relying on d1odd to know HOW to count the boring numbers less than the input
     *
     *      If number = 357:
     *      boringLessThan analyzes the number as 300 on the 1st recursion
     *                                             50 on the 2nd recursion
     *                                             Then stops because there are no boring numbers in the range 350-357
     *                      again relying on d1odd to know HOW to count the boring numbers less than the input
     *
     * @param number The number we want to find the number of boring numbers less than.
     * @param d1odd (for recursion logic):
     *                      The first time the method is called from main, this is always true by definition.
     *                      However on subsequent recursive calls, we need this value to alternate to reflect the
     *                          position of the leading digit of the new number we are passing it in the original
     *                          number.
     * @param prevNumber Number previously recursed on.
     *                      This is important for knowing if the last digit should be analyzed
     * @return
     */
    public static int boringLessThan(int number, int prevNumber, boolean d1odd){
        int boring = 0; // stores # boring generated on each run of the method
        int digits = (int) Math.floor(Math.log10(number)) + 1; // # of digits in number
        if (digits < 0) // don't allow negative number of digits
            digits = 0;
        // sanity check on where we are
        System.out.println("number = " + number);
        System.out.println("digits = " + digits);

        // counts how many boring numbers are less than the number rounded to the highest tens place value
        // (so it only works on numbers with more than one digit)
        if (digits > 1) {
            int firstDigit = number / (int) Math.pow(10, digits - 1); // strip off the first digit of the number
            boolean d1actualOdd = (number / (int) Math.pow(10, digits - 1) % 2 != 0);
            if (d1odd) {
                // the number of boring numbers less than (n * 10^x) is (m * 5^x)
                // where m is one more than the number of odd digits less than n
                // and we add 1 since we have to include the case of one digit odds
                boring += ((oddLessThan(firstDigit) + 1) * (int) Math.pow(5, digits - 1));
            } else { // d1even
                // the number of boring numbers less than (a * 10^x) is (b * 5^x)
                // where b is the number of even digits less than a
                boring += (evenLessThan(firstDigit) * (int) Math.pow(5, digits - 1));
            }
            System.out.println("First boring = " + boring);

            // condition for continuing the recursion:
            // if we ever find that the first digit has the wrong parity
            //     (i.e. in 247, 2 is in an odd position, but has even parity)
            // we no longer need to continue the recursion
            //     (since, continuing the example, there will be no boring numbers in the range 200-247)
            if (d1odd == d1actualOdd) { // actual value at digit has the same parity as the position
                int newNumber = number % (int) Math.pow(10, digits - 1);
                boring += boringLessThan(newNumber, number, !d1odd);
            }
        } else if (d1odd == (prevNumber / (int) Math.pow(10, digits) % 2 == 0)) { // handles last digit (one's place)
            // if the prevNumber had the right parity of the first digit, then we need to count the
            // number of boring numbers up to the ones place
            if (d1odd) {
                boring += oddLessThan(number);
            } else {
                boring += evenLessThan(number);
            }
        }
        return boring;
    }

    public static int evenLessThan(int num){
        return (int) Math.ceil(num/2.0);
    }

    public static int oddLessThan(int num){
        return (num/2);
    }

}
