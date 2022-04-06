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
    static final int DESIRED_LENGTH = 7;

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
        String inputLine;
        while ((inputLine = in.readLine()) != null)
            if (inputLine.length() == DESIRED_LENGTH && inputLine.charAt(0) >= 'a' && inputLine.charAt(0) <= 'z')
                wordCount++;
        in.close();
        String[] words = new String[wordCount];
        int index = 0;
        in = new BufferedReader(
                new InputStreamReader(url.openStream()));
        while ((inputLine = in.readLine()) != null)
            if (inputLine.length() == DESIRED_LENGTH && inputLine.charAt(0) >= 'a' && inputLine.charAt(0) <= 'z') {
                words[index] = inputLine;
                index++;
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
    }

    static boolean isValid(String myWord, String[] dictionary) {
        boolean found = false;
        int index = 0;
        while (!found && index < dictionary.length) {
            found = myWord.toLowerCase().equals(dictionary[index].toLowerCase());
            index++;
        }
        return found;
    }

    public static void main(String[] args) throws Exception {
        String[] fiveLetters = readWords(LINK);
        boolean valid = false;
        int numberOfAttempts = 0;
        while (!valid) {
            String rw = randomWord(DESIRED_LENGTH);
            valid = isValid(rw, fiveLetters);
            System.out.printf("\nIs the word %s in the dictionary? %s",
                    rw, valid);
            numberOfAttempts++;
        }
        System.out.printf("\nIt took us %d attempts to find a valid word.",
                numberOfAttempts);
    }
}
