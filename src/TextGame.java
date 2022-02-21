import java.util.Random;
import java.util.Scanner;

public class TextGame {
    // DEFAULT VARIABLES
    // When a variable is declared as static, a single copy of the variable is created and shared at the class level (essentially global to the class)
    static int playerHealth = 100;
    static double playerAttackMultiplier = 1.0;
    static int enemyHealth = 100;
    static double enemyAttackMultiplier = 1.0;
    static int numberPotions = 2;

    // MAIN GAME LOGIC
    public static void game() {
        System.out.println("Are you ready to begin your adventure? [Y/N]");
        Scanner scanner = new Scanner(System.in);
        String startResponse = scanner.next();
        if (startResponse.equalsIgnoreCase("y") || startResponse.equalsIgnoreCase("yes")) {
            System.out.println("WELCOME TO FIGHT CLUB");
            System.out.println("--------------------");
            System.out.println("What is your name?");
            String username = scanner.next();
            String opponent = randomEnemy();
            System.out.printf("%s, today you will be fighting %s!%n", username, opponent);
            if (opponent.equals("Zeus")) {
                enemyHealth = 200;
                enemyAttackMultiplier = 1.5;
            }
            if (opponent.equals("MacGruber")) {
                enemyHealth = 75;
                enemyAttackMultiplier = 0.75;
            }
            if (opponent.equals("Arnold")) {
                enemyHealth = 150;
                enemyAttackMultiplier = 1.25;
            }
            if (opponent.equals("Fodder")) {
                enemyHealth = 100;
                enemyAttackMultiplier = 0.5;
            }
            System.out.printf("%s's health is %s.%n", opponent, enemyHealth);
            System.out.printf("Your health is %s.%n", playerHealth);
            System.out.println("--------------------");
            // Sometimes you have to type the word twice (but not always) - scanner bug?
            System.out.println("Would you like to eat a Steak (+25 hp buff) or drink Mead (+25% attack modifier)? [S/M]");
            if (scanner.next().equalsIgnoreCase("s")) {
                playerHealth += 25;
                System.out.printf("Yummy! Health is now %s!%n", playerHealth);
            } else if (scanner.next().equalsIgnoreCase("m")) {
                playerAttackMultiplier = 1.25;
                System.out.printf("*Burp* Attack increased to %s!%n", playerAttackMultiplier);
            } else {
                System.out.printf("Going in with an empty belly! Health is %s and Attack multiplier is %s.%n", playerHealth, playerAttackMultiplier);
            }
            // FIGHT SEQUENCE
            System.out.println("Your enter the arena. Your opponent begins taunting you.");
            while (playerHealth > 0 && enemyHealth > 0) {
                System.out.println("--------------------");
                System.out.printf("%s's health: %s%n", opponent, enemyHealth);
                System.out.printf("%s's health: %s%n", username, playerHealth);
                System.out.println("Would you like to Attack, or Flee? [A/F]");
                if (scanner.next().equalsIgnoreCase("a") && playerHealth >= 0 && enemyHealth >= 0) {
                    // Player attack
                    int baseAttack = attack();
                    int damage = (int) (playerAttackMultiplier * baseAttack);
                    enemyHealth -= damage;
                    if (enemyHealth > 0 && playerHealth > 0) {
                        System.out.printf("You strike %s for -%s damage! %s's health is now %s!%n", opponent, damage, opponent, enemyHealth);
                        System.out.println("--------------------");

                        // Opponent attack
                        System.out.println("After you attack, your opponent counters!");
                        baseAttack = attack();
                        damage = (int) (enemyAttackMultiplier * baseAttack);
                        playerHealth -= damage;
                        System.out.printf("%s strikes for -%s damage! Your health is now %s!%n", opponent, damage, playerHealth);

                        // Drink a health potion?
                        if (numberPotions > 0) {
                            System.out.printf("You have %s health potions.%n", numberPotions);
                            System.out.println("Would you like to drink one (+25hp)? [y/n]");
                            String potionResponse = scanner.next();
                            if (potionResponse.equalsIgnoreCase("y") && numberPotions > 0) {
                                playerHealth += 25;
                                numberPotions--;
                                System.out.printf("You feel the life-force awaken within! Your health is %s and you have %s potions remaining!%n", playerHealth, numberPotions);
                            } else if (potionResponse.equalsIgnoreCase("n") && numberPotions > 0) {
                                System.out.printf("You will save them for later. You have %s potions remaining%n", numberPotions);
                            } else {
                                System.out.println("You do not have any potions remaining!");
                            }
                        }
                    }

                    // Victory/Defeat Conditions
                    if (enemyHealth <= 0 && playerHealth > 0) {
                        System.out.printf("You strike %s for -%s damage!%n", opponent, damage);
                        System.out.printf("%s falls to the ground, taking their final breath...%n", opponent);
                        System.out.println("--------------------");
                        System.out.printf("%s, You are VICTORIOUS! Tomorrow you will return to work with pride!%n", username);
                        System.out.println("...");
                        System.out.println("...");
                        System.out.println("And remember...");
                        System.out.println("NEVER talk about Fight Club!!! Thanks for playing!");
                    } else if (playerHealth <= 0) {
                        System.out.printf("%s has bested you in combat... There will be no tomorrow for you, %s...", opponent, username);
                        System.out.println("GAME OVER");
                    }
                } else {
                    System.out.println("You have chosen the path of the coward, you runaway to live and fight another day.");
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
        // Attacks for 15-35 hitpoints
        return rand.nextInt((35 - 15) + 1) + 15;
    }

//    // HEALTH POTION METHOD
//    public static int heal() {
//        if (numberPotions > 0) {
//            numberPotions--;
//            return playerHealth + 10;
//        } else {
//            System.out.println("No more potions!");
//            return playerHealth;
//        }
//    }

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
                enemy = "Fodder";
        }
        return enemy;
    }

    //////////////////////////////////////////////////////////MAIN//////////////////////////////////////////////////////////
    public static void main(String[] args) {
        game();
    }
}
