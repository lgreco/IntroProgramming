/**
 * A class to "draw" a <a href="https://en.wikipedia.org/wiki/Sash_window">sash window</a> with
 * two panes per sash, and two sashes. The window is drawn in proportion to the value of class
 * constant SIZE. For SIZE=3 (the default value), the window is drawn as follows:
 *
 *      Shape             Description
 *    +===+===+           * top frame: corner element (+) followed by SIZE times horizontal element (=)
 *    |   |   |           * upper sash made of vertical element, followed by SIZE times the
 *    |   |   |             "glasss" element (just an empty space), repeated twice, and then
 *    |   |   |             repeating itself SIZE times.
 *    +===+===+           * mid frame: same construction as top frame
 *    |   |   |           * bottom sash: same as top sash.
 *    |   |   |
 *    |   |   |
 *    +===+===+           * bottom frame: same construction as top frame
 *
 *
 *
 */

public class Window2 {

    /** A constant to control the size of the shapes in this class */
    public static final int SIZE = 5;

    /** A constant with the number of panes per sash */
    public static final int PANES = 2;

    /** Constants with construction elements */
    public static final char CORNER = '+';
    public static final char FRAME = '=';
    public static final char VERTICAL = '|';
    public static final char GLASS = ' ';

    public static void x(char a, char b) {
        for (int pane = 0; pane < PANES; pane++) {
            System.out.print(a);
            for (int i = 0; i < SIZE; i++) {
                System.out.print(b);
            }
        }
        System.out.println(a);
    }

    /**
     * Creates the horizontal frame part
     */
    public static void frame() {
        x(CORNER,FRAME);
    }  // method frame


    /**
     * Creates the glass pane part of the window
     */
    public static void glassPanes() {
        for (int height = 0; height < SIZE; height++) {
            x(VERTICAL, GLASS);
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
