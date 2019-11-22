package vn.neways.action;

import vn.neways.services.TutorialsServices;

public class TutorialBestAction {
	
	// Declare properties
	private String bestTutorials;
	
	public String execute() {
		TutorialsServices tutorialsServices = new TutorialsServices();
		bestTutorials = tutorialsServices.getBest();
		System.out.println(bestTutorials);
		return "success";
	}
	
	// Method use to access value from JSP
	public String getBestTutorials() {
		return bestTutorials;
	}

}
