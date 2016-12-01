package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstcurrency;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("mstcurrency")
public interface MstcurrencyManager extends GenericManager<Mstcurrency, String> {
   
	
	@POST
	@Path("getAll/{id}")
    @Override
    public Mstcurrency get(@PathParam("id")String id);
    
    @GET
    @Override
    public List<Mstcurrency> getAll();
    
    @POST
    @Path("getcode")
    public List<String> getAllid();
    
    @POST
    @Path("getAllq/{Query}")
    public List<Mstcurrency> getAll(@PathParam("Query")String Query);
    
    
}