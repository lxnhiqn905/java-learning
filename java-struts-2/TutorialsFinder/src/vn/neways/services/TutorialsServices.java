package vn.neways.services;

public class TutorialsServices {
	
	public String getBest() {
		return "Java Brains.";
	}
	
	public String find(String language) {
		if ("java".equals(language)) {
			return "Java Brains.";
		}
		return "Not yet support !!!";
	}
	public String search(String key) {
		return "Your key search: " + key;
	}

}
