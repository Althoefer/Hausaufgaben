package ha10;

public class ZahlwortDeutsch extends Zahlwort {

	// final String[][] zahlen = new String[][] {
	// { "", "ein", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht",
	// "neun" },
	// { "", "zehn", "zwanzig", "dreissig", "vierzig", "fuenfzig", "sechsig",
	// "siebzig", "achtzig", "neunzig" },
	// { "", "einhundert", "zweihundert", "dreihundert", "vierhundert",
	// "fuenfhundert", "sechshundert",
	// "siebenhundert", "achthundert", "neunhudert" },
	// { "", "eintausend", "zweitausend", "dreitausend", "viertausend",
	// "fuenftausend", "sechstausend",
	// "siebentasuend", "achttausend", "neuntausend" },
	// { "und", "eins", "null", "elf", "zwoelf" } };

	final String[] einer = new String[] { "", "ein", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht",
			"neun" };
	final String[] zehner = new String[] { "", "zehn", "zwanzig", "dreissig", "vierzig", "fuenfzig", "sechsig",
			"siebzig", "achtzig", "neunzig" };
	final String[] zehnerpotenzen = new String[] { "hundert", "tausend" };
	final String[] spezialfaelle = new String[] { "null", "eins", "elf", "zwoelf", "sechzehn", "siebzehn" };

	public ZahlwortDeutsch(int x) {
		super(x);
	}

	@Override
	public String getWortString() {
		String out = "";
		if (this.x == 0) {
			return "null";
		}
		if (this.x >= 1000) {
			out += this.einer[this.x / 1000] + this.zehnerpotenzen[1];
			this.x = this.x % 1000;
		}
		if (this.x >= 100) {
			out += this.einer[this.x / 100] + this.zehnerpotenzen[0];
			this.x = this.x % 100;
		}
		if (this.x > 20) {
			if ((this.x % 10) == 0) {
				out += this.zehner[this.x / 10];
			} else {
				out += this.einer[this.x % 10] + "und" + this.zehner[this.x / 10];
			}
		} else {
			int zehner = (this.x % 100) / 10;
			int einer = this.x % 10;
			switch (this.x) {
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
				out += this.einer[einer] + this.zehner[zehner];
			}
		}

		return out;
	}

	@Override
	public String getSprache() {
		return "Deutsch";
	}

	public static void main(String[] args) {
		int[] testtabelle = { 1, 10, 11, 12, 16, 17, 20, 38, 69, 70, 131, 195, 2345, 2201 };
		for (int zahl : testtabelle) {
			Zahlwort zahlwort = new ZahlwortDeutsch(zahl);
			System.out.println(zahlwort.getWortString());
		}
	}

}