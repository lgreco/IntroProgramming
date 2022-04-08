import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oops6 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("example.txt");
        Scanner in = new Scanner(file);
        countWords(in);
    }

    // Counts total lines and words in the input scanner.
    public static void countWords(Scanner input) {
        //Scanner input = new Scanner("example.txt");
        int lineCount = 0;
        int wordCount = 0;

        while (input.hasNextLine()) {
            String line = input.nextLine();   // read one line
            lineCount++;
            Scanner lineScan = new Scanner(line);
            while (lineScan.hasNext()) {         // tokens in line
                String word = lineScan.next();
                wordCount++;
            }
        }

        System.out.println("Lines: " + lineCount);
        System.out.println("Words: " + wordCount);
    }

}