
public class ZahlwortDeutsch extends Zahlwort {

	final String[][] zahlen = new String[][] {
			{ "", "ein", "zwei", "drei", "vier", "fuenf", "sechs", "sieben", "acht", "neun" },
			{ "", "zehn", "zwanzig", "dreissig", "vierzig", "fuenfzig", "sechsig", "siebzig", "achtzig", "neunzig" },
			{ "", "einhundert", "zweihundert", "dreihundert", "vierhundert", "fuenfhundert", "sechshundert",
					"siebenhundert", "achthundert", "neunhudert" },
			{ "", "eintausend", "zweitausend", "dreitausend", "viertausend", "fuenftausend", "sechstausend",
					"siebentasuend", "achttausend", "neuntausend" },
			{ "und", "eins", "null", "elf", "zwoelf" } };

	public ZahlwortDeutsch(int x) {
		super(x);
	}

	@Override
	public String getWortString() {
		String number = this.x + "";
		String s;
		if (this.x == 1) {
			return this.zahlen[4][1];
		} else if (this.x == 0) {
			return this.zahlen[4][2];
		} else if (this.x == 11) {
			return this.zahlen[4][3];
		} else if (this.x == 12) {
			return this.zahlen[4][4];
		} else {
			StringBuilder temp = new StringBuilder(number);
			for (int i = 4; i > temp.length();) {
				temp.insert(0, '0');
			}
			number = temp.toString();
			if (number.charAt(0) == '0' && number.charAt(1) == '0' && number.charAt(3) == '0') {
				s = this.zahlen[1][number.charAt(2) - 48];
			} else {
				s = this.zahlen[3][number.charAt(0) - 48] + this.zahlen[2][number.charAt(1) - 48]
					+ this.zahlen[0][number.charAt(3) - 48] + this.zahlen[4][0] + this.zahlen[1][number.charAt(2) - 48];
			}
		}
		return s;
	}

	@Override
	public String getSprache() {
		return "Deutsch";
	}

	public static void main(String[] kommandozeile) {
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