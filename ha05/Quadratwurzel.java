package ha05;

/**
 * implements the interface Rechenoperatio
 *
 */
public class Quadratwurzel implements Rechenoperation {

	/**
	 * returns the square root of parameter x
	 */
	@Override
	public double berechne(double x) {
		return Math.sqrt(x);
	}

}
