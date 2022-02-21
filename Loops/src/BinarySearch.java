import java.util.Arrays;

public class BinarySearch {

    /**
     * Performs binary search on an array of integers and reports the position of a specified number.
     * If the number we look for, is not in the array the method returns -1
     * @param array Array to search through; must be sorted
     * @param target Number of find in array
     * @return index of found number; -1 if it doesn't exist
     */
    public static int binarySearch(int[] array, int target) {
        // Position of found element; assume no such element exists in array
        int position = -1;
        // Initialize left and right edges of search scope
        int left = 0;
        int right = array.length-1;
        // Create a switch to control the while loop below
        boolean found = false;
        // Set up a variable to count iterations
        int counter = 1;
        // Say something
        System.out.printf("\nInput array: %s", Arrays.toString(array));
        System.out.printf("\nSearch target is %d\n", target);
        /*
        The following loop will end when a search value is found or when the vale we are looking
        for is not found. A failed search will cause the left index to become larger than the right
        index. Consider the example with the array {0, 1, 2, 3, 4, 5, 6, 7} below, were the initials
        L, R, M indicate the left and right edges for each search, and M is the mid point between L and R.

                Looking for 6                       Looking for 61

        First   {0, 1, 2, 3, 4, 5, 6, 7}            {0, 1, 2, 3, 4, 5, 6, 7}
        pass     L        M           R              L        M           R

        Second  {0, 1, 2, 3, 4, 5, 6, 7}            {0, 1, 2, 3, 4, 5, 6, 7}
        Pass                 L  M     R                         L   M     R

        Third  {0, 1, 2, 3, 4, 5, 6, 7}            {0, 1, 2, 3, 4, 5, 6, 7}
        Pass                      L  R                                L  R
                                  M                                   M
        Four
        pass    No need; element found              Loop will encounter values
                                                        left = 8
                                                        right = 7
                                                    that will cause it to stop
         */
        while (left <= right & !found) {
            // Find the middle point between left and right positions
            int middle = (left+right)/2;
            // Say something
            System.out.printf("\n\tIteration # %d: left is at [%d], right at [%d], and middle is at [%d]",
                    counter, left, right, middle);
            // Can we be so lucky?
            if (target == array[middle]) {
                found = true;
                position = middle;
            } else if (target < array[middle]) {
                // Move to the left half
                right = middle-1;
            } else {
                // move to the right half
                left = middle+1;
            }
            // Say something
            System.out.printf("... next, L = %d and R = %d", left, right);
            // Increase counter
            counter++;
        }
        return position;
    }  // method binarySearch

    /** Driver code */
    public static void main(String[] args) {
        // Array to search
        int[] testArray = {0, 1, 2, 3, 4, 5, 6, 7};
        // Value to search for
        int searchFor = 61;
        // Position of element we are searchin for (-1 if not present)
        int positionSearchedFor = binarySearch(testArray, searchFor);
        // Say something
        if (positionSearchedFor == -1)
            System.out.printf("\n\nValue %d doesn't exist in input array.", searchFor);
        else
            System.out.printf("\n\nFound %d at position [%d]", searchFor, positionSearchedFor);
    }  // method main
}  // class BinarySearch
