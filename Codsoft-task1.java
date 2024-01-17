import java.util.Random;
import java.util.Scanner;

public class Number_game {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the Guess the Number Game!");

        boolean playAgain = true;
        int totalAttempts = 0;
        int totalRounds = 0;

        while (playAgain) {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean correctGuess = false;

            System.out.println("\nRound " + (totalRounds + 1) + ":");

            while (attempts < 10) {
                System.out.print("Enter your guess (between 1 and 100): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == secretNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    correctGuess = true;
                    break;
                } else if (userGuess < secretNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was "
                        + secretNumber + ".");
            }

            totalAttempts += attempts;
            totalRounds++;

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("yes");
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Rounds: " + totalRounds);
        System.out.println("Total Attempts: " + totalAttempts);
        System.out
                .println("Average Attempts per Round: " + (totalRounds > 0 ? (double) totalAttempts / totalRounds : 0));

        scanner.close();
    }
}
