package Model;

public class Users {
	
	private int userid;
	private String fname;
	private String lname;
	private int age;
	private String pnumber;
	private String address;
	private String password;
	private String type;


	public Users(int userid, String fname, String lname, int age, String pnumber, String address, String password, String type) {
		super();
		this.userid = userid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.pnumber = pnumber;
		this.address = address;
		this.password = password;
		this.type = type;
	}

	
	
	public Users(String fname, String lname, int age, String pnumber, String address, String password, String type) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.pnumber = pnumber;
		this.address = address;
		this.password = password;
		this.type = type;
	}



	public Users() {
		super();
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public int getUserid() {
		return userid;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public int getAge() {
		return age;
	}

	public String getPnumber() {
		return pnumber;
	}

	public String getAddress() {
		return address;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	
	
}
