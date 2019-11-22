package vn.neways.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.neways.dto.User;
import vn.neways.enums.Enums;
import vn.neways.service.LoggerService;
import vn.neways.service.UserService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = { "/signup" })
public class SignupController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    UserService userService = new UserService();
    
    LoggerService logger = new LoggerService();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.getSession().setAttribute(Enums.STATUS_LOGIN.toString(), null);
	// Has been logon
	if ("LOGON".equals(request.getSession().getAttribute(Enums.STATUS_LOGIN.toString()))) {
	    response.sendRedirect("/ShoppingApp");
	    return;
	}
	// Not yet signup
	logger.write(request);
	response.sendRedirect("signup.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	if (userService.signup(request)) {
	    logger.write(request);
	    response.sendRedirect("/ShoppingApp/login");
	    return;
	}
	request.getSession().setAttribute(Enums.STATUS_LOGIN.toString(), "FAILED");
	
	logger.write(request);
	response.sendRedirect("signup.jsp");
    }

}
