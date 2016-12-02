package LA;

import java.util.Arrays;

public class VectorRn {
	private double[] vector;

	public VectorRn(double[] vector) {
		this.vector = vector;
	}

	public VectorRn(VectorRn v) {
		this.vector = v.vector;
	}

	/**
	 * gibt als Ergebnis die Addition von this und dem uebergebenen Vektor v2 an
	 * veraendert das this-Objekt nicht
	 */
	public VectorRn add(VectorRn v2) throws IllegalArgumentException {
		//haben die Vektoren die gleichen Dimensionen?
		if (this.vector.length != v2.getVector().length) {
			throw new IllegalArgumentException("Ungleiche Dimensionen der Vektoren");
		}
		double[] vector2 = v2.getVector();
		double[] summe = new double[vector.length];
		//jede Stelle wird addiert in einem Hilfsarray summe[] gespeichert
		for (int i = 0; i < vector.length; i++) {
			summe[i] = vector[i] + vector2[i];
		}
		return new VectorRn(summe);
	}

	/**
	 * gibt als Ergebnis die Multiplikation des this-Objekts mit dem Faktor d zurueck
	 * das this-Objekt wird dabei nicht veraendert
	 */
	public VectorRn mult(double d) {
		double[] mult = new double[vector.length];
		for (int i = 0; i < vector.length; i++) {
			mult[i] = vector[i] * d;
		}
		return new VectorRn(mult);
	}

	/**
	 * statische Methode
	 * berechnet das Skalarprodukt von v1 und v2
	 */
	public static double getScalarProd(VectorRn v1, VectorRn v2) throws IllegalArgumentException {
		double scalarProd = 0;
		//haben beide Vektoren die selben Dimensionen?
		if (v1.vector.length != v2.vector.length) {
			throw new IllegalArgumentException("Vektoren haben nicht die gleichen Dimensionen!");
		}
		//berechnet das Skalarprodukt 
		for (int i = 0; i < v1.vector.length; i++) {
			scalarProd += v1.vector[i] * v2.vector[i];
		}
		return scalarProd;
	}

	/**
	 * berechnet die norm / die laenge des this-Objekts
	 */
	public double getNorm() {
		double norm = 0;
		for (int i = 0; i < this.vector.length; i++) {
			norm += vector[i] * vector[i];
		}
		norm = Math.sqrt(norm);
		return norm;
	}

	/**
	 * 
	 * @param v2
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean isParallel(VectorRn v2) throws IllegalArgumentException {
		boolean parallel = true;
		double factor = 1;
		//ueberpruefen der Dimensionen
		if (this.vector.length != v2.vector.length) {
			throw new IllegalArgumentException("Dimensionen der Vektoren ungleich!");
		}
		//Faktor der Streckung wird anhand der ersten Elemente berechnet
		for (int i = 0; i < vector.length; i++) {
			if (this.vector[i] == 0) {
				//beide 0, Faktor nicht berechenbar
				if (v2.vector[i] == 0) {
					continue;
				}
				//ein Element 0, das andere nicht, ungueltig
				else {
					parallel = false;
					return parallel;
				}
				//erstes Element ungleich 0, anderes nicht, ungueltig
			} else if (v2.vector[i] == 0) {
				parallel = false;
				return parallel;
			}
			//beider Elemente zahlen, berechne Faktor
			else {
				factor = this.vector[i] / v2.vector[i];
			}
		}
		for (int i = 1; i < this.vector.length; i++) {
			//wenn der Faktor fuer die Elemente an der i-ten Stelle dem Faktor an Stelle 0 1 entspricht
			if (factor != this.vector[i] / v2.vector[i]) {
				parallel = false;
				return parallel;
			}
		}
		return parallel;
	}

	/**
	 * gibt den Vektor in der Form [a, b, ...] aus
	 */
	public String toString() {
		String s = "[";
		for (int i = 0; i < vector.length; i++) {
			s = s + vector[i] + " ,";
		}
		//zieht das letzte " ," ab
		s = s.substring(0, s.length() - 2);
		s = s + "]";

		return s;
	}

	public static double getWinkel(VectorRn v1, VectorRn v2) throws IllegalArgumentException {
		double winkel = 0;
		//arccos(scal(a,b) / norm(a) * norm(b))
		winkel = getScalarProd(v1, v2) / (v1.getNorm() * v2.getNorm());
		winkel = Math.acos(winkel);
		return winkel;
	}

	/**
	 * projiziert den Vector v1 auf v2
	 * @param v1
	 * @param v2
	 * @return
	 * 			Projizierten Vektor
	 * @throws IllegalArgumentException
	 */
	public static VectorRn projiziereV1aufV2(VectorRn v1, VectorRn v2) throws IllegalArgumentException {
		//projektion = ( scal(v1,v2) \ scal(v2,v2) ) * v2
		if (getScalarProd(v2, v2) != 0) {
			return v2.mult(getScalarProd(v1, v2) / getScalarProd(v2, v2));
		} else {
			throw new IllegalArgumentException("Fehler in der Matrix");
		}
	}

