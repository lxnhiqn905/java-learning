package vn.neways.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.neways.service.LoggerService;
import vn.neways.service.ProductService;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/buy")
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    ProductService productService = new ProductService();
    
    LoggerService logger = new LoggerService();

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String productId = request.getParameter("productId");
	productService.buy(request, productId);
	
	logger.write(request);
	response.sendRedirect("/ShoppingApp");
    }

}
