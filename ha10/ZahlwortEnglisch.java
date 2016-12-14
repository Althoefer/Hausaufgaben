package ha10;

public class ZahlwortEnglisch extends Zahlwort {

	public ZahlwortEnglisch(int x) {
		super(x);
	}

	@Override
	public String getWortString() {
		
		return null;
	}

	@Override
	public String getSprache() {
		
		return null;
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