	public VectorRn[] bestimmeSenkrechteVektoren() {
		VectorRn[] senkrecht = new VectorRn[this.vector.length - 1];

		int i = 0;
		for (i = 0; i < this.vector.length; i++) {
			if (this.vector[i] == 0) {
				continue;
			}
			break;
		}
		if (i == this.vector.length) {
			throw new ArithmeticException("Vektor ist Nullvektor");
		}
		//zaehlt, wieviele senkrechte Vektoren noch gefunden werden sollen
		int count = this.vector.length - 1;

		aussen: for (i = 0; i < this.vector.length; i++) {
			for (int j = +1; j < this.vector.length; j++) {
				//erzeugt ein mit 0 befuelltes Array
				double[] workingCopy = new double[this.vector.length];
				Arrays.fill(workingCopy, 0);
				//count = 0 heisst senkrecht ist voll und es sind genuegend senkrechte bestimmt
				if (count == 0) {
					break aussen;
				}
				//fuegt in das leere Array zwei werte != 0 aus dem Vektor ein,
				//vertauscht und einer negiert
				if (this.vector[i] != 0 && this.vector[j] != 0) {
					workingCopy[i] = this.vector[j];
					workingCopy[j] = (-1) * this.vector[i];
					senkrecht[count - 1] = new VectorRn(workingCopy);
					count--;
					//continue aussen;
				}
			}
		}

		return senkrecht;
	}

	/**
	 * gibt einen Klon des internen Array des Vektors zurueck
	 * @return
	 */
	public double[] getVector() {
		double[] vectorR = vector.clone();
		return vectorR;
	}

	public static void main(String[] args) {
		try {
			/*
			 * Fehler wenn nur ein Element des Vektors ungleich 0 ist, z.B. (0,0,0,1)
			 */
			VectorRn a = new VectorRn(new double[] { 0, 0, 0, 0});
			VectorRn b = new VectorRn(new double[] { 3, 1, 4 });
			System.out.println("a: " + Arrays.toString(a.bestimmeSenkrechteVektoren()));
			System.out.println("b: " + Arrays.toString(b.bestimmeSenkrechteVektoren()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void teste1() {
		VectorRn vectorA = new VectorRn(new double[] { 1, 2, 3, 4 });
		System.out.println("Vektor a: " + vectorA.toString());
		VectorRn vectorB = new VectorRn(new double[] { 5, 6, 7, 8 });
		System.out.println("Vektor b: " + vectorB.toString());
		VectorRn vectorC = new VectorRn(new double[] { 1, 2 });
		System.out.println("Vektor c: " + vectorC.toString());
		VectorRn vectorD = new VectorRn(new double[] { 15, 18, 21, 24 });
		System.out.println("Vektor d: " + vectorD.toString());
		double d = 3;
		System.out.println("Double d: " + d);
		System.out.println();

		System.out.println("a + b = " + vectorA.add(vectorB).toString());
		try {
			System.out.println("a + c = " + vectorA.add(vectorC).toString());
		} catch (IllegalArgumentException e) {
			System.out.println("a + c = " + e.getMessage());
		}
		System.out.println("a * d = " + vectorA.mult(d).toString());
		System.out.println("(a,b) = " + VectorRn.getScalarProd(vectorA, vectorB));
		try {
			System.out.println("(a,c) = " + VectorRn.getScalarProd(vectorA, vectorC));
		} catch (IllegalArgumentException e) {
			System.out.println("(a,c) = " + e.getMessage());
		}
		System.out.println("norm(a) = " + vectorA.getNorm());
		System.out.println("a || b = " + vectorA.isParallel(vectorB));
		try {
			System.out.println("a || c = " + vectorA.isParallel(vectorC));
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("b || d = " + vectorB.isParallel(vectorD));
	}

	private static void teste2() {
		VectorRn vectorA = new VectorRn(new double[] { 1, 2, 3, 4 });
		System.out.println("Vektor a: " + vectorA.toString());
		VectorRn vectorB = new VectorRn(new double[] { 5, 6, 7, 8 });
		System.out.println("Vektor b: " + vectorB.toString());
		VectorRn vectorC = new VectorRn(new double[] { 5, 2 });
		System.out.println("Vektor c: " + vectorC.toString());
		VectorRn vectorD = new VectorRn(new double[] { -2, 5 });
		System.out.println("Vektor d: " + vectorD.toString());

		System.out.println(VectorRn.getWinkel(vectorA, vectorB));
		System.out.println(VectorRn.getWinkel(vectorC, vectorD));
		System.out.println(VectorRn.projiziereV1aufV2(vectorC, vectorD));
	}
}
