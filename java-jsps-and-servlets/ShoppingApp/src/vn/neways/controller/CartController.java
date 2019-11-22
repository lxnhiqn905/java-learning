package vn.neways.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.neways.service.CartService;
import vn.neways.service.LoggerService;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    CartService cartService = new CartService();
    
    LoggerService logger = new LoggerService();

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	String productCancleId = request.getParameter("productCancleId");
	if (productCancleId != null) {
	    cartService.removecart(request, productCancleId);
	}
	cartService.viewcard(request);
	
	logger.write(request);
	response.sendRedirect("cart.jsp");
    }

}
