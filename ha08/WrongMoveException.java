package ha08;

/**
 * Exception to be thrown if a requested move cannot be performed in a given
 * Schiebepuzzle
 *
 * @author cw585968
 *
 */
public class WrongMoveException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public WrongMoveException(String s) {
		super(s);
	}

}
