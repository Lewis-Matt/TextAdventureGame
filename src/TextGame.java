import java.util.Random;
import java.util.Scanner;

public class TextGame {
    int playerHealth = 100;
    int enemyHealth = 100;
    double attackMultiplier = 1.0;

    // MAIN GAME LOGIC
    public static void game() {
        System.out.println("Are you ready to begin your adventure? [y/n]");
        Scanner scanner = new Scanner(System.in);
        String startResponse = scanner.next();
        if (startResponse.equalsIgnoreCase("y") || startResponse.equalsIgnoreCase("yes")) {
            System.out.println("WELCOME TO FIGHT CLUB");
            System.out.println("What is your name?");
            String username = scanner.next();
            System.out.printf("Today you will be fighting %s!", randomEnemy());
            if(randomEnemy().equals("Zeus")) {

            }

        } else {
            System.out.println("Okay, return at your leisure (coward).");
        }
    }

    // ATTACK METHOD
    // Random attack on each turn (Player and Enemy)
    public static int attack() {
        // rand.nextInt((max - min) + 1) + min;
        Random rand = new Random();
        return rand.nextInt((25 - 10) + 1) + 10;
    }
    // BUFFS METHOD
    public static int heal() {
        return playerHealth + 15;
    }
    // FLEE LIKE A COWARD METHOD

    // RANDOM ENEMY NAME GENERATOR
    public static String randomEnemy() {
        int health;
        double attackMultiplier;
        String enemy;
        Random roll = new Random(3);
        int result = roll.nextInt();
        switch (result) {
            case 1:
                enemy = "Arnold";
                enemyHealth = 100;
                attackMultiplier = 1.15;
                break;
            case 2:
                enemy = "MacGruber";
                health = 75;
                attackMultiplier = 0.75;
                break;
            case 3:
                enemy = "Zeus";
                health = 200;
                attackMultiplier = 1.5;
                break;
            default:
                enemy = "Red Shirt";
                health = 50;
                attackMultiplier = 0.5;
        }

    }

    // ENEMIES


    //////////////////////////////////////////////////////////MAIN//////////////////////////////////////////////////////////
    public static void main(String[] args) {
        game();
    }
}
