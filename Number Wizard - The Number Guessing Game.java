package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class WTNumberWizard {

    /**
     * NUMBER WIZARD By Teddie Wei!
     * The classic number guessing game, rewritten!

     * Features:
     * 3 difficulties (Amateur (1 - 10), Intermediate (1 - 100), Expert (1 - 1000))
     * Hints! You can choose to use 2 small hints and 1 big hint per game. Be conservative though, as you lose score points if you use them.
     * A scoring system! You start off with 2000 points, and you can lose or gain points based on the choices you make.

     * Scoring system:
     * You start off with 2000 points.
     * - 75 points per wrong guess.
     * - 100 points per small hint used.
     * - 400 points per big hint used.
     * - Final score at the end of the game multiplied by the difficulty multiplier (Amateur: x1, Intermediate: x2, Expert: x3).
     * - Your final score will be 0 if you fail to guess the secret number.

     * Instructions / Notes:
     * Start the program.
     * The game will ask you if you are ready to play, input "y" if yes or "n" if you would not like to play.
     * You'll have an option to choose a difficulty, they are...
     * Amateur (The secret number is in between 1 - 10, the score multiplier is 1x and no big hints can be used)
     * Intermediate (The secret number is in between 1 - 100 and the score multiplier is 2x)
     * Expert (The secret number is in between 1 - 1000 and the score multiplier is 3x)
     * You'll have 8 guesses to find the secret number.
     * When the game ends, you'll have the option to play again. The ability to change the difficulty after this has not been implemented yet.
     *
     * I have implemented try and catch statements and loop statements to prevent the user from inputing invalid statements :P
     * There are currently only 2 types of small hints and 1 type of big hints. I had programmed one to detect a random digit for the 3rd small hint but this project file was on my old hard drive which was corrupted.

     * Credit for borrowed code / assets:
     * -- Borrowed LoopingGame code from Mr. Cohen
     * -- Solved problems using StackOverflow Forums
     */

    private static final Scanner scan = new Scanner(System.in); // Used to scan user input.


    public static void main(String[] args) {
        String userReply; //user input
        Boolean isPlaying = true; //used to check if the user is playing the game

        // Introduces the name of the game, asks user if they are ready to play.
        System.out.println("WELCOME TO NUMBER WIZARD, THE ULTIMATE NUMBER GUESSING GAME!");
        System.out.println("Are you ready to play?? (Y/N)");
        userReply = scan.nextLine();
        userReply = userReply.toUpperCase();

        // Asks if the user wants to play, redirects to switch statement if yes. Terminates the program if no.
        if (userReply.equals("Y")) { //user wants to play
            System.out.println("Wise choice, good luck!");
        } else if (userReply.equals("N")) { //user doesn't want to play
            isPlaying = false;
            System.out.println("Once a coward, always a coward. Goodbye...");
            System.exit(0); //terminates the program
        }

        // Asks user for difficulty setting they want to play in.
        while (isPlaying) {
            System.out.println("Which difficulty would you like to play?");
            System.out.println("Amateur: 1 - 10 (Press 1)");
            System.out.println("Intermediate: 1 - 100 (Press 2)");
            System.out.println("Expert: 1 - 1000 (Press 3)");
            userReply = scan.nextLine();

            // Play the "Amateur difficulty". This difficulty will generate a number between 1 and 10.
            switch (userReply) {
                case "1" -> {
                    System.out.println("You have chosen to play Number Wizard at the Amateur difficulty.");
                    System.out.println("A random number between 1 - 10 has been generated. You have 8 guesses to find it.");
                    System.out.println("Remember, you can sacrifice score points for a hint if you're having trouble.");
                    System.out.println("Small hint (Enter 1001, -100 points), Big hint (Enter 1002, -400 points).");
                    System.out.println("You are ONLY allowed 2 small hints and 1 big hint per game. Note, you CANNOT use big hints in the Amateur difficulty.");
                    while (isPlaying) {
                        game(10, 1); // play the actual game
                        System.out.println("Do you want to play again? (Y/N)");
                        userReply = scan.nextLine().toUpperCase();

                        if (userReply.equals("N")) {//quit game
                            isPlaying = false;
                            System.out.println("The number wizard applauds your efforts! Good bye."); // say farewell to the player
                            System.exit(0);
                        }
                    }
                }

                // Play the "Intermediate difficulty". This difficulty will generate a number between 1 and 100.
                case "2" -> {
                    System.out.println("You have chosen to play Number Wizard at the Intermediate difficulty.");
                    System.out.println("A random number between 1 - 100 has been generated. You have 8 guesses to find it.");
                    System.out.println("Remember, you can sacrifice score points for a hint if you're having trouble.");
                    System.out.println("Small hint (Enter 1001, -100 points), Big hint (Enter 1002, -400 points).");
                    System.out.println("You are ONLY allowed 2 small hints and 1 big hint per game.");
                    while (isPlaying) {
                        game(100, 2); // play the actual game
                        System.out.println("Do you want to play again? (Y/N)");
                        userReply = scan.nextLine().toUpperCase();

                        if (userReply.equals("N")) {//quit game
                            isPlaying = false;
                            System.out.println("The number wizard applauds your efforts! Good bye."); // say farewell to the player
                            System.exit(0);
                        }
                    }
                }

                // Play the "Expert difficulty". This difficulty will generate a number between 1 and 1000.
                case "3" -> {
                    System.out.println("You have chosen to play Number Wizard at the Expert difficulty.");
                    System.out.println("A random number between 1 - 1000 has been generated. You have 8 guesses to find it.");
                    System.out.println("Remember, you can sacrifice score points for a hint if you're having trouble.");
                    System.out.println("Small hint (Enter 1001, -100 points), Big hint (Enter 1002, -400 points).");
                    System.out.println("You are ONLY allowed 2 small hints and 1 big hint per game.");
                    while (isPlaying) {
                        game(1000, 3); // play the actual game
                        System.out.println("Do you want to play again? (Y/N)");
                        userReply = scan.nextLine().toUpperCase();

                        if (userReply.equals("N")) {//quit game
                            isPlaying = false;
                            System.out.println("The number wizard applauds your efforts! Good bye."); // say farewell to the player
                            System.exit(0);
                        }

                    }
                }
            }

            System.out.println("Not a valid difficulty, please try again..."); // prints if player inputs anything other than "1", "2" or "3"

        }

    }

    private static void game(int difficulty, int scoreMultiplier) { // difficulty is the upper range that the secret number can generate to, the score multiplier multiplies your score based on which difficulty you play.
        int secretValue = (int) (Math.random() * difficulty) + 1;
        int userGuess = -1; // The user number guess input.
        int userTries = 1; // Used to count the amount of guess attempts that the user goes through.
        int score = 2000; // The score the user will receive at the end of the game. Can be increased with multipliers but decreased with added guesses and usage of hints.
        int smallHintCounter = 0; // Used to count how many small hints have been used.
        int bigHintCounter = 0; // Used to count how many big hints have been used.
        boolean isValidGuess; // Used to see if user input is a hint request or a valid guess.
        int smallHintSeed = 1; // Used to remember which small hint was given.

        while (userGuess != secretValue && userTries < 9) {
            System.out.println("Guess #" + userTries + ": Please enter a guess: ");

            isValidGuess = true; // Set as true to check when loop resets

            // Checks is user guess is a valid integer.
            do {
                try {
                    userGuess = scan.nextInt();
                    isValidGuess = false;
                } catch (InputMismatchException ex) {
                    System.out.println("Not a valid input. Please try again");
                    scan.nextLine();
                }
            }
            while (isValidGuess);


            // Checks if user requests a hint, if yes, prints a hint
            if (userGuess == 1001 || userGuess == 1002) {

                if (userGuess == 1001 && smallHintCounter < 2) { // Generates small hint

                    // This hint tells you if the secret number is odd or even
                    if (smallHintSeed == 1) {

                        if (secretValue % 2 == 0) {
                            System.out.println("The secret number is a even number");
                        } else {
                            System.out.println("The secret number is a odd number");

                        }

                        smallHintSeed++;

                    // This hint tells you if the secret number is closer to the upper or lower end of the generation range.
                    } else if (smallHintSeed == 2) {

                        if (secretValue > difficulty / 2) {
                            System.out.println("The secret number is closer to " + difficulty + " than it is to 1");
                        } else {
                            System.out.println("The secret number is closer to 1 than it is to " + difficulty);
                        }

                    }

                    smallHintCounter++;
                    score = score - 100;


                } else if (userGuess == 1002 && bigHintCounter < 1 && difficulty != 10) { // Generates big hint

                    // This hint tells you the first digit of the secret number.
                    int firstDigit = Integer.parseInt(Integer.toString(secretValue).substring(0, 1)); // Gets first digit of the substring

                    System.out.println("The first digit of the secret value is " + firstDigit);

                    bigHintCounter++;
                    score = score - 400;


                } else {

                    // Disables the usage of big hints when playing the amateur difficulty
                    if (difficulty == 10)
                        System.out.println("You cannot use a big hint in the Amateur difficulty!");
                    else
                        System.out.println("You've used all your available hints!");

                }

                // User would not like a hint, proceed with regular gameplay
            } else {
                userTries++; // Doesn't take away a guess if user uses a hint
                // Checks if user guess in above or below the target value
                if (userGuess > secretValue) {
                    System.out.println("Too high!");
                    score = score - 75; // subtract 75 from the score due to wrong guess

                    System.out.println("Your current score is " + score);
                } else if (userGuess < secretValue) {
                    System.out.println("Too low!");
                    score = score - 75; // subtract 75 from the score due to wrong guess
                    System.out.println("Your current score is " + score);
                }
            }

        }

        // Checks if user guess is equal to the target value.
        if (userGuess == secretValue) {
            userTries = userTries - 1;
            System.out.println("You won! It took you " + userTries + " tries!");
            System.out.println("Your final score is " + score * scoreMultiplier);

        } else {
            System.out.println("You lost. The secret number was " + secretValue);
            System.out.println("Your final score is 0");
        }

        // flush out the Scanner
        scan.nextLine();
    }


}

