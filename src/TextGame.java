import java.util.Random;
import java.util.Scanner;

public class TextGame {
    // DEFAULT VARIABLES
    // When a variable is declared as static, a single copy of the variable is created and shared at the class level (essentially global to the class)
    static int playerHealth = 100;
    static double playerAttackMultiplier = 1.0;
    static int enemyHealth = 100;
    static double attackMultiplier = 1.0;
    static int numberPotions = 2;

    // MAIN GAME LOGIC
    public static void game() {
        System.out.println("Are you ready to begin your adventure? [y/n]");
        Scanner scanner = new Scanner(System.in);
        String startResponse = scanner.next();
        if (startResponse.equalsIgnoreCase("y") || startResponse.equalsIgnoreCase("yes")) {
            System.out.println("WELCOME TO FIGHT CLUB");
            System.out.println("What is your name?");
            String username = scanner.next();
            String opponent = randomEnemy();
            System.out.printf("%s, today you will be fighting %s!%n", username, opponent);
            if (opponent.equals("Zeus")) {
                enemyHealth = 200;
                attackMultiplier = 1.5;
            }
            if (opponent.equals("MacGruber")) {
                enemyHealth = 75;
                attackMultiplier = 0.75;
            }
            if (opponent.equals("Arnold")) {
                enemyHealth = 150;
                attackMultiplier = 1.25;
            }
            if (opponent.equals("Red Shirt")) {
                enemyHealth = 100;
                attackMultiplier = 0.5;
            }
            System.out.printf("%s's health is %s.%n", opponent, enemyHealth);
            System.out.printf("Your health is %s.%n", playerHealth);
            System.out.println("Would you like to eat a steak (+25 hp buff) or drink mead (+15% attack modifier)? [steak/mead]");
            if (scanner.next().equalsIgnoreCase("steak")) {
                playerHealth += 25;
                System.out.printf("Yummy! Health is now %s!%n", playerHealth);
            } else if (scanner.next().equalsIgnoreCase("mead")) {
                playerAttackMultiplier = 1.15;
                System.out.printf("*Burp* Attack increased to %s!%n", playerAttackMultiplier);
            } else {
                System.out.printf("Going in with an empty belly! Health is %s and Attack multiplier is %s.%n", playerHealth, playerAttackMultiplier);
            }
            // FIGHT SEQUENCE
            while (playerHealth > 0 && enemyHealth > 0) {
                System.out.println("Your enter the arena. Your opponent begins taunting you.");
                System.out.println("Would you like to attack, or flee(ending the game)? [attack/flee]");
                if(scanner.next().equalsIgnoreCase("attack")) {

                } else {
                    System.out.println("You have chosen to runaway to live to fight another day.");
                    return;
                }
            }

            // USER DOES NOT WANT TO PLAY
        } else {
            System.out.println("Okay, return at your leisure (coward).");
        }
    }

    // ATTACK METHOD
    public static int attack() {
        // rand.nextInt((max - min) + 1) + min;
        Random rand = new Random();
        // Attacks for 10-25 hitpoints
        return rand.nextInt((25 - 10) + 1) + 10;
    }

    // HEALTH POTION METHOD
    public static int heal() {
        if (numberPotions > 0) {
            numberPotions--;
            return playerHealth + 10;
        } else {
            System.out.println("No more potions!");
            return playerHealth;
        }
    }

    // RANDOM ENEMY NAME GENERATOR
    public static String randomEnemy() {
        String enemy;
        Random roll = new Random();
        int result = roll.nextInt(4);
        System.out.println(result);
        switch (result) {
            case 1:
                enemy = "Arnold";
                break;
            case 2:
                enemy = "MacGruber";
                break;
            case 3:
                enemy = "Zeus";
                break;
            default:
                enemy = "Red Shirt";
        }
        return enemy;
    }

    //////////////////////////////////////////////////////////MAIN//////////////////////////////////////////////////////////
    public static void main(String[] args) {
        game();
    }
}
