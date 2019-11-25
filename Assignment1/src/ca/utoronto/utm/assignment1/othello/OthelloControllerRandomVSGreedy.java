package ca.utoronto.utm.assignment1.othello;

/**
 * The goal here is to print out the probability that Random wins and Greedy
 * wins as a result of playing 10000 games against each other with P1=Random and
 * P2=Greedy. What is your conclusion, which is the better strategy?
 * 
 * @author arnold
 *
 */
public class OthelloControllerRandomVSGreedy extends OthelloControllerHumanVSHuman {

	public OthelloControllerRandomVSGreedy() {
		super();
		super.player1 = new PlayerRandom(this.othello, OthelloBoard.P1);
		super.player2 = new PlayerGreedy(this.othello, OthelloBoard.P2);
	}

	/**
	 * @Overrides OthelloControllerHumanVSHuman
	 */
	public void play() {

		while (!othello.isGameOver()) {

			Move move = null;
			char whosTurn = othello.getWhosTurn();

			if (whosTurn == OthelloBoard.P1)
				move = player1.getMove();
			if (whosTurn == OthelloBoard.P2)
				move = player2.getMove();

			othello.move(move.getRow(), move.getCol());
		}
	}

	/**
	 * Run main to execute the simulation and print out the two line results. Output
	 * looks like: Probability P1 wins=.75 Probability P2 wins=.20
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int p1wins = 0, p2wins = 0, numGames = 10000;
		int curGames = 0;

		while (curGames <= numGames) {
			OthelloControllerRandomVSGreedy oc = new OthelloControllerRandomVSGreedy();
			oc.play();
			char winner = oc.othello.getWinner();
			if (winner == OthelloBoard.P1) {
				p1wins++;
			}
			if (winner == OthelloBoard.P2) {
				p2wins++;
			}
			curGames++;

		}
		// looking at tge results, P2 always seems to be the clear winner.
		System.out.println("Probability P1 wins=" + (float) p1wins / numGames);
		System.out.println("Probability P2 wins=" + (float) p2wins / numGames);
	}
}
