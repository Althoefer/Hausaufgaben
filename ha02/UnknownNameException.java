package ha02;

//trivial
public class UnknownNameException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnknownNameException(String s) {
		super(s);
	}
}