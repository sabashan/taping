package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstmachinetype;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/mstmachinetype")
public interface MstmachinetypeManager extends GenericManager<Mstmachinetype, String> {
    
	@GET
	public List<Mstmachinetype> getAll();
	
	@POST
	@Path("getbyid/{id}")
	public Mstmachinetype get(@PathParam("id")String id);
	
	@POST
	@Path("getmachintype/{queary}")
	public List<Mstmachinetype> getmachintype(@PathParam("queary")String queary);
	
	@POST
	@Path("getcode")
	public List<String> getmachintype();
}