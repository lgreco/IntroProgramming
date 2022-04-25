public class Loopie {
    public static void main(String[] args) {
        String names[] = {"Leo", "Sarah", "Martin", "Mina"};
        boolean found;
        int i = 0;
        do {
            found = names[i].equals("Mina");
            i++;
        } while (!found && i < names.length);
        System.out.println(found);

        found = false;
        i = 0;
        while (!found && i < names.length) {
            found = names[i].equals("Martin");
            i++;
        }
        System.out.println(found);
    }
}
