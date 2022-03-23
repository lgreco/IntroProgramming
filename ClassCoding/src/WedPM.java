import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WedPM {

    public static String[] getNames() throws FileNotFoundException {
        File f = new File("students.text");
        Scanner s = new Scanner(f);
        int numberOfNames = s.nextInt();
        String[] names = new String[numberOfNames];
        for (int i = 0; i < numberOfNames; i++) {
            names[i] = s.next();
        }
        return names;
    }


    public static String[] getNamesByCounting() throws FileNotFoundException {
        File f = new File("moreStudents.text");
        Scanner s = new Scanner(f);
        // Part 1: count the contents of the file
        int numberOfNames = 0;
        while (s.hasNext()) {
            s.nextLine();
            numberOfNames++;
        }
        s.close();
        // Part 2: initialize an array for that number of contents
        String names[] = new String[numberOfNames];
        // Part 3: read the contents of the file into the array
        s = new Scanner(f);
        for (int i = 0; i < numberOfNames; i++) {
            names[i] = s.next();
        }
        s.close();
        return names;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String test[] = getNamesByCounting();
        for (int i = 0; i < test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
