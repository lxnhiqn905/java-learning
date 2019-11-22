package vn.neways.dto;

public class Product {
	
	public Product(String pId, String pName, boolean pSellFlg) {
		this.pId = pId;
		this.pName = pName;
		this.pSellFlg = pSellFlg;
	}
	
	private String pId;
	private String pName;
	private boolean pSellFlg;
	
	public String getInfo() {
		return pId + "-" + pName;
	}
	
	public boolean canBuy() {
	    return !pSellFlg;
	}
	
	public void buy() {
	    this.pSellFlg = true;
	}
	
	public void cancelbuy() {
	    this.pSellFlg = false;
	}
	
	public String getId() {
	    return this.pId;
	}

}
