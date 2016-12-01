package com.excelsoft.service;

import java.util.List;
import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Merordersheethdr;
import com.excelsoft.model.MerordersheethdrId;
import com.excelsoft.model.Mststyleheader;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("merordersheethdr")
public interface MerordersheethdrManager extends GenericManager<Merordersheethdr, MerordersheethdrId> {
	
	
	@GET
	public List<Merordersheethdr> getAll();
		
	@POST
	@Path("GetByid/{custCode}/{locationCode}/{depCode}/{styleId}/{compCode}/{season}")
	public List<String> get(@PathParam("custCode")String custCode,
			@PathParam("locationCode")String locationCode,@PathParam("depCode")String depCode,
			@PathParam("styleId") String styleId, @PathParam("compCode")String compCode, @PathParam("season")String season);
	
	@POST
	@Path("getAll/{compCode}/{locationCode}/{custCode}/{depCode}/{styleId}/{season}/{query}")
	public List<Merordersheethdr> getAll(@PathParam("compCode")String compCode, 
			@PathParam("locationCode")String locationCode, @PathParam("custCode")String custCode,
			@PathParam("depCode")String depCode, @PathParam("styleId")String styleId, @PathParam("season")String season,
			@PathParam("query")String query);

    public List<Merordersheethdr> getAll(String query,Mststyleheader mststyleheader);
	
	public List<Merordersheethdr> getAll(String query,Mststyleheader mststyleheader,Boolean isProcess);
	
	public List<Merordersheethdr> getAll(String query,String status);
	
	public List<Merordersheethdr> getAll(String query,String status,String userid);
	
	public List<Merordersheethdr> getAll(String query,String status,String userid,Boolean isProcess);
}