package ha10;

public class AlleZahlen {
	public static void main(String[] args){
		for(int i=1; i<10000; i++){
			Zahlwort zw = new ZahlwortDeutsch(i);
			System.out.println(zw.toString());
		}
	}
}
