
public class SchiebAlg1 implements Loesungsalgorithmus {

	@Override
	public void loese(Schiebepuzzle puzzle) {
		while (puzzle.getPuzzle()[0][0] != 1) {
			int number = -1;
			while (true) {
				number = (int) (Math.random() * 16);
				if (puzzle.istVerschiebbar(number)) {
					puzzle.schiebe(number);
					break;
				}
			}

		}
	}

}
