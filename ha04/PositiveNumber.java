package ha04;

/**
 * Klasse PositiveNumber, die eine positive Zahl speichert und die Moeglichkeit
 * bietet sie in andere Zahlensysteme (2,10,16) umzuwandeln
 *
 * @author cw585968
 *
 */
public class PositiveNumber {

	private int value;

	/**
	 * Speichert den zur uebergebenen Dezimalzahl gehoerenden Wert ab
	 *
	 * @param s
	 *            Dezimalzahl des Wertes, der gespeichert werden soll
	 * @throws NumberFormatException
	 *             falls ein unerlaubtes Zeichen uebergeben wird
	 * @throws ArithmeticException
	 *             falls eine negative oder zu grosse Zahl uebergeben wird
	 */
	public void setDecimal(String s) throws NumberFormatException, ArithmeticException {
		long prod = 0;
		long zahl = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if ((s.charAt(i) >= '0') && (s.charAt(i) <= '9')) {
				prod = s.charAt(i) - '0';
				for (int j = 1; j < (s.length() - i); j++) {
					prod = prod * 10;
				}
				zahl = zahl + prod;
				if ((prod > Integer.MAX_VALUE) || (zahl > Integer.MAX_VALUE)) {
					throw new ArithmeticException("Zu grosse Zahl!");
				}
			} else if (s.charAt(i) == '-') {
				throw new ArithmeticException("Zu kleine Zahl!");
			} else {
				throw new NumberFormatException("Unerlaubtes Zeichen!");
			}
		}
		this.value = (int) zahl;
	}

	/**
	 * Speichert den zur uebergebenen Hexadezimalzahl gehoerenden Wert ab
	 *
	 * @param s
	 *            Hexadezimalzahl des Wertes, der gespeichert werden soll
	 * @throws NumberFormatException
	 *             falls ein unerlaubtes Zeichen uebergeben wird
	 * @throws ArithmeticException
	 *             falls eine negative oder zu grosse Zahl uebergeben wird
	 */
	public void setHexadecimal(String s) throws NumberFormatException, ArithmeticException {
		long prod = 0;
		long zahl = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if ((s.charAt(i) >= '0') && (s.charAt(i) <= '9')) {
				prod = s.charAt(i) - '0';
				for (int j = 1; j < (s.length() - i); j++) {
					prod = prod * 16;
				}
				zahl = zahl + prod;
				if ((prod > Integer.MAX_VALUE) || (zahl > Integer.MAX_VALUE)) {
					throw new ArithmeticException("Zu grosse Zahl!");
				}
			} else if ((s.charAt(i) >= 'a') && (s.charAt(i) <= 'f')) {
				prod = s.charAt(i) - 87;
				for (int j = 1; j < (s.length() - i); j++) {
					prod = prod * 16;
				}
				zahl = zahl + prod;
				if ((prod > Integer.MAX_VALUE) || (zahl > Integer.MAX_VALUE)) {
					throw new ArithmeticException("Zu grosse Zahl!");
				}
			} else if (s.charAt(i) == '-') {
				throw new ArithmeticException("Zu kleine Zahl!");
			} else {
				throw new NumberFormatException("Unerlaubtes Zeichen!");
			}
		}
		this.value = (int) zahl;
	}

	/**
	 * Speichert den zur uebergebenen Binaerzahl gehoerenden Wert ab
	 *
	 * @param s
	 *            Binaerzahl des Wertes, der gespeichert werden soll
	 * @throws NumberFormatException
	 *             falls ein unerlaubtes Zeichen uebergeben wird
	 * @throws ArithmeticException
	 *             falls eine negative oder zu grosse Zahl uebergeben wird
	 */
	public void setBinary(String s) throws NumberFormatException, ArithmeticException {
		long prod = 0;
		long zahl = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if ((s.charAt(i) >= '0') && (s.charAt(i) <= '1')) {
				prod = s.charAt(i) - '0';
				for (int j = 1; j < (s.length() - i); j++) {
					prod = prod * 2;
				}
				zahl = zahl + prod;
				if ((prod > Integer.MAX_VALUE) || (zahl > Integer.MAX_VALUE)) {
					throw new ArithmeticException("Zu grosse Zahl!");
				}
			} else if (s.charAt(i) == '-') {
				throw new ArithmeticException("Zu kleine Zahl!");
			} else {
				throw new NumberFormatException("Unerlaubtes Zeichen!");
			}
		}
		this.value = (int) zahl;
	}

	/**
	 * Gibt den Wert als Dezimalzahl zurueck
	 *
	 * @return String der gespeicherte Wert als Dezimalzahl
	 */
	public String getDecimal() {
		String s = "" + this.value;
		return s;
	}

	/**
	 * Gibt den Wert als Hexadezimalzahl zurueck
	 *
	 * @return String der gespeicherte Wert als Hexadezimalzahl
	 */
	public String getHexadecimal() {
		String result = "";
		int zahl = this.value;
		char cbit = '0';
		// euklidischer Algorithmus
		do {
			int bit = zahl % 16;
			if (bit > 9) {
				cbit = (char) (bit + 55);
				result = result + cbit;
				zahl = zahl / 16;
			} else {
				result = result + bit;
				zahl = zahl / 16;
			}
		} while (zahl > 0);
		// umgekehrte Reihenfolge der Stellen
		StringBuilder s = new StringBuilder(result);
		s = s.reverse();
		result = s.toString();
		// Ende Algorithmus
		return result;
	}

	/**
	 * Gibt den Wert als Binaerzahl zurueck
	 *
	 * @return String der gespeicherte Wert als Binaerzahl
	 */
	public String getBinary() {
		String result = "";
		int zahl = this.value;
		// euklidischer Algorithmus
		do {
			int bit = zahl % 2;
			result = result + bit;
			zahl = zahl / 2;
		} while (zahl > 0);
		// umgekehrte Reihenfolge der Stellen
		StringBuilder s = new StringBuilder(result);
		s = s.reverse();
		result = s.toString();
		// Ende Algorithmus
		return result;
	}

}
