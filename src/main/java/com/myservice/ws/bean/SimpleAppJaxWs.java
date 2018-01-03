package com.myservice.ws.bean;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.myservice.ws.util.User;
import com.myservice.ws.util.UsersGetter;

@RequestScoped
@Path("/result")
public class SimpleAppJaxWs {
	
	private static final Logger log = Logger.getLogger(SimpleAppJaxWs.class.getName());
	
	@GET()
	@Produces("application/json")
	public HashMap<String,String> getName() {
		HashMap<String, String> names = new HashMap<String, String>();
		User user = UsersGetter.getUser();
		if (user != null) {
			names.put("firstName", user.getFirstName());
			names.put("lastName", user.getLastName());
		}
		else {
			names.put("name", "Willi Brant");
		}
		log.info("well, that worked nicely :)");
		return names;
	}

}
