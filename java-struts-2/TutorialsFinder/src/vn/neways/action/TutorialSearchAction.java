package vn.neways.action;

import vn.neways.services.TutorialsServices;

public class TutorialSearchAction {
	
	private String searchKey;
	private String searchResult;

	public String execute() {
		TutorialsServices tutorialsServices = new TutorialsServices();
		searchResult = tutorialsServices.search(searchKey);
		return "success";
	}
	
	// Using set parameter
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	// Using get properties
	public String getSearchResult() {
		return searchResult;
	}

}
