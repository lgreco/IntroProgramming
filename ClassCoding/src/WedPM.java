import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WedPM {

    public static String[] getNames() throws FileNotFoundException {
        File f = new File("students.text");
        Scanner s = new Scanner(f);
        String[] names = new String[s.nextInt()];
        for (int i = 0; i < names.length; i++) {
            names[i] = s.next();
        }
        return names;
    }


    /**
     * Returns records from file in a string array.
     *
     * Method assumes that there is one record per line.
     *
     * If file not found or empty, the returned array has 0 length.
     *
     * @param f File pointer to data source
     * @return String array with contents of f;
     *         if f does not exist or is empty, array is also empty.
     */
    public static String[] getRecordsByCounting(File f) {
        // This is the array that we'll return
        String[] records;
        try {
            // To establish a scanner connection to the passed File f.
            Scanner s = new Scanner(f);
            // Counter for number of records in the file.
            int numberOfRecords = 0;
            // Go through the file counting the number of lines.
            while (s.hasNextLine()) {
                numberOfRecords++;
                s.nextLine();
            }
            s.close();
            // Initialize return array with number of records found
            records = new String[numberOfRecords];
            // Re-establish scanner
            s = new Scanner(f);
            // Read records into array
            for (int i = 0; i < numberOfRecords; i++) {
                records[i] = s.nextLine();
            }
            s.close();
        } catch (Exception e){
            // In case something goes wrong, prepare to return an empty array
            records = new String[0];
        }
        return records;
    }  // method getRecordsByCounting

    public static void main(String[] args)  {
        File f = new File("moreStudents.text");
        String results[] = getRecordsByCounting(f);
        if (results.length > 0)
            for (int i = 0; i < results.length; i++) {
                System.out.println(results[i]);
            }
        else
            System.out.println("File not found.");
    }
}
