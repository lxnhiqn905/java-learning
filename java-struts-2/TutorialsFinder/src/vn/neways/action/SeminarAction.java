package vn.neways.action;

import com.opensymphony.xwork2.ActionSupport;

public class SeminarAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String execute() {
		System.out.println("execute() is start ....");
		return SUCCESS;
	}

	public String list() {
		System.out.println("list() is start ....");
		return SUCCESS;
	}

	public String get() {
		System.out.println("get() is start ....");
		return SUCCESS;
	}

	public String add() {
		System.out.println("add() is start ....");
		return SUCCESS;
	}

	public String update() {
		System.out.println("update() is start ....");
		return SUCCESS;
	}

	public String delete() {
		System.out.println("delete() is start ....");
		return SUCCESS;
	}
}
