import java.util.Arrays;
import java.util.Scanner;

public class MasterMind {
	
	/*
	 * Sean Levin
	 * Mastermind Solver Algorithm
	 */

	private String [] masterPattern;
	private String masterPatternString = "";
	private String [] remainingPossibleGuesses;
	private TotalGuesses allPossibleGuesses = new TotalGuesses();
	private int currentGuess = 0;
	private String currentGuessString = "";
	private int colorsNum = 0;
	int redPegs = 0;
	int whitePegs = 0;
	private String [] remainingPossibleGuesses2;
	Integer [] pegs = new Integer[ 2 ];
	private int Guess = 1;
	private boolean firstMove = true;
	boolean hasWon = false;
	private static String [][] gameBoard = new String [ 10 ][  ];
	
	/**
	 * The main algorithm that combines all sub methods to guess the Mastermind Pattern
	 * 
	 * @param colors: The valid colors for this Mastermind round
	 * @param positions: The number of positions that this Mastermind round uses
	 */

	public MasterMind( String [] colors, int positions ) {
		Scanner input = new Scanner( System.in );
		remainingPossibleGuesses2 = allPossibleGuesses.totalGuesses( positions, colors.length );
		remainingPossibleGuesses = new String[ remainingPossibleGuesses2.length ];
		masterPattern = new String[ positions ];

		System.out.println( "You chose " + positions + " places." );

		String [] empty = new String[ positions ];
		switch( positions ) {
		case 1: empty[ 0 ] = "_";
		break;
		case 2: empty[ 0 ] = "_";
		empty[ 1 ] = "_";
		break;
		case 3: empty[ 0 ] = "_";
		empty[ 1 ] = "_";
		empty[ 2 ] = "_";
		break;
		case 4:	empty[ 0 ] = "_";
		empty[ 1 ] = "_";
		empty[ 2 ] = "_";
		empty[ 3 ] = "_";
		break;
		case 5: empty[ 0 ] = "_";
		empty[ 1 ] = "_";
		empty[ 2 ] = "_";
		empty[ 3 ] = "_";
		empty[ 4 ] = "_";
		break;

		}

		for( int i = 0; i < gameBoard.length; i++ ) {
			gameBoard[ i ] = empty.clone();
		}


		System.out.println( "You chose " + colors.length + " colors. \nThe following "
				+ "are the available colors for you to choose from." );
		for( int i = 0; i < colors.length; i++ ) {
			System.out.println( "#" + ( i + 1 ) + ". " + colors[i] );
		}
		colorsNum = colors.length;

		String [] nums = { "First", "Second", "Third", "Fourth", "Fifth" };
		System.out.println( "Please select the MasterMind pattern. \nMake sure that"
				+ " you enter the word with a capitalized first letter.: " );
		for( int i = 0; i < positions; i++ ) {
			System.out.println( nums[ i ] + " Color: " );
			String colorIn = input.next();
			masterPattern[ i ] = colorIn;
		}

		for( int i = 0; i < masterPattern.length; i++ ) {
			String color = masterPattern[ i ];
			switch( color ) {
			case "Blue": color = "1";
			break;
			case "Green": color = "2";
			break;
			case "Red": color = "3";
			break;
			case "Yellow": color = "4";
			break;
			case "Orange": color = "5";
			break;
			case "White": color = "6";
			break;
			case "Black": color = "7";
			break;
			case "Brown": color = "8";
			break;
			default: color = "That is an invalid color!";
			break;
			}
			masterPatternString = masterPatternString + color;
		}

		System.out.println();
	}
	
	/**
	 * Prints a board so that the user can see a visual of what the current board looks like
	 * @param guesses: The number of guesses that the computer has made.
	 * @param positions: The number of positions that exist in this game of Mastermind
	 * @param masterPattern: The Mastermind Pattern that the user defined that the beginning of the game
	 * @param guess: The current guess that the computer made 
	 */
	
