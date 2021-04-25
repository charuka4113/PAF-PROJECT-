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

import Controller.CartController;
import Controller.UserController;
import Controller.ValidateUser;
import Model.ShoppingCart;
import Model.Users;

@Path("/CartManagement")

public class CartService {
	
	CartController cart = new CartController();


	@GET
	@Path("/getItems") 
	@Produces(MediaType.TEXT_HTML) 
	public String getCartItems() 
	{ 
		return cart.readCart();
	} 
	
	
	//http://localhost:8080/GB/GBService/CartManagement/addCartProduct

	@POST
	@Path("/addCartProduct") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String AddCartProduct(String cartData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject cartObject = new JsonParser().parse(cartData).getAsJsonObject(); 
		//Read the values from the JSON object
		 String productname = cartObject.get("productname").getAsString(); 
		 String description = cartObject.get("description").getAsString(); 
		 String size = cartObject.get("size").getAsString(); 
		 int price = cartObject.get("price").getAsInt();
		String type = cartObject.get("type").getAsString();

		 
		 String output=cart.InsertProducts(productname, description, size, price, type);
	return output; 
	}
	
	
	
	
	
	@PUT
	@Path("/UpdateCart") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String UpdateCartItems(String cartData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject cartObject = new JsonParser().parse(cartData).getAsJsonObject(); 
	//Read the values from the JSON object
	 String productname = cartObject.get("productname").getAsString(); 
	 String description = cartObject.get("description").getAsString(); 
	 String size = cartObject.get("size").getAsString(); 
	 String price = cartObject.get("price").getAsString();
	 String type = cartObject.get("type").getAsString();

	 String cartid = cartObject.get("cartid").getAsString();

	 String output = cart.updateInventory(cartid, productname, description, size, price, type); //ERRRors
	return output; 
	}
	
	

	@DELETE
	@Path("/Delete") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteInventory(String cartData) 
	{ 
	//Convert the input string to a JSON object 
	JsonObject InventoryObject = new JsonParser().parse(cartData).getAsJsonObject(); 
	 
	//Read the value from the element <itemID>
	 String productid = InventoryObject.get("cartid").getAsString();
	
	 String output = cart.delete(productid);
	return output; 
	}

}
