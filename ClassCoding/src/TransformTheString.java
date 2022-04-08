public class TransformTheString {

    private static final int ALPHABET = 26;

    public static int minOps(String S, String F) {
        int count = 0;
        if (F.length() == 1) {
            for (int i = 0; i < S.length(); i++) {
                count += minf(S.charAt(i), F.charAt(0));
            }
        } else {
            for (int i = 0; i < S.length(); i++) {
                int minRotations = minf(S.charAt(i),F.charAt(0));
                for (int j = 1; j < F.length(); j++) {
                    if (minf(S.charAt(i), F.charAt(j)) < minRotations)
                        minRotations = minf(S.charAt(i), F.charAt(j));
                }
                count += minRotations;
            }
        }
        return count;
    }

    public static int clockwise(char from, char to) {
        if ((int)from < (int)to)
            return (int)to - (int)from;
        else
            return ALPHABET - ((int)from - (int)to);
    }

    public static int counterClockwise(char from, char to) {
        if ((int)from < (int)to)
            return ALPHABET - ((int)to - (int)from);
        else
            return (int)from - (int)to;
    }

    public static int minf(char from, char to) {
        return Math.min(clockwise(from, to), counterClockwise(from, to));
    }

    public static void main(String[] args) {
        System.out.println(minOps("abd","abd"));
    }
}
