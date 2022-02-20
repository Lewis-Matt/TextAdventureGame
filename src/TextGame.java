import java.util.Scanner;

public class TextGame {

    public static void game() {
        System.out.println("Are you ready to begin your adventure? [y/n]");
        Scanner scanner = new Scanner(System.in);
        String startResponse = scanner.next();
        if (startResponse.equalsIgnoreCase("y") || startResponse.equalsIgnoreCase("yes")) {







        } else {
            System.out.println("Okay, return at your leisure (coward).");
        }
    }

//////////////////////////////////////////////////////////MAIN//////////////////////////////////////////////////////////
    public static void main(String[] args) {
        game();
    }
}
