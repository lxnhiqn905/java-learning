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
@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    LoggerService logger = new LoggerService();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// Not yet login
	request.getSession().setAttribute(Enums.USER_LOGIN.toString(), null);
	request.getSession().setAttribute(Enums.STATUS_LOGIN.toString(), null);
	
	logger.write(request);
	response.sendRedirect("/ShoppingApp");
    }

   
}
