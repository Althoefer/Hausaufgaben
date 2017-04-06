package ha10;

public abstract class Zahlwort {
	protected int x;

	public Zahlwort(int x) {
		if ((x <= 0) || (x >= 10000)) {
			throw new NumberFormatException("Zahl nicht im " + " Bereich zwischen 1 und 9999");
		} else {
			this.x = x;
		}
	}

	public String getZifferString() {
		return this.x + "";
	}

	public abstract String getWortString();

	public abstract String getSprache();

	@Override
	public String toString() {
		return "Die Zahl " + this.x + " schreibt man auf " + this.getSprache() + ": " + this.getWortString() + ".";
	}
}