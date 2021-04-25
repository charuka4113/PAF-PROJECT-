package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


//@ Author Ushan Wijekoon

public class UserController {
	
	private Connection connect() 
	{ 
		Connection con = null; 
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
 
			//Provide the correct details: DBServer/DBName, username, password 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pafprojtest", "root", "root"); 
		} 
		catch (Exception e) 
		{e.printStackTrace();} 
		return con; 
	} 
	
	public String readUsers() 
	{ 
		 String output = ""; 
		 
		 try
		 { 
			 Connection con = connect(); 
		 
			 if (con == null) 
			 {return "Error while connecting to the database for reading."; } 
		 
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>User ID</th><th>Name</th><th>Age</th><th>Phone Number</th><th>Address</th><th>Email</th><th>Password</th><th>Category</th></tr>"; 
		 
			 String query = "select * from user"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 
		 
			 // iterate through the rows in the result set
			 while (rs.next()) 
			 { 
				 int userid = rs.getInt("userid");
				 String fname = rs.getString("fname");
				 String lname = rs.getString("lname"); 
				 int age = rs.getInt("age");
				 String pnumber = rs.getString("pnumber");
				 String address = rs.getString("address");
				 String email = rs.getString("email");
				 String password = rs.getString("password");
				 String category = rs.getString("category");
				 // Add into the html table
				 output += "<tr><td>" + userid + "</td>"; 
				 output += "<td>" + fname+lname + "</td>"; 
				 output += "<td>" + age + "</td>"; 
				 output += "<td>" + pnumber + "</td>"; 
				 output += "<td>" + address + "</td>"; 
				 output += "<td>" + email + "</td>"; 
				 output += "<td>" + password + "</td>"; 
				 output += "<td>" + category + "</td>"; 
				 // buttons
				 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><input name='btnDelete' type='submit' value='Delete' class='btn btn-danger'></td>"
						+ "<input name='userid' type='hidden' value='" + userid 
						+ "'>" + "</form></td></tr>"; 
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
	
	public String addUser(String fname, String lname,int age, String pnumber, String address,String email,String password,String category) 
	{ 
		String output = ""; 
	
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{return "Error while connecting to the database for inserting."; } 
 
			// create a prepared statement
			String query = " insert into pafprojtest.user (`userid`,`fname`,`lname`,`age`,`pnumber`,`address`,`email`,`password`,`category`)"
					+ " values (?,?,?,?,?,?,?,?,?)"; 
 
			PreparedStatement preparedStmt = con.prepareStatement(query); 

			// binding values
			
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, fname); 
			preparedStmt.setString(3, lname); 
			preparedStmt.setInt(4, age);
			preparedStmt.setString(5, pnumber);
			preparedStmt.setString(6, address);
			preparedStmt.setString(7, email);
			preparedStmt.setString(8, password);
			preparedStmt.setString(9, category);
			// execute the statement
			preparedStmt.execute(); 
			 con.close(); 
			 
			 output = "User Added Successfully!"; 
		} 
		catch (Exception e) 
		{ 
			 output = "Error while inserting the item."; 
			 System.err.println(e.getMessage()); 
		} 
			 
		return output; 
	}
	
	public String editUser(String userid, String fname, String lname, int age, String pnumber, String address,String email,String password,String category)
	{ 
		 String output = ""; 
		 try
		 { 
			 	Connection con = connect(); 
		 
			 	if (con == null) 
			 	{return "Error while connecting to the database for updating."; } 
		 
			 	// create a prepared statement
			 	String query = "UPDATE user SET fname=?,lname=?,age=?,pnumber=?,address=?,email=?,password=?,category=? WHERE userid =?"; 
		 
			 	PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
			 	// binding values
			 	preparedStmt.setString(1, fname); 
			 	preparedStmt.setString(2, lname); 
			 	preparedStmt.setInt(3, age); 
			 	preparedStmt.setString(4, pnumber); 
			 	preparedStmt.setString(5, address); 
			 	preparedStmt.setString(6, email); 
			 	preparedStmt.setString(7, password); 
			 	preparedStmt.setString(8, category); 
			 	preparedStmt.setInt(9, Integer.parseInt(userid)); 
			
			 	// execute the statement
			 	preparedStmt.execute(); 
			 	con.close(); 
			 	output = "User has been Edited successfully"; 
		 } 
		 catch (Exception e) 
		 { 
			 	output = "Error while updating the item."; 
			 	System.err.println(e.getMessage()); 
		 } 
		 
		 return output; 
		 
	}
	
	public String deleteUser(String userid) 
	 { 
		String output = ""; 
	 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{return "Error while connecting to the database for deleting."; } 
	 
			// create a prepared statement
			String query = "delete from user where userid=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			
			
	 
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(userid)); 
	 
			// execute the statement
			preparedStmt.execute(); 
			con.close(); 
	 
			output = "Deleted successfully"; 
	 } 
	 catch (Exception e) 
	 { 
		 output = "Error while deleting the item."; 
		 System.err.println(e.getMessage()); 
	 } 
		
	 return output;
	 
	 } 

}
