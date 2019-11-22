package vn.neways.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import vn.neways.enums.Enums;

public class CartService {
    
    public void addCart(HttpServletRequest request, String productId) {
	UserService userService = new UserService();

	Map<String, List<String>> cart = getCart(request);
	String userLogin = userService.getUserLogin(request);

	if (cart == null) {
	    cart = new HashMap<>();
	}

	if (cart.containsKey(userLogin)) {
	    List<String> userCart = cart.get(userLogin);
	    if (userCart == null) {
		userCart = new ArrayList<String>();
	    }
	    userCart.add(productId);
	} else {
	    List<String> userCart = new ArrayList<String>();
	    userCart.add(productId);
	    cart.put(userLogin, userCart);
	}

	request.getServletContext().setAttribute(Enums.CART.toString(), cart);
	return;

    }

    public void viewcard(HttpServletRequest request) {
	UserService userService = new UserService();
	
	Map<String, List<String>> cart = getCart(request);
	String userLogin = userService.getUserLogin(request);
	request.getSession().setAttribute(Enums.CART_USER.toString(), cart == null ? null : cart.get(userLogin));
    }

    public void removecart(HttpServletRequest request, String productId) {
	ProductService productService = new ProductService();
	UserService userService = new UserService();
	
	Map<String, List<String>> cart = getCart(request);
	String userLogin = userService.getUserLogin(request);
	if (cart == null)
	    return;

	if (cart.get(userLogin) == null)
	    return;
	
	cart.get(userLogin).remove(productId);
	
	productService.canclebuy(request, productId);

    }

    public Map<String, List<String>> getCart(HttpServletRequest request) {
	return (Map<String, List<String>>) request.getServletContext().getAttribute(Enums.CART.toString());
    }

}
