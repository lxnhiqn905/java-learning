package vn.neways.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.neways.dto.User;
import vn.neways.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if ("SUSSCESSED".equals(request.getSession().getAttribute("loginStatus"))) {
			response.sendRedirect("success.jsp");
		} 
		else {
			response.sendRedirect("login.jsp");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("userId");
		String passs = request.getParameter("password");
		
		LoginService loginService = new LoginService();
		boolean auth = loginService.authencation(user, passs);
		
		if (auth) {
			User userLogin = loginService.getUser(user);
			request.getSession().setAttribute("loginStatus", "SUSSCESSED");
			request.getSession().setAttribute("userLogin", userLogin);
			response.sendRedirect("success.jsp");
		} 
		else {
			request.getSession().setAttribute("loginStatus", "FAILED");
			response.sendRedirect("login.jsp");
		}
	}

}
