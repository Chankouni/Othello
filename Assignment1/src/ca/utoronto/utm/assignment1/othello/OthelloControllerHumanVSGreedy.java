package ca.utoronto.utm.assignment1.othello;

/**
 * This controller uses the Model classes to allow the Human player P1 to play
 * the computer P2. The computer, P2 uses a greedy strategy.
 * 
 * @author arnold
 *
 */
public class OthelloControllerHumanVSGreedy extends OthelloControllerHumanVSHuman {

	/**
	 * Constructs a new OthelloController with a new Othello game, ready to play
	 * with one HumanPlayer and other GreedyPlayer at the console.
	 * 
	 * @Overides player2
	 */
	public OthelloControllerHumanVSGreedy() {
		super();
		super.player2 = new PlayerGreedy(this.othello, OthelloBoard.P2);
	}

	/**
	 * Run main to play a Human (P1) against the computer P2. The computer uses a
	 * greedy strategy, that is, it picks the first move which maximizes its number
	 * of token on the board. The output should be almost identical to that of
	 * OthelloControllerHumanVSHuman.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		OthelloControllerHumanVSGreedy oc = new OthelloControllerHumanVSGreedy();
		oc.play(); // this should work
	}
}
