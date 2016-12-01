package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstcustomer;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/mstcustomer")
public interface MstcustomerManager extends GenericManager<Mstcustomer, String> {
    
	@GET
	public List< Mstcustomer> getAll();
	
	@POST
	@Path("getcustomer/{id}")
    public Mstcustomer get(@PathParam("{id}")String id);
	
	@POST
	@Path("getcode")
    public List<String> getCustomerCode();
	
	@POST
	@Path("getcustomerq/{query}")
    public List<Mstcustomer> getCustomerCodeq(@PathParam("query") String query);
}