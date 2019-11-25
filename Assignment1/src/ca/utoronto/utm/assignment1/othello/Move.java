package ca.utoronto.utm.assignment1.othello;

/**
 * 
 * 
 * Class move denotes a tuple containing a row and col coordinates.
 * 
 * @author arnold
 *
 */
public class Move {
	private int row, col;

	/**
	 * Initializes a Move object with param's row and col.
	 * 
	 * @param row
	 * @param col
	 */
	public Move(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * Getter method for row
	 * 
	 * @return int
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Getter method for col
	 * 
	 * @return int
	 */
	public int getCol() {
		return col;
	}

	/**
	 * Returns a string representataion of this object.
	 * 
	 * @return String
	 */
	public String toString() {
		return "(" + this.row + "," + this.col + ")";
	}
}
