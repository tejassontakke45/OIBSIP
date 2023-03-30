//guess number 

import java.util.Random;
import java.util.*;

public class Game {

    public static void main(String[] args) {

        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int randomNumber = rand.nextInt(100) + 1;
        int tryCount = 0;
        while (true) {

            System.out.println("enter your guess(1-100)");
            int userGuess = scanner.nextInt();
            tryCount++;

            if (userGuess == randomNumber) {

                System.out.println("correct! you win!");
                System.out.println("It took you " + tryCount + " tries.");
                break;

            }

            else if (randomNumber > userGuess) {

                System.out.println("nope! the number is higher.guess again.");

            } else

            {

                System.out.println("nope!The number is lower.guess again");

            }

        }

        scanner.close();

    }

}