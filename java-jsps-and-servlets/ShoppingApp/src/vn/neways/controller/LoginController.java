package vn.neways.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.neways.enums.Enums;
import vn.neways.service.LoggerService;
import vn.neways.service.UserService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    UserService userService = new UserService();
    
    LoggerService logger = new LoggerService();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// Has been logon
	if ("LOGON".equals(request.getSession().getAttribute(Enums.STATUS_LOGIN.toString()))) {
	    response.sendRedirect("/ShoppingApp");
	    return;
	}
	// Not yet login
	request.getSession().setAttribute(Enums.STATUS_LOGIN.toString(), null);
	
	logger.write(request);
	response.sendRedirect("login.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// Login success
	if (userService.login(request)) {
	    request.getSession().setAttribute(Enums.STATUS_LOGIN.toString(), "LOGON");
	    response.sendRedirect("/ShoppingApp");
	    return;
	}
	// Login failed
	request.getSession().setAttribute(Enums.STATUS_LOGIN.toString(), "FAILED");
	
	logger.write(request);
	response.sendRedirect("login.jsp");
    }

}
