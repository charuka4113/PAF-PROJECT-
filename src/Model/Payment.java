package Model;

public class Payment {
	
	private int payid;
	
	private String paydate;
	private String description;
	private int price;
	private String type;

	public Payment(int payid, String paydate, String description, int price, String type) {
		super();
		this.payid = payid;
		this.paydate = paydate;
		this.description = description;
		this.price = price;
		this.type = type;
	}

	public Payment(String paydate, String description, int price, String type) {
		super();
		this.paydate = paydate;
		this.description = description;
		this.price = price;
		this.type = type;
	}

	public int getPayid() {
		return payid;
	}

	public void setPayid(int payid) {
		this.payid = payid;
	}

	public String getPayDate() {
		return paydate;
	}

	public void setPayDate(String paydate) {
		this.paydate = paydate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
}
