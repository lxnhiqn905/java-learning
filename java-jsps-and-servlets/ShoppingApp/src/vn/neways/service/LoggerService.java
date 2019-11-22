package vn.neways.service;

import javax.servlet.http.HttpServletRequest;

import vn.neways.enums.Enums;

public class LoggerService {
    
    public void write(HttpServletRequest request) {
	System.out.println("==========================================================");
	System.out.println("PRODUCT_LIST : " + request.getServletContext().getAttribute(Enums.PRODUCT_LIST.toString()));
	System.out.println("PRODUCT_LIST_CANBUY : " + request.getServletContext().getAttribute(Enums.PRODUCT_LIST_CANBUY.toString()));
	System.out.println("CART : " + request.getServletContext().getAttribute(Enums.CART.toString()));
	System.out.println("CART_USER : " + request.getSession().getAttribute(Enums.CART_USER.toString()));
	System.out.println("USER_MAP : " + request.getServletContext().getAttribute(Enums.USER_MAP.toString()));
	System.out.println("USER_LOGIN : " + request.getSession().getAttribute(Enums.USER_LOGIN.toString()));
	System.out.println("STATUS_LOGIN : " + request.getSession().getAttribute(Enums.STATUS_LOGIN.toString()));
	System.out.println("STATUS_SIGNUP : " + request.getSession().getAttribute(Enums.STATUS_SIGNUP.toString()));
	System.out.println("==========================================================");
    }

}