	public void printBoard( int guesses, int positions, String masterPattern, int guess ) {
		String answer = "|";
		for( int j = 0; j < positions; j++ ) { 
			answer = answer + masterPattern.substring( j, j + 1 );
		}
		System.out.println( "Code    : " + answer + "|" );
		
		System.out.println( "___________________" );
		for( int i = 0; i < gameBoard.length; i++ ) {
			if( i == guess ) {
				for( int j = 0; j < gameBoard[ i ].length; j++ ) {
					gameBoard[ i ][ j ] = currentGuessString.substring( j, j + 1 );
				}
				System.out.println( "Guess #" + i + ". " + "|" + currentGuessString + "|"  );
			} else {
				System.out.println( "Guess #" + i + ". " + "|" + printArray( gameBoard[ i ] ) + "|"  );
			}
		}
		System.out.println( "___________________" );
	}

	public String printArray( String [] array ) {
		String row = "";
		for( int i = 0; i < array.length; i++ ) {
			row = row + array[ i ];
		}
		return row;
	}
	
	/**
	 * Method that decides the next move to make to solve the Mastermind Pattern
	 * 
	 * @return The next move that should be taken. Returned in the form of an array.
	 */

	public String [] nextMove() {
		if( firstMove ) {
			if( masterPattern.length == 5 ) {
				currentGuess = 11222;
				currentGuessString = "" + currentGuess;
				firstMove = false; 
			} else
				currentGuess = 1122;
			currentGuessString = "" + currentGuess;
			firstMove = false;
		} else {
			patternChecker();
				currentGuessString = remainingPossibleGuesses2[ 0 ]; 
		}

		String [] currentGuessArray = new String[ masterPattern.length ];
		for( int i = 0; i < masterPattern.length; i++ ) {
			String color = currentGuessString.substring( i, i + 1 );
			switch( color ) {
			case "1": color = "Blue";
			break;
			case "2": color = "Green";
			break;
			case "3": color = "Red";
			break;
			case "4": color = "Yellow";
			break;
			case "5": color = "Orange";
			break;
			case "6": color = "White";
			break;
			case "7": color = "Black";
			break;
			case "8": color = "Brown";
			break;
			}
			currentGuessArray[i] = color;
		}
		
		System.out.println();
		System.out.println();

		System.out.println( "The MasterMind pattern is: " );
		String pattern = "";
		for( int i = 0; i < masterPattern.length; i++ ) {
			if( i == masterPattern.length - 1 ) {
				pattern = pattern + masterPattern[ i ];
			} else {
				pattern = pattern + masterPattern[ i ] + ", ";
			}
		}
		System.out.println( "[ " + pattern + " ]" );

		String guess = "";
		for( int i = 0; i < currentGuessArray.length; i++ ) {
			if( i == masterPattern.length - 1 ) {
				guess = guess + currentGuessArray[ i ];
			} else {
				guess = guess + currentGuessArray[ i ] + ", ";
			}
		}
		System.out.println(  "Guess #" + Guess + ". [ " + guess + " ]" );

		printBoard( 10, gameBoard[ 0 ].length, masterPatternString, Guess - 1 );
		Guess++;
		checkWin( currentGuessArray );
		return currentGuessArray;
	}
	
	/**
	 * Counts the number of red and white pegs for the current guess
	 * 
	 * @return An array that represents the number of red and white pegs
	 */

	public Integer[] pegCounter() {
		whitePegs = 0;
		redPegs = 0;
		for( int j = 0; j < masterPattern.length; j++ ) {
			boolean check = true;
			if( ( currentGuessString.substring( j, j + 1 ).equals( masterPatternString.substring( j, j + 1 ) ) ) ) {
				redPegs++;
				check = false;
				/*I included the check = false here because now, the jth spot in the currentGuessString
				will not be tested again because it has been linked up to a red peg. The white peg will
				not try to test it. If the white did test it, there would be errors.*/
			}
			for( int k = 0; k < masterPattern.length; k++ ) {
				if( check ) {
					if( currentGuessString.substring( j, j + 1 ).equals( masterPatternString.substring( k, k + 1 ) ) ) {
						if( !( currentGuessString.substring( k, k + 1 ).equals( masterPatternString.substring( k, k + 1 ) ) ) ) {
							whitePegs++;
							check = false;
						}

						if( j == k ) {
							whitePegs--;
						}
					} 
				}
			}
		}
		pegs[ 0 ] = redPegs;
		pegs[ 1 ] = whitePegs;	
		whitePegs = 0;
		redPegs = 0;

		return pegs;
	}

