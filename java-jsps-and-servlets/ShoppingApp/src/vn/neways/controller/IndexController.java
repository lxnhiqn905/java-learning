package vn.neways.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.neways.dto.Product;
import vn.neways.enums.Enums;
import vn.neways.service.LoggerService;
import vn.neways.service.ProductService;

/**
 * Servlet implementation class IndexController
 */
@WebServlet(urlPatterns = { "/" })
public class IndexController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    ProductService productService = new ProductService();
    
    LoggerService logger = new LoggerService();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	productService.initProductList(request);

	logger.write(request);
	response.sendRedirect("index.jsp");
    }

}
