package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstcompany;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/mstcompany")
public interface MstcompanyManager extends GenericManager<Mstcompany, String> {
	
	@GET
	public List< Mstcompany>getAll();
	
	@POST
	@Path("getcompany/{id}")
	public Mstcompany get(@PathParam("id")String id);
	
	
	@POST
	@Path("getcode")
	public List< String>  getCompanycode();
	
	@POST
	@Path("getAllbyquery/{query}")
	public List< Mstcompany> getAllbyquery(@PathParam("query")String query);
    
}