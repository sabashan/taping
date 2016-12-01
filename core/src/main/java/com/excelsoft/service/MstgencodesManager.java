package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstgencodes;
import com.excelsoft.model.MstgencodesId;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/gencodes")
public interface MstgencodesManager extends GenericManager<Mstgencodes, MstgencodesId> {
		
		@GET
	    List<Mstgencodes> getAllGencodes();

		@POST
	    @Path("{id}")
	    Mstgencodes getMstgencode(@PathParam("id") MstgencodesId id);
	 
	    @POST
	    @Path("id/{code}/{type}")
	    public Mstgencodes findByid(@PathParam("code")String code,@PathParam("type") String type);
	    
	    @POST
	    @Path("type_id/{type}")
	 	public  List<Mstgencodes> findByType(@PathParam("type")String type);
	    
	    @POST
	    @Path("getcode/{type}")
	 	public  List<String> getcode(@PathParam("type")String type);
	    
	    @POST
	    @Path("type_idlike/{type}/{lcode}")
	 	public  List<Mstgencodes> type_idlike(@PathParam("type")String type,@PathParam("lcode")String lcode);
	    
	    @POST
	    @Path("code_id/{code}")
	 	public  List<Mstgencodes> findBycode(@PathParam("code")String code);
}