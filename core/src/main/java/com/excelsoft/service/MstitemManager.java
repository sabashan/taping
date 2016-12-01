package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstitem;
import com.excelsoft.model.MstitemId;










import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("mstitem")
public interface MstitemManager extends GenericManager<Mstitem, MstitemId> {
    
	@GET
	public List<Mstitem> getAll();	

	public Mstitem get(MstitemId id);
	
	@POST
	@Path("getById/{itemType}/{itemCode}")
	public Mstitem get(@PathParam("itemType")String itemType,@PathParam("itemCode") String itemCode);
	
	@POST
	@Path("getcode/{itemType}")
	public List<String> getAllid(@PathParam("itemType")String ItemType);
	
	@POST
	@Path("getAll/{itemType}")
	public List<Mstitem> getAll(@PathParam("itemType")String ItemType);
	
	@POST
	@Path("getAllq/{itemType}/{q}")
	public List<Mstitem> getAll(@PathParam("itemType")String ItemType,@PathParam("q")String q);
	
}