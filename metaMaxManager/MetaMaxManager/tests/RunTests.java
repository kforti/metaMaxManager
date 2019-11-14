package tests;


public class RunTests {
    public static void main(String[] args) {
        ImageStats stats = new ImageStats();
        try {
            stats.run();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
