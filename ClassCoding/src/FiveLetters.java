import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class FiveLetters {

    /** Link to file with about 500K english words */
    static final String LINK = "https://raw.githubusercontent.com/dwyl/english-words/master/words.txt";

    /** Desired size of words to read */
    static final int DESIRED_LENGTH = 5;

    /** Number of letters in the alphabet */
    static final int ALPHABET = 26;

    /** ASCII code for lowercase a */
    static final int ASCII_a = (int) 'a';

    /**
     *
     * @param link
     * @return
     * @throws Exception
     */
    public static String[] readWords(String link) throws Exception {
        URL url = new URL(LINK);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(url.openStream()));
        int wordCount = 0;
        String inputLine = in.readLine();
        while (inputLine != null) {
            inputLine = inputLine.toLowerCase();
            if (inputLine.length() == DESIRED_LENGTH && inputLine.charAt(0) >= 'a' && inputLine.charAt(0) <= 'z')
                wordCount++;
            inputLine = in.readLine();
        }
        in.close();

        in = new BufferedReader(
                new InputStreamReader(url.openStream()));
        String[] words = new String[wordCount];
        int index = 0;
        inputLine = in.readLine();
        while (inputLine != null && index < words.length) {
            inputLine = inputLine.toLowerCase();
            if (inputLine.length() == DESIRED_LENGTH && inputLine.charAt(0) >= 'a' && inputLine.charAt(0) <= 'z') {
                words[index] = inputLine;
                index++;
            }
            inputLine = in.readLine();
        }
        in.close();
        return words;
    }  // method readWords

    static String randomWord(int howManyLetters) {
        String word = "";
        Random rng = new Random();
        for (int letter = 0; letter < howManyLetters; letter++) {
            // select a letter a-z at random
            char randomCharacter =  (char) (ASCII_a + rng.nextInt(ALPHABET));
            // add it to string
            word += randomCharacter;
        }
        return word;
    }  // method randomWord

    static boolean isValid(String myWord, String[] dictionary) {
        boolean found = false;
        int index = 0;
        while (!found && index < dictionary.length) {
            found = myWord.toLowerCase().equals(dictionary[index].toLowerCase());
            index++;
        }
        return found;
    }  // method isValid

    public static boolean isValidBinary(String word, String[] dictionary) {
        word = word.toLowerCase();
        int left = 0;
        int right = dictionary.length-1;
        boolean found = false;
        while (!found && left < right) {
            int middle = left+(right-left)/2;
            String middleWord = dictionary[middle];
            System.out.printf("\n Left Middle Right: %d %d %d", left, middle, right);
            if (word.compareTo(middleWord) < 0)
                right = middle-1;
            else if (word.compareTo(middleWord) > 0)
                left = 1+left + (right-left)/2;
            else
                found = true;
        }
        return found;
    }

    public static void main(String[] args) throws Exception {
        String[] fiveLetters = readWords(LINK);
        System.out.println(isValidBinary("hello", fiveLetters));
    }
}
