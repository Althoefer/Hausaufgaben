import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class EmailAdressBuch {
	
	private HashMap<String, String> adressBuch;
	
	public EmailAdressBuch(){
		adressBuch = new HashMap();
	}
	/**
	 * fuegt eine neue Adresse hinzu
	 */
	public void einfuegen(String name, String adresse){
		adressBuch.put(name, adresse);
	}
	
	/**
	 * gibt die adresse passend zum Namen zurück. Wenn der Name
	 * nicht im adressBuch steht, wird eine UnknownNameException geworfen
	 */
	public String abfrage(String name){
		if(adressBuch.get(name) != null){
			return adressBuch.get(name);
		}
		throw new UnknownNameException("Name nicht vorhanden!");
	}
	
	/**
	 * gibt das adressBuch als String zuruck, in der Form
	 * {name1=adresse1, name2=adresse2, ....}
	 */
	public String toString(){
		ArrayList<String> names = new ArrayList(this.adressBuch.keySet());
		
		//durchlaeuft alle Namen aus der  ArrayList names  und damit auch das adressBuch
		String ret = "{";
		for(int i = 0; i < names.size(); i++){
			ret += names.get(i) + "=" + adressBuch.get(names.get(i)) + ", ";
		}
		//entfernt das letzte anfeguegte ", "
		ret = ret.substring(0, ret.length()-3);
		ret += "}";
		
		return ret;
	}
	/*
	 * interne Methode um das adressBuch aus einem Scanner einzulesen
	 */
	private void einlesenScanner(Scanner scanner){
		String line[];
		while(scanner.hasNextLine()){
			line = scanner.nextLine().split(";");
			//line[0] ist der Name, line[1] die Adresse
			adressBuch.put(line[0], line[1]);
		}
	}
	
	
	/**
	 * liest aus einer angegebenen Datein ein. Ruft intern
	 * die Methode einlesenScanner auf und uebergibt ihr einen Scanner
	 */
	public void einlesen(String dateiname){
		File file = new File(dateiname);
		try{
			Scanner scanner = new Scanner(file);
			einlesenScanner(scanner);
		} catch(FileNotFoundException e){
			System.out.println("Dateiname ungültig");
		}
	}
	
	/**
	 * liest aus einer angegebenen URL ein. Ruft intern
	 * die Methode einlesenScanner auf und uebergibt ihr einen Scanner
	 */
	public void mitarbeiterEinlesen(URL url){
		try{
			URLConnection connection = url.openConnection(); 
			Object content = connection.getContent();
			Scanner scanner = new Scanner((InputStream)content);
			einlesenScanner(scanner);
		} catch(IOException e){
			System.out.println("Felhre1!1!");
		}
	}
}