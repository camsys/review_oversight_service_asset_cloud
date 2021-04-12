package com.camsys.assetcloud.oversight.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.camsys.assetcloud.controller.BasePage;
import com.camsys.assetcloud.oversight.model.DatabaseDAO;
import com.camsys.assetcloud.oversight.model.Review;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/rest")
public class RestAPI extends BasePage {
		
	private final DatabaseDAO databaseDAO;
	
	private final ObjectMapper mapper = new ObjectMapper();

	public RestAPI(@Context SecurityContext sc) {
		databaseDAO = new DatabaseDAO(sc);
	}
	
	@GET
	@Path("/template/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Review> getAllTemplates(String data) throws Exception {
		return databaseDAO.getAllTemplates().stream()
			.collect(Collectors.toList());
	}

	@GET
	@Path("/template/put")
	@Produces(MediaType.APPLICATION_JSON)
	public Object putTemplate(String data) throws Exception {
		try {
			return null;
		
		} catch(Exception e) {
			e.printStackTrace();

			Map<String,Object> i = new HashMap<String, Object>();
			i.put("errors",  e.getMessage());
			return i;
		}
	}
}