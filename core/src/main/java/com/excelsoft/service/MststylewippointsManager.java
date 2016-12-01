package com.excelsoft.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.excelsoft.model.Mststylewippoints;

@WebService
@Path("/mststylewippoints")
public interface MststylewippointsManager extends GenericManager<Mststylewippoints, String> {

	@GET
	public List<Mststylewippoints> getAll();
	
	@POST
	@Path("getWipPointById/{wippointCode}")
	public Mststylewippoints getWipPointById(@PathParam("wippointCode")String wippointCode);
	
	@POST
	@Path("getAllActive")
	public List<Mststylewippoints> getAllActive();
}