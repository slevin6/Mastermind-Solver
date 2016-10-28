
public class TotalGuesses {
	
	/*
	 * Sean Levin
	 * Determines the number of total guesses that are left
	 */
	
	String [] totalGuesses;
	int num = 0;
	
	public static void main( String [] args ) {
		TotalGuesses test = new TotalGuesses();
		test.totalGuesses( 5, 6 );
	}
	
	public String [] totalGuesses() {
		int num = 0;

		for( int i = 1; i < 7; i++ ) {
			for( int j = 1; j < 7; j++ ) {
				for( int k = 1; k < 7; k++ ) {
					for( int l = 1; l < 7; l++ ) {
						totalGuesses[ num ] = i + "" + j + "" + k + "" + l;
						num++;
					}
				}
			}
		}

		return totalGuesses;
	}
	
	public String [] totalGuesses( int positions, int colors ) {
		totalGuesses = new String[ ( int )Math.pow( colors, positions ) ];
		
		if( positions == 1 ) {
			for( int i = 1; i < colors + 1; i++ ) {
							totalGuesses[ num ] = i + "";
							num++;
			}
		}
		
		else if( positions == 2 ) {
			for( int i = 1; i < colors + 1; i++ ) {
				for( int j = 1; j < colors + 1; j++ ) {
							totalGuesses[ num ] = i + "" + j + "";
							num++;

				}
			}
		}
		
		else if( positions == 3 ) {
			for( int i = 1; i < colors + 1; i++ ) {
				for( int j = 1; j < colors + 1; j++ ) {
					for( int k = 1; k < colors + 1; k++ ) {
							totalGuesses[ num ] = i + "" + j + "" + k;
							num++;
					}
				}
			}
		}
		
		else if( positions == 4 ) {
			for( int i = 1; i < colors + 1; i++ ) {
				for( int j = 1; j < colors + 1; j++ ) {
					for( int k = 1; k < colors + 1; k++ ) {
						for( int l = 1; l < colors + 1; l++ ) {
							totalGuesses[ num ] = i + "" + j + "" + k + "" + l;
							num++;
						}
					}
				}
			}	
		}
		
		else if( positions == 5 ) {
			for( int i = 1; i < colors + 1; i++ ) {
				for( int j = 1; j < colors + 1; j++ ) {
					for( int k = 1; k < colors + 1; k++ ) {
						for( int l = 1; l < colors + 1; l++ ) {
							for( int m = 1; m < colors + 1; m++ ) {
								totalGuesses[ num ] = i + "" + j + "" + k + "" + l + "" + m;
								num++;
							}
							
						}
					}
				}
			}	
		}

		return totalGuesses;
	}

}
