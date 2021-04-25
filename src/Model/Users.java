package Model;

//@ Author Ushan Wijekoon(IT19109718)
public class Users {
	
	private int userid;
	private String fname;
	private String lname;
	private int age;
	private String pnumber;
	private String address;
	public String email;
	private String password;
	private String category;


	public Users(int userid, String fname, String lname, int age, String pnumber, String address, String email,
			String password, String category) {
		super();
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.pnumber = pnumber;
		this.address = address;
		this.email = email;
		this.password = password;
		this.category = category;
	}


	public Users(String fname, String lname, int age, String pnumber, String address, String email, String password,
			String category) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.pnumber = pnumber;
		this.address = address;
		this.email = email;
		this.password = password;
		this.category = category;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getPnumber() {
		return pnumber;
	}


	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	
	
	
	
	
}
