package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstoperation;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/mstoperation")
public interface MstoperationManager extends GenericManager<Mstoperation, Integer> {
	
	@GET
	public List<Mstoperation> getAll();
	
	@POST
	@Path("getbyType/{type}")
	 public List<Mstoperation> getAllByType(@PathParam("type")String type);
	
	@POST
	@Path("getbyTypeAnd/{type}/{Qary}")
	public List<Mstoperation> getAllByTypeAnd(@PathParam("type")String type,@PathParam("Qary")String Qary);
	
	@POST
	@Path("getcode")
	public List<String> getAllTypes();
	
	@POST
	@Path("getcode/{type}")
	public List<String> getAllTypes(@PathParam("type")String type);
}