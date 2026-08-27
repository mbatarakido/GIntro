
public class Main {
    public static void main(String[] args) {

        // pyramid pattern
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}