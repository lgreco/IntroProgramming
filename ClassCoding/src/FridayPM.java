
public class FridayPM {

    public static final char NEG_SIGN = '-';
    public static final char FLOATING_POINT = '.';
    public static final String VALID_NUMERALS = new String("0123456789"+FLOATING_POINT);

    /**
     * Determines if a string can be converted safely into int or double variable
     */
    public static boolean isNumeric(String string) {
        // Guard statement: end method on empty string
        if (string.length() == 0)
            return false;
        // Safe to proceed, start on an optimistic tone
        boolean result = true;
        // Counter for periods -- a number may have 0 or 1
        int countOfDots = 0;
        /*
        Set up a loop to examine the string, one character at a time. The loop ends
        when we find a bad character or when we reach the end of the string. We use
        variable called position to traverse the string
         */
        int position = 0;
        while (result && position < string.length()) {
            // current character
            char currentChar = string.charAt(position);
            // If current character is a dot, update the count.
            if (currentChar == FLOATING_POINT)
                countOfDots++;
            // Set up the conditions we need to observe
            boolean zeroOrOneDots = countOfDots < 2;
            boolean validNumeral = VALID_NUMERALS.indexOf(currentChar) >= 0;
            boolean negativeSign = position == 0 && currentChar == NEG_SIGN;
            // Put these conditions together
            result = zeroOrOneDots && validNumeral || negativeSign;
            // Move to the next position in the string
            position++;
        }
        return result;
    }

    public static void main(String[] args) {

        String convertMe = "123";
        if (isNumeric(convertMe)) {
            int converted = Integer.valueOf(convertMe);
            System.out.println(converted);
        }
    }
}
