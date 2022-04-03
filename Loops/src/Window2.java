/**
 * An improved class to "draw" a <a href="https://en.wikipedia.org/wiki/Sash_window">sash window</a> with
 * two panes per sash, and two sashes. The window is drawn in proportion to the value of class
 * constant SIZE. For SIZE=3 (the default value), the window is drawn as follows:
 *
 *      Shape             Description
 *    +===+===+           * top frame: corner element (+) followed by SIZE times horizontal element (=)
 *    |   |   |           * upper sash made of vertical element, followed by SIZE times the
 *    |   |   |             "glass" element (just an empty space), repeated twice, and then
 *    |   |   |             repeating itself SIZE times.
 *    +===+===+           * mid frame: same construction as top frame
 *    |   |   |           * bottom sash: same as top sash.
 *    |   |   |
 *    |   |   |
 *    +===+===+           * bottom frame: same construction as top frame
 *
 * The improvement over class Window, is the addition of method repeater below. The method builds on an observation
 * from class Window. Methods frame and glassPane in class Window share code with identical behavior. Class
 * Window2 takes this code into a separate method (called repeater), simplifying the class a bit.
 *
 */

public class Window2 {

    /** A constant to control the size of the shapes in this class */
    public static final int SIZE = 5;

    /** A constant with the number of panes per sash */
    public static final int PANES = 2;

    /** Constants with construction elements */
    public static final char CORNER   = '+';
    public static final char FRAME    = '=';
    public static final char VERTICAL = '|';
    public static final char GLASS    = ' ';


    /**
     * This method is based on the observation that the frame component of the sash
     * window we wish to print
     * 
     *    +===+===+   
     *    
     * and the glass pane component
     *
     *    |   |   | 
     * 
     * have essentially the same pattern. A joint character (+ or |) followed by instances
     * of a repeatable character (= or space), followed by a joint, followed by the repeatable
     * characters, and finally followed by a joint. So, the method prints the pattern:
     *
     *    JOINT  STRAIGHT...STRAIGHT  JOINT  STRAIGHT...STRAIGHT   JOINT
     *            ^^^^^^^^^^^^^^^^^^^        ^^^^^^^^^^^^^^^^^^^
     *            repeats SIZE times         repeats SIZE times
     *
     * The pattern [JOINT  STRAIGHT ... STRAIGHT] repeats itself PANES times.
     *
     * @param joint A char for the corner element
     * @param straight A char for the straight element
     */
    public static void repeater(char joint, char straight) {
        for (int pane = 0; pane < PANES; pane++) {
            System.out.print(joint);
            for (int i = 0; i < SIZE; i++) {
                System.out.print(straight);
            }
        }
        System.out.println(joint);
    }  // method repeater


    /**
     * Creates the horizontal frame part
     */
    public static void frame() {
        repeater(CORNER,FRAME);
    }  // method frame


    /**
     * Creates the glass pane part of the window
     */
    public static void glassPanes() {
        for (int height = 0; height < SIZE; height++) {
            repeater(VERTICAL, GLASS);
        }
    }  // method sash


    /**
     * Puts together the frame part and the glass panes to form a sash.
     */
    public static void sash() {
        frame(); glassPanes();
    }  // method sash


    /**
     * Driver code
     */
    public static void main(String[] args) {
        sash();
        sash();
        frame();
    }  // method main

}  // class Window
