package ca.utoronto.utm.assignment1.othello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * TODO: Document this class and make minimal changes as necessary.
 * 
 * @author arnold
 *
 */
public class PlayerHuman {

	private static final String INVALID_INPUT_MESSAGE = "Invalid number, please enter 0-7";
	private static final String IO_ERROR_MESSAGE = "I/O Error";
	private static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	// PlayerHuman will serve as a superclass template so methods are protected.
	protected Othello othello;
	protected char player;

	/**
	 * Initializes a HumanPlayer to play Othello.
	 * 
	 * @param othello
	 * @param player
	 */

	public PlayerHuman(Othello othello, char player) {

		this.othello = othello;
		this.player = player;
	}

	/**
	 * uses helper function to return a valid move.
	 * 
	 * @return Move
	 */
	public Move getMove() {

		int row = getMove("row: ");
		int col = getMove("col: ");
		return new Move(row, col);
	}

	/**
	 * scans user input, checks if its valid and if it is, returns it.
	 * 
	 * @param message
	 * @return int
	 */
	private int getMove(String message) {

		int move, lower = 0, upper = 7;
		while (true) {
			try {
				System.out.print(message);
				String line = PlayerHuman.stdin.readLine();
				move = Integer.parseInt(line);
				if (lower <= move && move <= upper) {
					return move;
				} else {
					System.out.println(INVALID_INPUT_MESSAGE);
				}
			} catch (IOException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
				break;
			} catch (NumberFormatException e) {
				System.out.println(INVALID_INPUT_MESSAGE);
			}
		}
		return -1;
	}
}
