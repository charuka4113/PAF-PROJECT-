package Model;

public class Inventory {
	
	private int productid;
	private String productname;
	private String description;
	private String size;
	private int price;
	
	
	public Inventory(int productid, String productname, String description, String size, int price) {
		super();
		this.productid = productid;
		this.productname = productname;
		this.description = description;
		this.size = size;
		this.price = price;
	}


	public Inventory(String productname, String description, String size, int price) {
		super();
		this.productname = productname;
		this.description = description;
		this.size = size;
		this.price = price;
	}


	public int getProductid() {
		return productid;
	}


	public void setProductid(int productid) {
		this.productid = productid;
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
	
	
	
	
	
}
