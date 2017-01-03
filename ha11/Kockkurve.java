package ha11;

import java.awt.Point;

public class Kockkurve {
	
	/**
	 * 
	 * @param ax, ay	Koordinaten des Startpunktes
	 * @param bx, by	Koordinaten des Endpunktes
	 * @param rek		Tiefe der Rekursion
	 */
	public static void kochKurve(double ax, double ay, double bx, double by, double rek){
		//wen die Rekursionstiefe 0 beträgt, wird der Anfangspunkt ausgegeben
		if(((int) rek) == 0){
			System.out.printf("(%.1f/%.1f) ", ax, ay);
		} else {
			rek--;
			
			//erster Punkt
			double x1 = ax + (bx-ax)/3 ;
			double y1 = ay + (by-ay)/3 ;
			//zweiter Punkt
			double x2 = ax + (bx-ax)/2 + (Math.sqrt(3)/2) * ((by-ay)/3);
			double y2 = ay + (by-ay)/2 - (Math.sqrt(3)/2) * ((bx-ax)/3);
			//dritter Punkt
			double x3 = bx - (bx-ax)/3 ;
			double y3 = by - (by-ay)/3 ;
			
			kochKurve(ax, ay, x1, y1, rek);
			kochKurve(x1, y1, x2, y2, rek);
			kochKurve(x2, y2, x3, y3, rek);
			kochKurve(x3, y3, bx, by, rek);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		kochKurve(0, 500, 500, 500, 2);
		//da immer nur die Anfangspunkte ausgegeben wird, muss am ende noch der Endpunkt ausgegeben werden
		System.out.print("(500/500)");
	}
}