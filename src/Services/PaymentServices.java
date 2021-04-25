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
import Model.Payment;



@Path("/PaymentServiceManagement")

public class PaymentServices {
	
	PaymentController payment = new PaymentController();

	@GET
	@Path("/getPayment") 
	@Produces(MediaType.TEXT_HTML) 
	public String GetPayment() 
	{ 
		return payment.readPayment(); 
	} 
	
	@POST
	@Path("/InsertPayment") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String AddPayment(String paymentData) 
	{ 
		//Convert the input string to a JSON object 
		 JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject(); 
		//Read the values from the JSON object
		 String paydate = paymentObject.get("paydate").getAsString(); 
		 String description = paymentObject.get("description").getAsString(); 
		 int price = paymentObject.get("price").getAsInt(); 
		 String type = paymentObject.get("type").getAsString();
		  
		 
		// Payment paymnet= new Payment(paydate,description,price,type);
		// payment.InsertPayment(paydate, description, price, type);

		String output = payment.InsertPayment(paydate, description, price, type);
		
	return output; 
	}
	
	@PUT
	@Path("/UpdatePayment") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updatePayment(String paymentData) 
	{ 
	//Convert the input string to a JSON object 
	 JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject(); 
	//Read the values from the JSON object
	 String payid = paymentObject.get("payid").getAsString(); 
	 String paydate = paymentObject.get("paydate").getAsString(); 
	 String description = paymentObject.get("description").getAsString(); 
	 String price = paymentObject.get("price").getAsString(); 
	 String type = paymentObject.get("type").getAsString();
	 ; 

	 String output = payment.updatePayment(payid, paydate, description, price, type);
	return output; 
	}
	
	@DELETE
	@Path("/DeletePayment") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deletePayment(String paymentData) 
	{ 
	//Convert the input string to a JSON object 
	JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject(); 
	 
	//Read the value from the element <itemID>
	 String payid = paymentObject.get("payid").getAsString();
	
	 String output = payment.deletePayment(payid);
	return output; 
	}

	
}
