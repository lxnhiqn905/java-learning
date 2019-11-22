package vn.neways.action;

import vn.neways.services.TutorialsServices;

public class TutorialFindAction {
	private String language;
	private String findResult;

	public String execute() {
		TutorialsServices tutorialsServices = new TutorialsServices();
		findResult = tutorialsServices.find(language);
		System.out.println(findResult);
		return "success";
	}

	// Using to Interceptor setting input parameter in Value Stack
	public void setLanguage(String language) {
		this.language = language;
	}

	// Using to JSP get value from Value Stack
	public String getFindResult() {
		return findResult;
	}

}
