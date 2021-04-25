package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;




public class InventoryContraller {
	
	
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
	
	
	public String getItems() 

	{ 
		 String output = ""; 
		 
		 try
		 { 
			 Connection con = connect(); 
		 
			 if (con == null) 
			 {return "Error while connecting to the database for reading."; } 
		 
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>User ProductID</th><th>ProductName</th><th>Description</th><th>Size</th><th>Price</th></tr>"; 
		 
			 String query = "select * from inventory"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 
		 
			 // iterate through the rows in the result set
			 while (rs.next()) 
			 { 
				 int productid = rs.getInt("productid");
				 String productname = rs.getString("productname");
				 String description = rs.getString("description"); 
				 String size = rs.getString("size");
				 int price = rs.getInt("price");
				 
				 // Add into the html table
				 output += "<tr><td>" + productid + "</td>"; 
				 output += "<td>" + productname+"</td>"; 
				 output += "<td>" + description + "</td>"; 
				 output += "<td>" + size + "</td>"; 
				 output += "<td>" + price + "</td>"; 
				
				 // buttons
				 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><input name='btnDelete' type='submit' value='Delete' class='btn btn-danger'></td>"
						+ "<input name='userid' type='hidden' value='" + productid 
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

	
	public String InsertProducts( String productname, String description, String size, int price) 
	{ 
		String output = ""; 
	
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{return "Error while connecting to the database for inserting."; } 
 
			// create a prepared statement
			String query = " insert into pafprojtest.inventory (`productid`,`productname`,`description`,`size`,`price`)"
					+ " values (?,?,?,?,?)"; 
 
			PreparedStatement preparedStmt = con.prepareStatement(query); 

			// binding values
			
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, productname); 
			preparedStmt.setString(3, description ); 
			preparedStmt.setString(4,size);
			preparedStmt.setInt(5, price);
			
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
	
	public String updateInventory(String productid,String productname, String description, String size, String price)
	{ 
		 String output = ""; 
		 try
		 { 
			 	Connection con = connect(); 
		 
			 	if (con == null) 
			 	{return "Error while connecting to the database for updating."; } 
		 
			 	// create a prepared statement
			 	String query = "UPDATE inventory SET  productname=?,description=?,size=?,price=? WHERE productid =?"; 
		 
			 	PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
			 	// binding values
			 	preparedStmt.setString(1, productname); 
			 	preparedStmt.setString(2, description); 
			 	preparedStmt.setString(3, size); 
			 	preparedStmt.setInt(4, Integer.parseInt(price)); 
			 	preparedStmt.setInt(5, Integer.parseInt(productid)); 
			 	 
			
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
	
	public String deleteInventory(String productid) 
	 { 
		String output = ""; 
	 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{return "Error while connecting to the database for deleting."; } 
	 
			// create a prepared statement
			String query = "delete from inventory where productid=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			
			
	 
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(productid)); 
	 
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
