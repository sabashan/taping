package com.excelsoft.service;

import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstsmvvoulmerates;
import com.excelsoft.model.MstsmvvoulmeratesId;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/mstsmvvoulmerates")
public interface MstsmvvoulmeratesManager extends GenericManager<Mstsmvvoulmerates, MstsmvvoulmeratesId> {
	
	@POST
	@Path("getsmvrate/{buyerCode}/{month}/{date}/{year}/{smvCode}/{Volume}")
	public List<Object> getAll(@PathParam("buyerCode")String buyerCode,@PathParam("month")String month,
			@PathParam("date")String date,@PathParam("year")String year,
			@PathParam("smvCode")String smvCode, @PathParam("Volume")String Volume);
	
	
	@GET
	public List<Mstsmvvoulmerates> getAll();
}