package LA;

public class GeradeR2 extends AbstrakteEbene implements Hyperebene {
	
	private VektorRn stuetz;
	private VektorRn richtung;
	
	public GeradeR2(Punkt p1, Punkt p2) {
		//beide Punkte müssen die Dimension 2 haben
		if (p1.getVektorRn().getElements().length == 2 && p2.getVektorRn().getElements().length == 2) {
			this.stuetz = p1.getVektorRn();
			//berechnung des Richtungsvektors
			this.richtung = p1.getVektorRn().add(p2.getVektorRn().mult(-1));
		} else {
			throw new IllegalArgumentException("Punkte haben die falschen Dimensionen");
		}
	}

	public GeradeR2(VektorRn vector, Punkt p1) {
		if (p1.getVektorRn().getElements().length == 2 && vector.getElements().length == 2) {
			this.stuetz = p1.getVektorRn();
			this.richtung = vector;
		} else {
			throw new IllegalArgumentException("Punkte haben die falschen Dimensionen");
		}
	}

	@Override
	public VektorRn getNormalenvektor() {
		//trivial
		VektorRn normal = new VektorRn(2);
		normal.setElement(0, this.richtung.getElement(1));
		normal.setElement(1, this.richtung.mult(-1).getElement(0));
		return normal;
	}

	@Override
	public String getNormalform() {
		String out = this.getNormalenvektor().getElement(0) + "*x1 + " + this.getNormalenvektor().getElement(0) + "*x2";
		out += " + " + VektorRn.scalarProd(this.stuetz, this.getNormalenvektor());
		return out + " = 0";
	}
}
