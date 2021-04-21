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

import Controller.InventoryContraller;



@Path("/InventoryServiceManagement")
public class InventoryService {
	
	InventoryContraller inventory = new InventoryContraller();
	
	
	@GET
	@Path("/getItems") 
	@Produces(MediaType.TEXT_HTML) 
	public String getItems() 
	{ 
		
		return  inventory.getItems();
	} 

	
	
	@POST
	@Path("/addProduct") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String AddProduct(String inventoryData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject InventoryObject = new JsonParser().parse(inventoryData).getAsJsonObject(); 
		//Read the values from the JSON object
		 String productname = InventoryObject.get("productname").getAsString(); 
		 String description = InventoryObject.get("description").getAsString(); 
		 String size = InventoryObject.get("size").getAsString(); 
		 int price = InventoryObject.get("price").getAsInt();
		 
		
		 
		
		 

		
		 String output=inventory.InsertProducts(productname, description, size, price);;
	return output; 
	}
	
	
	
	
	
	
	@PUT
	@Path("/UpdateProduct") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String UpdateProduct(String inventoryData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject InventoryObject = new JsonParser().parse(inventoryData).getAsJsonObject(); 
	//Read the values from the JSON object
	 String productname = InventoryObject.get("productname").getAsString(); 
	 String description = InventoryObject.get("description").getAsString(); 
	 String size = InventoryObject.get("size").getAsString(); 
	 String price = InventoryObject.get("price").getAsString();
	 String productid = InventoryObject.get("productid").getAsString();

	 String output = inventory.updateInventory(productid, productname, description, size, price);
	return output; 
	}
	
	
	
	@DELETE
	@Path("/DelInventory") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteInventory(String inventoryData) 
	{ 
	//Convert the input string to a JSON object 
	JsonObject InventoryObject = new JsonParser().parse(inventoryData).getAsJsonObject(); 
	 
	//Read the value from the element <itemID>
	 String productid = InventoryObject.get("productid").getAsString();
	
	 String output = inventory.deleteInventory(productid);
	return output; 
	}
}
