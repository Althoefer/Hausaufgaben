package ha10;

public class AlleZahlen {
	public static void main(String[] args) {
		for (int i = 1; i < 1000; i++) {
			Zahlwort zw = new ZahlwortDeutschAlternative(i);
			System.out.println(zw.getWortString());
		}
	}
}
