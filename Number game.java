import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalRounds = 0;
        int totalScore = 0;

        System.out.println("Welcome to 'Guess the Number' game!");

        while (true) {
            int number = random.nextInt(100) + 1;
            int attempts = 0;
            final int maxAttempts = 10; // Limit the number of attempts

            System.out.println("\nI have generated a number between 1 and 100. Can you guess it?");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < number) {
                    System.out.println("Too low!");
                } else if (guess > number) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the number.");
                    totalScore += (maxAttempts - attempts + 1);
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("You've used all your attempts. The number was: " + number);
            }

            totalRounds++;
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + totalRounds);
        System.out.println("Total score: " + totalScore);
        scanner.close();
    }
}
