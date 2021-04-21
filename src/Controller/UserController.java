package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Model.Users;

public class UserController {
	
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
	
	public String userRegister(Users user) 
	{ 
		String output = ""; 
	
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{return "Error while connecting to the database for inserting."; } 
 
			// create a prepared statement
			String query = " insert into pafprojtest.user (`userid`,`fname`,`lname`,`age`,`pnumber`,`address`,`username`,`password`,`type`)"
					+ " values (?,?,?,?,?,?,?,?,?)"; 
 
			PreparedStatement preparedStmt = con.prepareStatement(query); 

			// binding values
			
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, user.getFname()); 
			preparedStmt.setString(3, user.getLname()); 
			preparedStmt.setInt(4, user.getAge());
			preparedStmt.setString(5, user.getPnumber());
			preparedStmt.setString(6, user.getAddress());
			preparedStmt.setString(7, user.getFname()+"@GB.lk");
			preparedStmt.setString(8, user.getPassword());
			preparedStmt.setString(9, user.getType());
			// execute the statement
			preparedStmt.execute(); 
			 con.close(); 
			 
			 output = "Inserted successfully"; 
		} 
		catch (Exception e) 
		{ 
			 output = "Error while inserting the item."; 
			 System.err.println(e.getMessage()); 
		} 
			 
		return output; 
	}
	
	public String updateUser(String userid, String fname, String lname, String age, String pnumber, String address,String password,String type)
	{ 
		 String output = ""; 
		 try
		 { 
			 	Connection con = connect(); 
		 
			 	if (con == null) 
			 	{return "Error while connecting to the database for updating."; } 
		 
			 	// create a prepared statement
			 	String query = "UPDATE user SET fname=?,lname=?,age=?,pnumber=?,address=?,username=?,password=?,type=? WHERE userid =?"; 
		 
			 	PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
			 	// binding values
			 	preparedStmt.setString(1, fname); 
			 	preparedStmt.setString(2, lname); 
			 	preparedStmt.setInt(3, Integer.parseInt(age)); 
			 	preparedStmt.setString(4, pnumber); 
			 	preparedStmt.setString(5, address); 
			 	preparedStmt.setString(6, fname+"@GB.com"); 
			 	preparedStmt.setString(7, password); 
			 	preparedStmt.setString(8, type); 
			 	preparedStmt.setInt(9, Integer.parseInt(userid)); 
			
			 	// execute the statement
			 	preparedStmt.execute(); 
			 	con.close(); 
			 	output = "Updated successfully"; 
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
