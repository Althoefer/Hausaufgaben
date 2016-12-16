package ha10;

public class ZahlwortDeutsch extends Zahlwort {

	final String[] einer = new String[] { "", "ein", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun" };
	final String[] zehner = new String[] { "", "zehn", "zwanzig", "dreissig", "vierzig", "fuenfzig", "sechzig", "siebzig", "achtzig", "neunzig" };
	final String[] zehnerpotenzen = new String[] { "hundert", "tausend" };
	final String[] spezialfaelle = new String[] { "null", "eins", "elf", "zwoelf", "sechzehn", "siebzehn" };

	public ZahlwortDeutsch(int x) {
		super(x);
	}

	@Override
	public String getWortString() {
		String out = "";
		if (x == 0) {
			return spezialfaelle[0];
		}
		if (x >= 1000) {
			out += einer[x / 1000] + zehnerpotenzen[1];
			x = x % 1000;
		}
		if (x >= 100) {
			out += einer[x / 100] + zehnerpotenzen[0];
			x = x % 100;
		}
		if (x > 20) {
			if (x % 10 == 0) {
				out += this.zehner[x / 10];
			} else {
				out += this.einer[x % 10] + "und" + this.zehner[x / 10];
			}
		} else {
			switch (x) {
			case 0:
				break;
			case 1:
				out += this.spezialfaelle[1];
				break;
			case 11:
				out += this.spezialfaelle[2];
				break;
			case 12:
				out += this.spezialfaelle[3];
				break;
			case 16:
				out += this.spezialfaelle[4];
				break;
			case 17:
				out += this.spezialfaelle[5];
				break;
			default:
				out += this.einer[x % 10] + this.zehner[x % 100 / 10];
			}
		}

		return out;
	}

	@Override
	public String getSprache() {
		return "Deutsch";
	}

	public static void main(String[] args) {
		int[] testtabelle = { 1, 10, 11, 12, 16, 17, 20, 38, 69, 70, 131, 195, 2345 };
		for (int zahl : testtabelle) {
			try {
				ZahlwortDeutsch zahlwort = new ZahlwortDeutsch(zahl);
				System.out.println(zahlwort);
			} catch (NumberFormatException ex) {
				System.out.println(ex);
			}
		}
	}

}