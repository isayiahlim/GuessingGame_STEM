/*
 * Name: Isayiah Lim
 * Date: 12/14/2021
 * APCS Period 2
 * Guessing Game Project
 * 
 * This program makes a guessing game where the use tries to guess a random number between 1-100.
 * The user can play it again after they win. After they stop playing, the program displays stats
 * telling them info about their games. 
 */
import java.util.Scanner;
public class GuessingGame 
{
	public static int MaxNum = 100;
	public static void main(String[] args) 
	{
		//makes variables that are used for the statistics
		int totalGames = 0;
		int totalGuesses = 0;
		//default number to ensure the code runs
		int bestGame = 10000000;
		int guessCount = 0;
		//variable that will run the game until made false
		boolean gamePlay = true;
		Scanner input = new Scanner(System.in);
		
		//prints out the intro message
		System.out.println("Let's play a game!");
		System.out.println();
		
		//starts the game and runs it until the player wants to stop
		while(gamePlay)
		{
			guessCount = playGame(input);
			//adds to the total statistics
			totalGuesses += guessCount;
			totalGames ++;
			
			//checks if the most recent game was the best
			bestGame = Math.min(bestGame, guessCount);
				
			//asks if the user wants to play again. If not, then it prints out the statistics
			gamePlay = playAgain(input);
		}
		//gets and prints out the stats of the game
		stats(guessCount, totalGames, totalGuesses, bestGame);	
	}
	
	//plays game
	public static int playGame(Scanner input)
	{
		//declares and initializes all the variables
		int guessCount = 0;
		int guessNum = (int)(Math.random()*MaxNum) + 1;
		int guess = 0;
		boolean isCorrect = false;
		
		//starts playing
		System.out.println("I am thinking of a number between 1 and " + MaxNum + ". Can you guess what it is?");
		System.out.println();
		
		//loop until the correct guess is made
		while(!isCorrect)
		{
			System.out.print("Your guess? ");
			guess = input.nextInt();
			//checks if the number is right
			isCorrect = (guess == guessNum);
			//prints out whether it is higher or lower
			if(guess < guessNum)
				System.out.println("It's higher.");
			else if (guess > guessNum)
				System.out.println("It's lower.");
			guessCount ++;
		}
		if (guessCount > 1)
			System.out.println("You got it right in "+ guessCount + " guesses");
		else
			System.out.println("You got it right in 1 guess");
		return guessCount;
	}
	
	//adds up the statistics
	public static void stats(int guessCount, double totalGames, double totalGuesses, int bestGame)
	{
		//calculates the average number of guesses
		double average = totalGuesses/totalGames;
		//prints out all the results
		System.out.println("Overall Results:");
		System.out.println("	Total Games     = "+ (int)totalGames);
		System.out.println("	Total Guesses   = " + (int)totalGuesses);
		//prints out the average number of guesses to two decimal points
		System.out.printf("	Average Guesses = %.2f", average);
		System.out.println();
		System.out.println("	Best Game       = " + bestGame);
	}
	
	//checks if the user wants to play again
	public static boolean playAgain(Scanner input)
	{
		System.out.print("Do you wish to play again? ");
		String answer = input.next();
		answer = answer.substring(0,1);
		answer = answer.toUpperCase();
		//asks for a response until a viable one (starting with Y or N) is given
		while(!answer.equals("Y") && !answer.equals("N"))
		{
			System.out.println("Sorry I didn't catch that.");
			System.out.print("Do you wish to play again? ");
			answer = input.next().substring(0,1).toUpperCase();
		}
		
		//returns whether the player wants to continue
		if(answer.equals("Y"))
		{	
			System.out.println();
			return true;
		}
		else if(answer.equals("N"))
		{
			System.out.println();
			return false;	
		}
		//void return statement that never gets used but eclipse is picky about
		return true;
	}
	
}
