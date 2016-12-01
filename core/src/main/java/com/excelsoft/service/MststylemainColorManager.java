package com.excelsoft.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststylemainColor;
import com.excelsoft.model.MststylemainColorId;

@WebService
@Path("/stylemainColor")
public interface MststylemainColorManager extends
		GenericManager<MststylemainColor, MststylemainColorId> {
	
	@GET
	public List< MststylemainColor>getAll();
	
	
	public MststylemainColor get(MststylemainColorId mststylemainColorId);
	
	
	public List<MststylemainColor> getAll(Mststyleheader mststyleheader);
	
	@POST
	@Path("getbyId/{location}/{buyer}/{department}/{style}/{company}")
	public List<String> getAllStrings(@PathParam("location")String location,
			@PathParam("buyer")String buyer, @PathParam("department")String department, @PathParam("style")String style,@PathParam("company")String company);
	
	
	@POST
	@Path("getAllbyId/{location}/{buyer}/{department}/{style}/{company}/{query}")
	public List<MststylemainColor> getAll(@PathParam("location")String location,
			@PathParam("buyer")String buyer, @PathParam("department")String department, @PathParam("style")String style,@PathParam("company")String company,@PathParam("query")String query);
	
	
	@POST
	@Path("getcode")
	public List<String> getcode();

}