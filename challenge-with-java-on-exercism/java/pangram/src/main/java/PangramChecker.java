public class PangramChecker {

	public static boolean isPangram(String input) {
		for (int i = 65; i <= 90; i++) {
			String lowcase = String.valueOf(Character.toChars(i));
			String upcase = String.valueOf(Character.toChars(i + 32));
			if (input.indexOf(lowcase) == -1 && input.indexOf(upcase) == -1) {
				return false;
			}
		}
		return true;
	}

}
