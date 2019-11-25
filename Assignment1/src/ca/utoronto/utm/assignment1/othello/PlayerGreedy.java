package ca.utoronto.utm.assignment1.othello;

/**
 * PlayerGreedy makes a move by considering all possible moves that the player
 * can make. Each move leaves the player with a total number of tokens.
 * getMove() returns the first move which maximizes the number of tokens owned
 * by this player. In case of a tie, between two moves, (row1,column1) and
 * (row2,column2) the one with the smallest row wins. In case both moves have
 * the same row, then the smaller column wins.
 * 
 * Example: Say moves (2,7) and (3,1) result in the maximum number of tokens for
 * this player. Then (2,7) is returned since 2 is the smaller row.
 * 
 * Example: Say moves (2,7) and (2,4) result in the maximum number of tokens for
 * this player. Then (2,4) is returned, since the rows are tied, but (2,4) has
 * the smaller column.
 * 
 * See the examples supplied in the assignment handout.
 * 
 * @author arnold
 *
 */

public class PlayerGreedy extends PlayerHuman {

	/**
	 * Initializes a GreedyPlayer to play Othello. Inherits from superclass
	 * PlayerHuman
	 * 
	 * @param othello
	 * @param player
	 */

	public PlayerGreedy(Othello othello, char player) {
		super(othello, player);
	}

	/**
	 * The way this works is that it checks every space on the board. For each space
	 * it checks, it also checks all directions. After each space is checked it
	 * comapares number of flipped. At the end, the space with highest amount of
	 * flips is returned.
	 * 
	 * @Override PlayerHuman's getMove method.
	 * @return Move
	 */

	public Move getMove() {

		int curHighest = -1;
		int curHighRow = 100000;
		int curHighCol = 100000;
		int max = super.othello.board.getDimension();

		for (int row = 0; row < max; row++) {
			for (int col = 0; col < max; col++) {
				int totalFlips = 0;
				for (int drow = -1; drow < 2; drow++) {
					for (int dcol = -1; dcol < 2; dcol++) {
						if (this.othello.board.flipNum(row, col, drow, dcol, player) != -1) {
							totalFlips += this.othello.board.flipNum(row, col, drow, dcol, player);
						}
					}
				}
				if (totalFlips > curHighest) {
					curHighest = totalFlips;
					curHighRow = row;
					curHighCol = col;
					continue;
				}
			}
		}
		return new Move(curHighRow, curHighCol);
	}
}
