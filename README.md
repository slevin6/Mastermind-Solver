# Mastermind-Solver
Java project that solves a mastermind pattern. 


Synopsis: This project had us make a code that essentially solved Master Mind. Master Mind is a game of logic
where a "master" creates a pattern based on certain colors arranged in a specific order in x number of 
positions. (In this lab the color and positions had to change) Then a person (in this instance the computer)
has to guess the secret pattern in less than 11 guesses, with only the feedback of a red peg (showing that
one color is the correct color and in the correct position) and/or a white peg (showing that one color is
correct but in the wrong position). With that, we had to design an algorithm that found the secret pattern 
in less that 11 guesses. The game class was the actual main method that ran all the methods combined 
signifying the Master Mind game. The Master Mind class all but one method that comprised the Master Mind 
game. That includes printBoard(), printArray(), nextMove(), pegCounter(), response(), checkWin(), newGame(),
patternChecker(), and newArray(). The TotalGuesses class contains the method totalGuesses() which made
and contained all the possible combinations in an array which was then used in the Master Mind class.

Note: Note that when you enter in the colors that represent the Master Mind pattern, enter the full word
representing the color with a capitalized first letter (i.e. "Green"). Also note that I use the computer
generated version of the red and white pegs because there could be human error if humans put in the amount of
white and red pegs.
