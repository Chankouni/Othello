package ca.utoronto.utm.assignment1.othello;

import java.util.ArrayList;
import java.util.Random;

/**
 * PlayerRandom makes a move by first determining all possible moves that this
 * player can make, putting them in an ArrayList, and then randomly choosing one
 * of them.
 * 
 * @author arnold
 *
 */
public class PlayerRandom extends PlayerHuman {

	private Random rand = new Random();

	/**
	 * Initializes a HumanPlayer to play Othello.
	 * 
	 * @param othello
	 * @param player
	 */

	public PlayerRandom(Othello othello, char player) {
		super(othello, player);
	}

	public Move getMove() {

		// changes current arraylist of possible moves
		ArrayList<Move> possibleMoves = new ArrayList<Move>(1);

		for (int row = 0; row < this.othello.board.getDimension(); row++) {
			for (int col = 0; col < this.othello.board.getDimension(); col++) {
				for (int drow = -1; drow < 2; drow++) {
					for (int dcol = -1; dcol < 2; dcol++) {
						if (this.othello.board.flipNum(row, col, drow, dcol, player) != -1) {
							possibleMoves.add(new Move(row, col));

						}
					}
				}
			}
		}
		int index = rand.nextInt(possibleMoves.size());
		return possibleMoves.get(index);
	}

}
