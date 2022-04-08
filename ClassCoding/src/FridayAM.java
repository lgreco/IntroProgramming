import javax.crypto.spec.PSource;

public class FridayAM {


    /**
     * Returns an array twice as large and the input array, with the input array's
     * elements copied into it.
     * @param array String input array
     * @return String array with input array's elements and twice the size
     */
    public static String[] resize(String[] array, int factor){
        String[] newOutput = new String[factor* array.length];
        // run over the length of the input array
        for (int i = 0; i < array.length; i++)
            newOutput[i] = array[i];
        return newOutput;
    }

    public static String[] resize(String[] array) {
        return resize(array,2);
    }

    public static void main(String[] args) {
        String[] test = {"Hello", "World"};
        int factor = 3;
    }
}
