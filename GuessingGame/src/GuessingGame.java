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
public final int MAX = 100;
public class GuessingGame 
{
	public static void main(String[] args) 
	{
		//makes variables that are used for the statistics
		int totalGames = 0;
		int totalGuesses = 0;
		int bestGame = 0;

		Scanner input = new Scanner(System.in);
		
		//prints out the intro message
		System.out.println("Let's play a game!");
		System.out.println();
		
		//starts the game
		int guessNum = playGame();

		//adds to the total statistics
		totalGuesses += guessNum;
		totalGames ++;
		
		//checks if the most recent game was the best
		bestGame = bestGameCheck(guessNum, bestGame);
		
		playAgain(guessNum, input);
	}
	
	//plays game
	public static int playGame()
	{
		int guessNum = 0;
		System.out.println("I am thinking of a number between 1 and 100. Can you guess what it is?");
		return guessNum;
	}
	
	//sees if the recent game was the lowest
	public static int bestGameCheck(int guessNum, int bestGame)
	{
		if(guessNum < bestGame)
			return guessNum;
	}
	{
		
	}
	
	//checks if the user wants to play again
	public static int playAgain(int guessNum, Scanner input)
	{
		
	}
	
}
