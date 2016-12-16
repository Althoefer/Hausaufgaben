package ha10;

public class ZahlwortEnglisch extends Zahlwort {

	private final String[] einer = new String[] { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	private final String[] zehner = new String[] { "", "teen", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety" };
	private final String[] zehnerpotenzen = new String[] { "hundred", "thousand" };
	private final String[] spezialfaelle = new String[] { "zero", "ten", "eleven", "twelve", "thir", "fif", "eigh" };

	public ZahlwortEnglisch(int x) {
		super(x);
	}

	@Override
	public String getWortString() {
		String out = "";
		if (x == 0) {
			return this.spezialfaelle[0];
		}
		if (x >= 1000) {
			out += this.einer[x / 1000] + " " + this.zehnerpotenzen[1];
			x = x % 1000;
			if (x > 0) {
				out += " ";
			}
		}
		if (x >= 100) {
			out += this.einer[x / 100] + " " + this.zehnerpotenzen[0];
			x = x % 100;
			if (x > 0) {
				out += " ";
			}
		}
		if (x > 0 && out != "") {
			out += "and ";
		}
		if (x > 20) {
			if (x % 10 == 0) {
				out += this.zehner[x / 10];
			} else {
				out += this.zehner[x / 10] + "-" + this.einer[x % 10];
			}
		} else {
			switch (x) {
			case 0:
				break;
			case 10:
				out += this.spezialfaelle[1];
				break;
			case 11:
				out += this.spezialfaelle[2];
				break;
			case 12:
				out += this.spezialfaelle[3];
				break;
			case 13:
				out += this.spezialfaelle[4] + this.zehner[1];
				break;
			case 15:
				out += this.spezialfaelle[5] + this.zehner[1];
				break;
			case 18:
				out += this.spezialfaelle[6] + this.zehner[1];
				break;
			default:
				out += this.einer[x % 10] + this.zehner[x % 100 / 10];
			}
		}
		return out;
	}

	@Override
	public String getSprache() {
		return "Englisch";
	}

	public static void main(String[] args) {
		int[] testtabelle = { 10, 11, 12, 13, 15, 18, 20, 35, 51, 80, 103, 1067 };
		for (int zahl : testtabelle) {
			try {
				ZahlwortEnglisch zahlwort = new ZahlwortEnglisch(zahl);
				System.out.println(zahlwort);
			} catch (NumberFormatException ex) {
				System.out.println(ex);
			}
		}
	}

}
