public class WorkForce {
    public static void main(String[] args) {
        WorkRecord wA = new WorkRecord("Andy");
        WorkRecord wG = new WorkRecord("George");

        System.out.println(wG.getHours());
        wG.addHours(3);
        System.out.println(wG.getHours());
        wG.addHours(-12);
        System.out.println(wG);
    }
}
