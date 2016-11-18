
/**
 * class GefDilemma is the class for the implementation of a turn-based game
 * called "Gefangenendilemma" for two players. In each round the players have
 * the choice between cooperating or betray. Depending on the choice of both
 * players each player gets a different count of penalty points. The goal is to
 * get as least penalty points as possible.
 * 
 * @author cw585968
 *
 */
public class GefDilemma {

	// strategies for player1 and player2
	private GefStrategie player1;
	private GefStrategie player2;
	// penalty point count for player1 and player2
	private long pointsP1;
	private long pointsP2;

	/**
	 * Constructor of GefDilemma; sets the two strategies each player follows
	 * and sets the start values of the penalty points to zero.
	 * 
	 * @param player1
	 *            strategy of player1
	 * @param player2
	 *            strategy of player2
	 */
	public GefDilemma(GefStrategie player1, GefStrategie player2) {
		this.player1 = player1;
		this.player2 = player2;
		this.pointsP1 = 0;
		this.pointsP2 = 0;
	}

	// TODO
	/**
	 * Performs the game n turns.
	 * 
	 * @param n
	 *            number of turns of the game
	 */
	public void spiele(int n) {

	}

	/**
	 * Getter of player1's strategy
	 * 
	 * @return player1's strategy
	 */
	public GefStrategie getPlayer1() {
		return this.player1;
	}

	/**
	 * Getter of player2's strategy
	 * 
	 * @return player2's strategy
	 */
	public GefStrategie getPlayer2() {
		return this.player2;
	}

	// TODO
	/**
	 * Distributes the points to each player Missing parameters
	 * missing?????????????????? maybe make private method only?
	 */
	public void points() {

	}

	// TODO
	/**
	 * Both players are informed about the opponent's last turn and think aboit
	 * their next turn. parameter missing???????????? maybe make private method
	 * only?
	 */
	public void informAndThink() {

	}

}
