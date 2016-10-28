import java.util.Scanner;

public class Game {

	/*
	 * Sean Levin
	 * Mastermind Solver Driver Class
	 */

	/**
	 * Diver function that runs the Mastermind solver
	 */
	
	public static void main( String [] args ) {
		String answer;
		do {
			String [] totalColors = { "Blue", "Green", "Red", "Yellow", "Orange", 
					"White", "Black", "Brown" };
			Scanner input = new Scanner( System.in );
			System.out.println( "Welcome to Mastermind. I will solve your code"
					+ ". \nPlease choose the amount of places possible and what "
					+ "colors there will be. " );
			System.out.println( "Please enter the amount of places (Between 1 and 5) : " );
			int places = input.nextInt();
			System.out.println( "Please enter the amount of colors you want to "
					+ "play with (Between 1 and 8) : " );
			int colors = input.nextInt();
			String [] gameColors = new String [colors];
			for( int i = 0; i < colors; i++ ) {
				gameColors[i] = totalColors[i];
			}

			MasterMind master = new MasterMind( gameColors, places );

			System.out.println( "Okay watch as I guess that code. \nPlease respond with feedback "
					+ "as to whether or not I have the right color \nand if it is or is not in "
					+ "the right position." );

			while( master.hasWon == false ) {
				master.nextMove();
				master.pegCounter();
				if( master.hasWon == false ) {
					System.out.println( "Please enter the amount of red pegs:" );
					int red = input.nextInt();
					System.out.println( "Please enter the amount of white pegs:" );
					int white = input.nextInt();
				}
				master.response();  

			}
			System.out.println( "Would you like to play again? \nPlease type 'Yes'." );
			answer = input.next();
		} while( answer.equalsIgnoreCase( "Yes" ) );

	}

}
