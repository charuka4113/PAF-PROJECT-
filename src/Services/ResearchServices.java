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

import Controller.PaymentController;
import Controller.ResearchController;
import Model.Payment;



@Path("/ResearchManagement")

public class ResearchServices {
	ResearchController research = new ResearchController();

	@GET
	@Path("/getResearch") 
	@Produces(MediaType.TEXT_HTML) 
	public String GetResearch() 
	{ 
		return research.readResearch();
	} 
	
	@POST
	@Path("/InsertResearch") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String AddPayment(String researchData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject ResearchObject = new JsonParser().parse(researchData).getAsJsonObject(); 
		//Read the values from the JSON object
		 String type = ResearchObject.get("type").getAsString(); 
		 String description = ResearchObject.get("description").getAsString(); 
		 String size = ResearchObject.get("size").getAsString(); 
		 String framework = ResearchObject.get("framework").getAsString();
		 String timeperiod = ResearchObject.get("timeperiod").getAsString();
		  
		 
		// Payment paymnet= new Payment(paydate,description,price,type);
		// payment.InsertPayment(paydate, description, price, type);

		String output = research.Insertresearch(type, description, size, framework, timeperiod);
		
	return output; 
	}
	
	@PUT
	@Path("/UpdateResearch") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateResearch(String researchData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject ResearchObject = new JsonParser().parse(researchData).getAsJsonObject(); 
	//Read the values from the JSON object
	 String rid = ResearchObject.get("rid").getAsString(); 
	 String type = ResearchObject.get("type").getAsString(); 
	 String description = ResearchObject.get("description").getAsString(); 
	 String size = ResearchObject.get("size").getAsString(); 
	 String framework = ResearchObject.get("framework").getAsString();
	 String timeperiod = ResearchObject.get("timeperiod").getAsString()
	 ; 

	 String output = research.updateresearch(rid, type, description, size, framework, timeperiod);
	return output; 
	}
	
	@DELETE
	@Path("/DeleteResearch") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteResearch(String researchData) 
	{ 
	//Convert the input string to a JSON object 
	JsonObject ResearchObject = new JsonParser().parse(researchData).getAsJsonObject(); 
	 
	//Read the value from the element <itemID>
	 String rid = ResearchObject.get("rid").getAsString();
	
	 String output = research.deletePayment(rid);
	return output; 
	}

}
