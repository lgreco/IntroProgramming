import java.util.Random;

public class ExamTHREEErrorsFixedSp22
{
    /*
    This .java file contains both compile time and run time errors. Fix them so the code compiles and runs.
    File contains at least 5 errors
    Make your corrections match the original intent of the code (What the programmer intended)
     */
    public static void main(String[] args)
    {
        int aNumber;
        boolean isHot;
        String[] myFriends = {"John","Jane", "Jake", "Janice"};
        aNumber = 42;

        //Welcome
        //-- ERROR -->                                   Need semicolumn here |
        // System.out.println("Here's some programming I learned in COMP 170")
        System.out.println("Here's some programming I learned in COMP 170");
        //Give a random value to a boolean variable
        //-- ERROR -->  isHot = Random.nextBoolean();
        //                      ^^^^^^
        //                      This needs to be a Random object, as used
        //                      as shown in the next two lines.
        Random random = new Random();
        //-- ERROR --> semicolon      |
        // isHot = random.nextBoolean();
        isHot = random.nextBoolean();
        //Let's call a method that returns a value and print out the results
        calculateNewNumber( isHot, aNumber );
        //Print out all my friends
        //-- ERROR -->  There are two errors here: the loop goes over values
        //              0, 1, 2, 3, and 4, but the traversed array (myFriends)
        //              has only four elements. So we'll get an index out of
        //              bounds exception. To correct this we need the loop
        //              terminating condition to be i < 4 instead of i <= 4
        //
        //              Also, we want to eliminate the use of a magic number,
        //              so it's better to write the terminating condition as:
        //              i < myFriends.length
        //
        //              for (int i = 0; i <= 4; i++) {

        for (int i = 0; i < myFriends.length; i++) {
            //-- ERROR --> variable name below
            // name = myFriends[i];
            // needs to be declared as a
            // String
            String name = myFriends[i];
            System.out.println(name);
        }
    }

    //-- ERROR --> Method below has return statements, therefore it needs
    // a return type in its signature:
    //            ||||||
    public static double calculateNewNumber( boolean b, double d) {
        if (b) {
            return d*2;
        }
        else {
            return -d;
        }
    }
}