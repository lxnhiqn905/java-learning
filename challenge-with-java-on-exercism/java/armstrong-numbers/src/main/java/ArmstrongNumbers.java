class ArmstrongNumbers {

	boolean isArmstrongNumber(int numberToCheck) {
		String number = String.valueOf(numberToCheck);
		int len = number.length();
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += Math.pow(Integer.parseInt(number.substring(i, i + 1)), len);
		}
		return sum == numberToCheck;

	}

}