	public void response() {
		System.out.println( "There are " + pegs[ 0 ] + " correct colors in the "
				+ "correct position. (Red Pegs)" );
		System.out.println( "There are " + pegs[ 1 ] + " correct colors in the "
				+ "wrong position. (White Pegs)" );
	}
	
	/**
	 * Checks to see if the computer has correctly guessed the user's Mastermind Pattern
	 * @param currentGuessArray: The array that holds the current computer guess
	 */

	public void checkWin( String [] currentGuessArray ) {
		if( Arrays.deepEquals( masterPattern, currentGuessArray ) ) {
			System.out.println( "Looks like I won... As if we all didn't know that would happen." );
			hasWon = true;
		}
	}
	
	/**
	 * Resets the game so the user can play again
	 */

	public void newGame() {
		String [] masterPattern;
		String masterPatternString = "";
		String [] remainingPossibleGuesses = new String[ 1296 ];
		TotalGuesses allPossibleGuesses = new TotalGuesses();
		int currentGuess = 0;
		String currentGuessString = "";
		int redPegs = 0;
		int whitePegs = 0;
		String [] remainingPossibleGuesses2;
		Integer [] pegs = new Integer[ 2 ];
		int Guess = 1;
		boolean firstMove = true;
		boolean hasWon = false;
	}
	
	/**
	 * Determines the number of possible guesses
	 * 
	 * @return An array representing all of the valid guesses that are left
	 */

	public String [] patternChecker() {
		for( int i = 0; i < remainingPossibleGuesses2.length; i++ ) {
			if( remainingPossibleGuesses2[ i ] != null ) {
				for( int j = 0; j < masterPattern.length; j++ ) {
					boolean check = true;
					if( ( currentGuessString.substring( j, j + 1 ).equals( remainingPossibleGuesses2[ i ].substring( j, j + 1 ) ) ) ) {
						redPegs++;
						check = false;
						//I included the check = false here because now, the jth spot in the currentGuessString
						//Will not be tested again because it has been linked up to a red peg. The white peg will
						//Not try to test it. If the white did test it, there would be errors.
					}
					for( int k = 0; k < masterPattern.length; k++ ) {
						if( check ) {
							if( currentGuessString.substring( j, j + 1 ).equals( remainingPossibleGuesses2[i].substring( k, k + 1 ) ) ) {
								if( !( currentGuessString.substring( k, k + 1 ).equals( remainingPossibleGuesses2[i].substring( k, k + 1 ) ) ) ) {
									whitePegs++;
									check = false;
								}

								if( j == k ) {
									whitePegs--;
								}
							}
						} 
					}
				}
				if( redPegs == pegs[0] && whitePegs == pegs[1] ) { 
					remainingPossibleGuesses[ i ] = remainingPossibleGuesses2[ i ];
				} else {
					remainingPossibleGuesses[ i ] = null;
				}
				redPegs = 0;
				whitePegs = 0;
			}

		}
		return newArray( remainingPossibleGuesses );
	}
	
	/**
	 * Custom function that deletes empty spaces in an array given to the function
	 * 
	 * @param array: The array that needs to have the empty spaces deleted
	 * @return An array with no empty spaces
	 */

	public String [] newArray( String [] array ) {
		int count1 = 0;
		int count2 = 0;
		for( int i = 0; i < array.length; i++ ) {
			if( array[i] == null ) {
				count1++;
			}
		}
		String [] newArray = new String[ array.length - count1 ];
		for( int i = 0; i < array.length; i++ ) {
			if( array[i] == null ) {
				count2++;
			} else {
				newArray[ i - count2 ] = array[ i ];
			}
		}

		remainingPossibleGuesses2 = new String[newArray.length];
		remainingPossibleGuesses2 = newArray;
		remainingPossibleGuesses = newArray;
		return remainingPossibleGuesses;
	}

}
