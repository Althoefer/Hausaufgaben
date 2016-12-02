package ha02;

import java.net.MalformedURLException;
import java.net.URL;

public class TestAdressBuch {
	public static void main(String[] args) {
		EmailAdressBuch buch1 = new EmailAdressBuch();
		EmailAdressBuch buch2 = new EmailAdressBuch();
		try {
			URL url1 = new URL(
					"https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_intern.txt");
			URL url2 = new URL(
					"https://doc.itc.rwth-aachen.de/download/attachments/5800183/mitarbeiter_matse_extern.txt");
			buch1.mitarbeiterEinlesen(url1);
			buch1.mitarbeiterEinlesen(url2);
		} catch (MalformedURLException e) {
			System.out.println("URL ungültig");
		}
		
		buch2.einlesen("adressbuch.txt");
		System.out.println(buch2.toString());
		buch2.einfuegen("John Cena", "john.cena@gmx.de");
		System.out.println(buch2.toString());
		System.out.println(buch2.abfrage("Michel"));
		System.out.println(buch1.toString());
	}
}
