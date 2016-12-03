
public class Schiebepuzzle {

	private int[][] puzzle = new int[4][4];

	public Schiebepuzzle() {
		for (int i = 0; i < this.puzzle.length; ++i) {
			for (int j = 0; j < this.puzzle[i].length; ++j) {
				if (i == 3 && j == 3) {
					this.puzzle[i][j] = 0;
				} else {
					this.puzzle[i][j] = i * 4 + j + 1;
				}
			}
		}
	}

	public void schiebe(int i) throws WrongNumberException, WrongMoveException {
		// variables for the indexes of the empty place
		int a = -1;
		int b = -1;
		// variables for the indexes of the number i
		int c = -1;
		int d = -1;
		if (i >= 1 && i <= 15) {
			for (int z = 0; z < this.puzzle.length; ++z) {
				for (int j = 0; j < this.puzzle[z].length; ++j) {
					if (this.puzzle[z][j] == 0) {
						a = z;
						b = j;
					}
					if (this.puzzle[z][j] == i) {
						c = z;
						d = j;
					}
					if (a != -1 && c != -1) {
						break;
					}
				}
			}
			if (this.istVerschiebbar(i)) {
				this.puzzle[a][b] = i;
				this.puzzle[c][d] = 0;
			} else {
				throw new WrongMoveException("Given Number cannot be moved!");
			}
		} else {
			throw new WrongNumberException("Invalid Number given!");
		}
	}

	public boolean istVerschiebbar(int i) {
		// variables for the indexes of the empty place
		int a = -1;
		int b = -1;
		// variables for the indexes of the number i
		int c = -1;
		int d = -1;
		if (i >= 1 && i <= 15) {
			for (int z = 0; z < this.puzzle.length; ++z) {
				for (int j = 0; j < this.puzzle[z].length; ++j) {
					if (this.puzzle[z][j] == 0) {
						a = z;
						b = j;
					}
					if (this.puzzle[z][j] == i) {
						c = z;
						d = j;
					}
					if (a != -1 && c != -1) {
						break;
					}
				}
			}
			if ((a + 1 == c && b + 1 == d) || (a + 1 == c && b - 1 == d) || (a - 1 == c && b + 1 == d)
					|| (a - 1 == c && b - 1 == d)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public void mische() {
		int number = -1;
		for (int i = 0; i < 100; ++i) {
			while (true) {
				number = (int) (Math.random() * 16);
				if (this.istVerschiebbar(number)) {
					this.schiebe(number);
					break;
				}
			}
		}
	}

	public String toString() {
		String s = "";
		int number = 0;
		for (int i = 0; i < this.puzzle.length; ++i) {
			for (int j = 0; j < this.puzzle[i].length; ++j) {
				number = this.puzzle[i][j];
				if (number == 0) {
					s += "|  ";
				} else {
					s += String.format("|%2d", number);
				}
			}
			s += "|\n";
			s += "-------------\n";
		}
		return s;
	}

	public int[][] getPuzzle() {
		int[][] result = new int[this.puzzle.length][this.puzzle[0].length];
		for (int i = 0; i < this.puzzle.length; ++i) {
			for (int j = 0; j < this.puzzle[i].length; ++j) {
				result[i][j] = this.puzzle[i][j];
			}
		}
		return result;
	}

}
