class Scrabble {
	
	private String word;
	final String POINT_1 = "AEIOULNRST";
	final String POINT_2 = "DG";
	final String POINT_3 = "BCMP";
	final String POINT_4 = "FHVWY";
	final String POINT_5 = "K";
	final String POINT_8 = "JX";
	final String POINT_10 = "QZ";
	
    Scrabble(String word) {
        this.word = word;
    }

    int getScore() {
    	int score = 0;
    	for (int i = 0; i < word.length(); i ++) {
    		score += POINT_1.indexOf(String.valueOf(word.charAt(i)).toUpperCase()) == -1 ? 0 : 1;
    		score += POINT_2.indexOf(String.valueOf(word.charAt(i)).toUpperCase()) == -1 ? 0 : 2;
    		score += POINT_3.indexOf(String.valueOf(word.charAt(i)).toUpperCase()) == -1 ? 0 : 3;
    		score += POINT_4.indexOf(String.valueOf(word.charAt(i)).toUpperCase()) == -1 ? 0 : 4;
    		score += POINT_5.indexOf(String.valueOf(word.charAt(i)).toUpperCase()) == -1 ? 0 : 5;
    		score += POINT_8.indexOf(String.valueOf(word.charAt(i)).toUpperCase()) == -1 ? 0 : 8;
    		score += POINT_10.indexOf(String.valueOf(word.charAt(i)).toUpperCase()) == -1 ? 0 : 10;
    	}
        return score;
    }

}
