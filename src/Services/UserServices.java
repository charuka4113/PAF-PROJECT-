package Services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import Controller.UserController;
import Controller.ValidateUser;
import Model.Users;

@Path("/UserManagementService") 
public class UserServices {
	
	
	ValidateUser userValidate = new ValidateUser();
	UserController userController = new UserController();

	@GET
	@Path("/readUsers") 
	@Produces(MediaType.TEXT_HTML) 
	public String readUser() 
	{ 
		return userController.readUsers(); 
	} 
	
	
	@POST
	@Path("/AddUser") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String userRegister(String userData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject(); 
		//Read the values from the JSON object
		 String fname = userObject.get("fname").getAsString(); 
		 String lname = userObject.get("lname").getAsString(); 
		 int age = userObject.get("age").getAsInt(); 
		 String pnumber = userObject.get("pnumber").getAsString();
		 String address = userObject.get("address").getAsString();
		 String email = userObject.get("email").getAsString();
		 String password = userObject.get("password").getAsString(); 
		 String category = userObject.get("category").getAsString();

		 

		 
		 String output = userController.addUser(fname, lname, age, pnumber, address, email, password, category);
	return output; 
	}
	
	@PUT
	@Path("/UpdateUser") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateUser(String userData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject(); 
	//Read the values from the JSON object
	 String userid = userObject.get("userid").getAsString(); 
	 String fname = userObject.get("fname").getAsString(); 
	 String lname = userObject.get("lname").getAsString(); 
	 String age = userObject.get("age").getAsString(); 
	 String pnumber = userObject.get("pnumber").getAsString();
	 String address = userObject.get("address").getAsString(); 
	 String type = userObject.get("type").getAsString();
	 String password = userObject.get("password").getAsString(); 

	 String output = userController.updateUser(userid, fname, lname, age, pnumber, address, password,type);
	return output;
	}

	
	@DELETE
	@Path("/DeactivateUser") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteUser(String userData) 
	{ 
	//Convert the input string to a JSON object 
	JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject(); 
	 
	//Read the value from the element <itemID>
	 String userID = userObject.get("userid").getAsString();
	
	 String output = userController.deleteUser(userID);
	return output; 
	}

	@GET
	@Path("/ValidateUser") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_HTML) 
	public String validateUser(String userData) 
	{ 
	
		JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject(); 
		 
		//Read the value from the element <itemID>
		 String username = userObject.get("username").getAsString();
		 String password = userObject.get("password").getAsString();
		
		 String output = userValidate.validateUser(username, password);
		 

		
		return output;
	} 
	
	@GET
	@Path("/Login") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_HTML) 
	public String userLogin(String userData) 
	{ 
	
		JsonObject userObject = new JsonParser().parse(userData).getAsJsonObject(); 
		 
		//Read the value from the element <itemID>
		 String username = userObject.get("username").getAsString();
		 String password = userObject.get("password").getAsString();
		
		 String output = userValidate.validateUser(username, password);
		 

		
		return output;
	} 
	
	

}
