package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstitemtype;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/mstitemtype")
public interface MstitemtypeManager extends GenericManager<Mstitemtype, String> {
    
	@GET
    public List<Mstitemtype> getAll();
	
	@POST
    @Path("getAllSearch/{q}")
	public List<Mstitemtype> getallsearch(@PathParam("q")String q);
	
	@POST
	@Path("getcode/{category}")
    public List<String> getAllId(@PathParam("category")String category);
	
	@POST
	@Path("getAllq/{category}/{q}")
    public List<Mstitemtype> getAll(@PathParam("category")String category,@PathParam("q")String q);
	
	@POST
	@Path("getAll/{category}")
    public List<Mstitemtype> getAll(@PathParam("category")String category);
	
	@POST
    @Path("getItems")
	public List<Mstitemtype> getItems();
	
}