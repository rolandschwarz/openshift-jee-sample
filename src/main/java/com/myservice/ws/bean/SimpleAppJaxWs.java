package com.myservice.ws.bean;

import java.util.HashMap;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@RequestScoped
@Path("/result")
public class SimpleAppJaxWs {
	
	@GET()
	@Produces("application/json")
	public HashMap<String,String> getName() {
		HashMap<String, String> names = new HashMap<String, String>();
		names.put("name", "Willi Brant");
		return names;
	}

}
