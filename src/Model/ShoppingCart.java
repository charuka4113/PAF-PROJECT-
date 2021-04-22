package Model;

public class ShoppingCart {

	private int cartid;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ShoppingCart(String productname, String description, String size, int price, String type) {
		super();
		this.productname = productname;
		this.description = description;
		this.size = size;
		this.price = price;
		this.type = type;
	}
	public ShoppingCart(int cartid, String productname, String description, String size, int price, String type) {
		super();
		this.cartid = cartid;
		this.productname = productname;
		this.description = description;
		this.size = size;
		this.price = price;
		this.type = type;
	}
	private String productname;
	private String description;
	private String size;
	private int price;
	private String type;
	
	
}
