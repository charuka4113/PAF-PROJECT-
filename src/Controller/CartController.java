package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CartController {

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
	
	public String readCart() 
	{ 
		 String output = ""; 
		 
		 try
		 { 
			 Connection con = connect(); 
		 
			 if (con == null) 
			 {return "Error while connecting to the database for reading."; } 
		 
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Cart ID</th><th>Product Name</th><th>Description</th><th>Size</th><th>Price</th><th>Type</th></tr>"; 
		 
			 String query = "select * from shoppingcart"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 
		 
			 // iterate through the rows in the result set
			 while (rs.next()) 
			 { 
				 int cartid = rs.getInt("cartid");
				 String productname = rs.getString("productname");
				 String description = rs.getString("description"); 
				 String size = rs.getString("size");
				 int price = rs.getInt("price");
				 String type = rs.getString("type");
				
				 // Add into the html table
				 output += "<tr><td>" + cartid + "</td>"; 
				 output += "<td>" + productname + "</td>"; 
				 output += "<td>" + description + "</td>"; 
				 output += "<td>" + size + "</td>"; 
				 output += "<td>" + price + "</td>"; 
				 output += "<td>" + type + "</td>"; 
				 
				 // buttons
				 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><input name='btnDelete' type='submit' value='Delete' class='btn btn-danger'></td>"
						+ "<input name='userid' type='hidden' value='" + cartid 
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

	public String InsertProducts( String productname, String description, String size, int price, String type) 
	{ 
		String output = ""; 
	
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{return "Error while connecting to the database for inserting."; } 
 
			// create a prepared statement
			String query = " insert into pafprojtest.shoppingcart (`cartid`,`productname`,`description`,`size`,`price`,`type`)"
					+ " values (?,?,?,?,?,?)"; 
 
			PreparedStatement preparedStmt = con.prepareStatement(query); 

			// binding values
			
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, productname); 
			preparedStmt.setString(3, description ); 
			preparedStmt.setString(4,size);
			preparedStmt.setInt(5, price);
			preparedStmt.setString(6, type);
			
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
	
	public String updateInventory(String cartid,String productname, String description, String size, String price, String type)
	{ 
		 String output = ""; 
		 try
		 { 
			 	Connection con = connect(); 
		 
			 	if (con == null) 
			 	{return "Error while connecting to the database for updating."; } 
		 
			 	// create a prepared statement
			 	String query = "UPDATE shoppingcart SET  productname=?,description=?,size=?,price=?,type=? WHERE cartid =?"; 
		 
			 	PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
			 	// binding values
			 	preparedStmt.setString(1, productname); 
			 	preparedStmt.setString(2, description); 
			 	preparedStmt.setString(3, size); 
			 	preparedStmt.setInt(4, Integer.parseInt(price)); 
			 	preparedStmt.setString(5, type); 
			 	preparedStmt.setInt(6, Integer.parseInt(cartid)); 
			 	 
			
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
	
	public String delete(String cartid) 
	 { 
		String output = ""; 
	 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{return "Error while connecting to the database for deleting."; } 
	 
			// create a prepared statement
			String query = "delete from shoppingcart where cartid=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			
			
	 
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(cartid)); 
	 
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
