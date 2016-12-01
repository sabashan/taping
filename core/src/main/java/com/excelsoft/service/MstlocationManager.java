package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstlocation;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/mstlocations")
public interface MstlocationManager extends GenericManager<Mstlocation, String> {
    
	@GET
    public List<Mstlocation>getAll();
    
    @POST
    @Path("getByid/{Id}")
    public Mstlocation get(@PathParam("Id")String Id);
    
    @POST
    @Path("getcode")
    public List<String>getcode();
    
    @POST
    @Path("getcodeByquery/{query}")
    public List<Mstlocation> getallsearch(@PathParam("query")String query);
    
    @POST
    @Path("getByidfild/{Id}/{field}")
    public Object get(@PathParam("Id")String Id,@PathParam("field")String field);
}