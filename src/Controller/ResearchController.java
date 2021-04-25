package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResearchController {
	
	private Connection connect() 
	{ 
		Connection con = null; 
		try
		{ 
			Class.forName("com.mysql.jdbc.Driver"); 
 
			//Provide the correct details: DBServer/DBName, username, password 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pafprojtest?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root",""); 
		} 
		catch (Exception e) 
		{e.printStackTrace();} 
		return con; 
	} 
	
	public String readResearch() 
	{ 
		 String output = ""; 
		 
		 try
		 { 
			 Connection con = connect(); 
		 
			 if (con == null) 
			 {return "Error while connecting to the database for reading."; } 
		 
			 // Prepare the html table to be displayed
			 output = "<table border='1'><tr><th>Research ID</th><th>Type</th><th>Description</th><th>Size</th><th>Framework</th><th>TimePeriod</th>"; 
		 
			 String query = "select * from research"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 
		 
			 // iterate through the rows in the result set
			 while (rs.next()) 
			 { 
				 int rid = rs.getInt("rid");
				 String type = rs.getString("type");
				 String description = rs.getString("description"); 
				 String size = rs.getString("size");
				 String framework = rs.getString("framework");
				 String timeperiod = rs.getString("timeperiod");
				 
				 // Add into the html table
				 output += "<tr><td>" + rid + "</td>"; 
				 output += "<td>" + type + "</td>"; 
				 output += "<td>" + description + "</td>"; 
				 output += "<td>" + size + "</td>"; 
				 output += "<td>" + framework + "</td>"; 
				 output += "<td>" + timeperiod + "</td>";
				  
				 // buttons
				 output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
						+ "<td><input name='btnDelete' type='submit' value='Delete' class='btn btn-danger'></td>"
						+ "<input name='payid' type='hidden' value='" + rid 
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

	
	public String Insertresearch(String type, String description, String size, String framework, String timeperiod) 
	{ 
		String output = ""; 
	
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{return "Error while connecting to the database for inserting."; } 
 
			// create a prepared statement
			String query = " insert into pafprojtest.research (`rid`,`type`,`description`,`size`,`framework`,`timeperiod`)"
					+ " values (?,?,?,?,?,?)"; 
 
			PreparedStatement preparedStmt = con.prepareStatement(query); 

			// binding values
			
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, type); 
			preparedStmt.setString(3, description); 
			preparedStmt.setString(4, size);
			preparedStmt.setString(5, framework);
			preparedStmt.setString(6, timeperiod);
			
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
	

	public String updateresearch(String rid,String type, String description, String size, String framework, String timeperiod)
	{ 
		 String output = ""; 
		 try
		 { 
			 	Connection con = connect(); 
		 
			 	if (con == null) 
			 	{return "Error while connecting to the database for updating."; } 
		 
			 	// create a prepared statement
			 	String query = "UPDATE research SET type=?,description=?,size=?,framework=?,timeperiod=? WHERE rid =?"; 
		 
			 	PreparedStatement preparedStmt = con.prepareStatement(query); 
		 
			 	// binding values
			 	preparedStmt.setString(1, type); 
			 	preparedStmt.setString(2, description); 			 	
			 	preparedStmt.setString(3, size); 
			 	preparedStmt.setString(4, framework);
			 	preparedStmt.setString(5, timeperiod);
			 	
			 	preparedStmt.setInt(6, Integer.parseInt(rid)); 
			
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
	
	public String deletePayment(String rid) 
	 { 
		String output = ""; 
	 
		try
		{ 
			Connection con = connect(); 
			if (con == null) 
			{return "Error while connecting to the database for deleting."; } 
	 
			// create a prepared statement
			String query = "delete from research where rid=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			
			
	 
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(rid)); 
	 
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
