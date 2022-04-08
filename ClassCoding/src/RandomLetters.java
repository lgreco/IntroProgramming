import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

public class RandomLetters {

    public static final int ASCII_a = (int) 'a';
    public static final int ALPHABET = 26;

    public static final String DICTIONARY_LINK = "https://raw.githubusercontent.com/dwyl/english-words/master/words.txt";

    public static String[] dictionary;

    // Create a word with a specified number of random,
    // lower case letters.
    // JaQuan decided size of word -- how many letters
    // pull as many Scrabble tiles from a bag and put them next to each other
    // and there is your word!
    public static String createRandomWord(int wordSize) {
        String result = "";
        Random rng = new Random();
        for (int i = 0; i < wordSize; i++) {
            char randomLetter = (char) (ASCII_a + rng.nextInt(ALPHABET));
            result = result + randomLetter;
        }
        return result;
    }  // method createRandomWord

    public static int countWords(int wordSize, String link) throws IOException {
        int counter = 0;
        // Go to the URL specified by link here
        URL url = new URL(link);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine = in.readLine();
        while (inputLine != null) {
            inputLine = inputLine.toLowerCase();
            if (inputLine.length() == wordSize && inputLine.charAt(0) >= 'a' && inputLine.charAt(0) <= 'z')
                counter++;
            inputLine = in.readLine();
        }
        return counter;
    }  // method countWords

    public static void createDictionary(int numberOfWords, String link, int wordSize) throws IOException {
        dictionary = new String[numberOfWords];
        URL url = new URL(link);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine = in.readLine();
        int index = 0;
        while (inputLine != null) {
            inputLine.toLowerCase();
            if (inputLine.length() == wordSize && inputLine.charAt(0) >= 'a' && inputLine.charAt(0) <= 'z') {
                dictionary[index] = inputLine;
                index++;
            }
            inputLine = in.readLine();
        }
    }


    public static boolean isWordValid(String word) {
        boolean found = false;
        int index = 0;
        while (!found && index < dictionary.length) {
            found = word.equals(dictionary[index]);
            index++;
        }
        return found;
    }


    public static void main(String[] args) throws IOException {
        String testWord = "hello";
        int desired_size = testWord.length();
        int numberOfThoseWords = countWords(desired_size, DICTIONARY_LINK);
        createDictionary(numberOfThoseWords,DICTIONARY_LINK,desired_size);
        System.out.println(isWordValid(testWord));
    }
}
