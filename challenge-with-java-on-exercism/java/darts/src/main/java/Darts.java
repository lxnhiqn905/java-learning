class Darts {

	private double x, y;

	Darts(double x, double y) {
		this.x = x;
		this.y = y;
	}

	int score() {
		double tar = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		if (tar <= 1) {
			return 10;
		} else if (1 < tar && tar <= 5) {
			return 5;
		} else if (5 < tar && tar <= 10) {
			return 1;
		} else {
			return 0;
		}
	}

}
