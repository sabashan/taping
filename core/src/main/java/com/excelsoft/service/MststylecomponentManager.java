package com.excelsoft.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.excelsoft.model.Mststylecomponent;
import com.excelsoft.model.MststylecomponentId;
import com.excelsoft.model.Mststyleheader;

@WebService
@Path("/stylecomponent")
public interface MststylecomponentManager extends
		GenericManager<Mststylecomponent, MststylecomponentId> {
	@GET
	public List< Mststylecomponent>getAll();
	
	
	public Mststylecomponent get(MststylecomponentId id);
	
	@POST
	@Path("getbyparamid/{location}/{buyer}/{department}/{style}/{company}/{componentId}")
	public Mststylecomponent getbyparamid(@PathParam("location")String location,
			@PathParam("buyer")String buyer, @PathParam("department")String department, @PathParam("style")String style,@PathParam("company")String company,@PathParam("componentId") String componentId);
	
	public List<Mststylecomponent> getAll(Mststyleheader mststyleheader);
	
	@POST
	@Path("getbyId/{location}/{buyer}/{department}/{style}/{company}")
	public List<String> getAllStrings(@PathParam("location")String location,
			@PathParam("buyer")String buyer, @PathParam("department")String department, @PathParam("style")String style,@PathParam("company")String company);
	
	@POST
	@Path("getbyAllId/{location}/{buyer}/{department}/{style}/{company}/{query}")
	public List<Mststylecomponent> getAll(@PathParam("location")String location,
			@PathParam("buyer")String buyer, @PathParam("department")String department, @PathParam("style")String style,@PathParam("company")String company,@PathParam("query")String query);
	
	@POST
	@Path("getcode")
	public List<String> getcode();
	
	

}