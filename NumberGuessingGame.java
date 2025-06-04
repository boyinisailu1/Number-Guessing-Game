import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== Welcome to the Number Guessing Game ===");

        // Get range from user
        System.out.print("Enter the minimum number: ");
        int min = getValidInteger(scanner);

        System.out.print("Enter the maximum number: ");
        int max = getValidInteger(scanner);

        while (max <= min) {
            System.out.println("Maximum must be greater than minimum. Please try again.");
            System.out.print("Enter the maximum number: ");
            max = getValidInteger(scanner);
        }

        // Get number of attempts
        System.out.print("Enter the number of attempts you want: ");
        int maxAttempts = getValidInteger(scanner);

        int secretNumber = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("\nI have selected a number between " + min + " and " + max + ". Try to guess it!");

        while (attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
            int guess = getValidInteger(scanner);
            attempts++;

            if (guess == secretNumber) {
                System.out.println("🎉 Congratulations! You've guessed the number in " + attempts + " attempts.");
                hasGuessedCorrectly = true;
                break;
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try a higher number.");
            } else {
                System.out.println("Too high! Try a lower number.");
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("😢 Game Over! The correct number was: " + secretNumber);
        }

        scanner.close();
    }

    // Utility method for safe integer input
    private static int getValidInteger(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter an integer: ");
            scanner.next(); // discard invalid input
        }
        return scanner.nextInt();
    }
}
