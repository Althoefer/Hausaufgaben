import java.io.*;
import java.util.*;

public class Huffman {

	private static String[] alphabet = new String[27];

	public static String decode(File f) throws FileNotFoundException {
		String code = readFile(f);
		String text = "";
		int foo = 1;
		for (int i = 0; i < code.length(); i += foo) {
			foo = 1;
			for (int j = i + 1; j < code.length() + 1; ++j) {
				int place = Huffman.contains(code.substring(i, j));
				if (place != -1) {
					if (place != 26) {
						text += (char) (place + 'A');
						break;
					} else {
						text += " ";
						break;
					}
				}
				++foo;
			}
		}
		return text;
	}

	private static int contains(String substring) {
		for (int i = 0; i < Huffman.alphabet.length; ++i) {
			if (alphabet[i].equals(substring)) {
				return i;
			}
		}
		return -1;
	}

	private static String readFile(File f) throws IllegalArgumentException, FileNotFoundException {
		Scanner sc = new Scanner(f);
		String code = sc.nextLine();
		int i = 0;
		while (sc.hasNextLine()) {
			Huffman.alphabet[i] = sc.nextLine();
			++i;
		}
		sc.close();
		return code;
	}

	public static void main(String[] args) {
		try {
			File f1 = new File("message.txt");
			System.out.println(Huffman.decode(f1));
			File f2 = new File("mississippi.txt");
			System.out.println(Huffman.decode(f2));
		} catch (FileNotFoundException e) {
			System.out.println("Fehler");
		}
	}

}
