package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ValidateUser {
	

	private Connection connect() 
	{ 
		Connection con = null; 
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
 
			//Provide the correct details: DBServer/DBName, username, password 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pafprojtest", "root", ""); 
		} 
		catch (Exception e) 
		{e.printStackTrace();} 
		return con; 
	} 
	
	public String validateUser(String username,String password) {
		
		 String output = ""; 
		 try
		 { 
			 	Connection con = connect(); 
			 	 
			 	
			 	
			 	// create a prepared statement
			 	String query = "SELECT * FROM USER WHERE username='"+username+"'AND password ='"+password+"'"; 
			 	
		 
			 	 Statement stmt = con.createStatement();
			 	 
				 ResultSet rs = stmt.executeQuery(query); 
					 
				 // iterate through the rows in the result set
				 if (rs.next()==true) 
				 { 
					 int userid = rs.getInt("userid");
					 String fname = rs.getString("fname");
					 String lname = rs.getString("lname"); 
					 int age = rs.getInt("age");
					 String pnumber = rs.getString("pnumber");
					 String address = rs.getString("address");
					 String username1 = rs.getString("username");
					 String password1 = rs.getString("password");
					 
					 output = "<table border='1'><tr><th>User ID</th><th>Name</th><th>Age</th><th>Phone Number</th><th>Address</th><th>User Name</th><th>Password</th></tr>";
					 
					 output+="Welcome "+fname+" "+lname+"!";
					 
					 output += "<tr><td>" + userid + "</td>"; 
					 output += "<td>" + fname+" "+lname + "</td>"; 
					 output += "<td>" + age + "</td>"; 
					 output += "<td>" + pnumber + "</td>"; 
					 output += "<td>" + address + "</td>"; 
					 output += "<td>" + username1 + "</td>"; 
					 output += "<td>" + password1 + "</td>"; 
			 
					 // buttons
					 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
							+ "<td><input name='btnDelete' type='submit' value='Delete' class='btn btn-danger'></td>"
							+ "<input name='userid' type='hidden' value='" + userid 
							+ "'>" + "</form></td></tr>"; 
			 } else {
				 output+="No user";
			 }
			 
	
			 
			con.close(); 
			 
			// Complete the html table
			 output += "</table>"; 
				 }
		catch (Exception e) 
		{ 
			 output = "Error while reading the items."; 
			 System.err.println(e.getMessage()); 
		} 
		 
		 
			 return output; 
	} 
	
}
