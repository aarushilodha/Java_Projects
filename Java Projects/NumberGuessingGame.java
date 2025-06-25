import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) +1;
        Scanner sc = new Scanner(System.in);
        int guess;
        int attempts =0;

        System.out.println("Guess a number between 1 and 100");

        do{
            guess = sc.nextInt();
            attempts++;

            if(guess>numberToGuess){
                System.out.println("Too High! Try again.");
            }
            else if(guess<numberToGuess){
                System.out.println("Too Low! Try again.");
            }
            else{
                System.out.println("Correct! You guessed it in "+attempts+" tries.");
            }
        } 
        while(guess!= numberToGuess);
    }
}
