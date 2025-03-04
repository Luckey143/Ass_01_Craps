import java.util.Random;
import java.util.Scanner;
public class CrapsGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to Craps!");

        while (playAgain) {
            // Initial roll
            System.out.println("\nPress Enter to roll the dice...");
            input.nextLine();

            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", Sum: " + sum);

            // Check initial roll
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
            } else {
                // Point established
                int point = sum;
                System.out.println("Point is " + point);

                boolean pointPhase = true;
                while (pointPhase) {
                    System.out.println("Trying for point " + point);
                    System.out.println("Press Enter to roll again...");
                    input.nextLine();

                    die1 = random.nextInt(6) + 1;
                    die2 = random.nextInt(6) + 1;
                    sum = die1 + die2;

                    System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", Sum: " + sum);

                    if (sum == point) {
                        System.out.println("Made point and won!");
                        pointPhase = false;
                    } else if (sum == 7) {
                        System.out.println("Got a seven and lost.");
                        pointPhase = false;
                    }
                }
            }

            // Ask to play again
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Play again? (y/n): ");
                String response = input.nextLine().trim().toLowerCase();

                if (response.equals("y")) {
                    validInput = true;
                    playAgain = true;
                } else if (response.equals("n")) {
                    validInput = true;
                    playAgain = false;
                } else {
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                }
            }
        }

        System.out.println("Thanks for playing!");
        input.close();
    }
}

