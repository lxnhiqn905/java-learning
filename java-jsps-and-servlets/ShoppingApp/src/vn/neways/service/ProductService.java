package vn.neways.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import vn.neways.dto.Product;
import vn.neways.enums.Enums;

public class ProductService {
    
    public void initProductList(HttpServletRequest request) {
	List<Product> productList = getProductList(request);
	if (productList == null) {
	    productList = new ArrayList<>();
	    // Init list product
	    for (int i = 0; i < 10; i++) {
		productList.add(new Product(String.valueOf(i), "This is product name " + String.valueOf(i), false));
	    }
	    request.getServletContext().setAttribute(Enums.PRODUCT_LIST.toString(), productList);
	}
	
	request.getServletContext().setAttribute(Enums.PRODUCT_LIST_CANBUY.toString(),
		productList.stream().filter(Product::canBuy).collect(Collectors.toList()));

    }

    public void buy(HttpServletRequest request, String productId) {
	CartService cartService = new CartService();
	
	List<Product> productList = getProductList(request);
	productList.stream().filter(Product::canBuy).forEach(product -> {
	    if (product.getId().equals(productId)) {
		product.buy();
		cartService.addCart(request, product.getId());
	    }
	});
    }

    public void canclebuy(HttpServletRequest request, String productId) {
	List<Product> productList = getProductList(request);
	productList.stream().forEach(product -> {
	    if (product.getId().equals(productId)) {
		product.cancelbuy();
	    }
	});
    }

    public List<Product> getProductList(HttpServletRequest request) {
	return (List<Product>) request.getServletContext().getAttribute(Enums.PRODUCT_LIST.toString());
    }
}
