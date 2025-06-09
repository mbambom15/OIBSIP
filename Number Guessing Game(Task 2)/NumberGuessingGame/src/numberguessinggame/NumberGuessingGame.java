/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessinggame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author nhlak
 */
public class NumberGuessingGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        int minLimit = 1;
        int maxLimit = 100;
        int secretNumber = rand.nextInt(maxLimit - minLimit + 1) + minLimit;
        int numAttempts = 0;
        int maxAttempts = 6;
        boolean playAgain = true;
        int userInput;
        int numRounds = 0;
        int score = 0;

        while (playAgain) {
            numRounds++;
            System.out.println("Welcome to round " + numRounds + "  of the number guessing game");
            System.out.println("Try to guess the correct secret auto generated number(any number from 1 to 100)\n");

            while (numAttempts < maxAttempts) {
                System.out.print("Enter your guessed value here: ");
                userInput = input.nextInt();
                input.nextLine();

                if (userInput > secretNumber) {
                    System.out.println(userInput + " is too high.");
                } else if (userInput < secretNumber) {
                    System.out.println(userInput + " is too low.");
                } else if (userInput == secretNumber) {
                    System.out.println("Congratulations you guessed correctly " + userInput
                            + " is the correct secret random number.\n");
                    score += 10;
                    break;
                }
                numAttempts++;
            }

            if (numAttempts == maxAttempts) {

                System.out.println("Sorry, you have reached the maximum number of attempts. The correct number was " + secretNumber + ".\n");
            }

            System.out.print("Do you still want to play again? (yes/no): ");
            String playInput = input.nextLine();

            if (playInput.equalsIgnoreCase("no")) {
                playAgain = false;
            } else {
                secretNumber = rand.nextInt(maxLimit - minLimit + 1) + minLimit;
                numAttempts = 0;
            }
        }

        System.out.println("\n\n\t\t\tGame Over\nYou played " + numRounds + " round(s) your final score is " + score);

    }
}


