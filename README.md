# JavaLab7
I completed all the compulsory tasks:

-Creating the class Token. An instance of this class holds a number from 1 to maxValue. Considering the case when a token may be equal to 0, meaning that it can take the place of any number. (Using this feature when calculating the arithmetic progression length)

-Creating the class Board. An instance of this class will contain n (nrOfTokens) tokens, the players, and the players' scores.

-Creating the class Player. Each player will have a name. This class implements the Runnable interface. In the run method the player repeatedly extracts one token from the board, until we have a winner or until the board runs out of tokens.

-Creating the Game class. Simulating the game using a thread for each player. Paying attention to the synchronization of the threads when extracting tokens from the board. After each extraction, the board with the available tokens is printed. At the end of the game, each player's arithmetic progression array is shown and the winner is announced. (if there is a winner)

**See the output in the attached photo output.jpg
