class Acronym {
	
	private String phrase;
	
    Acronym(String phrase) {
        this.phrase = phrase.replaceAll("_", "");
    }

    String get() {
    	StringBuilder sb = new StringBuilder();
    	for (int k = 0; k < phrase.split("-").length; k ++) {
    		String phraseSplit = phrase.split("-")[k].trim();
			for (int i = 0; i < phraseSplit.split(" ").length; i ++) {
				sb.append(phraseSplit.split(" ")[i].substring(0,1).toUpperCase());
			}
    	}
        return sb.toString();
    }

}
