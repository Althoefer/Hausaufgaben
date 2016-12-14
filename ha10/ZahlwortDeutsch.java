package ha10;

public class ZahlwortDeutsch extends Zahlwort{

	public ZahlwortDeutsch(int x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getWortString() {

		return null;
	}

	@Override
	public String getSprache() {

		return null;
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