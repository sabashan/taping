package com.excelsoft.service;

import java.util.Date;
import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstsmvrates;
import com.excelsoft.model.MstsmvratesId;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@WebService
@Path("/mstsmvrates")
public interface MstsmvratesManager extends GenericManager<Mstsmvrates, MstsmvratesId> {
	
	public Mstsmvrates get(MstsmvratesId id);
	
	public Mstsmvrates get(String buyerCode, String smvCode, Date fromDate,Date toDate );
	
	@POST
	@Path("get/{buyerCode}/{smvCode}/{tmonth}/{tdate}/{tyear}/{fmonth}/{fdate}/{fyear}")
	public Mstsmvrates get(@PathParam("buyerCode")String buyerCode,@PathParam("smvCode") String smvCode,
			@PathParam("tmonth")String tmonth,@PathParam("date")String tdate,@PathParam("year")String tyear,
			@PathParam("fmonth")String fmonth,@PathParam("date")String fdate,@PathParam("year")String fyear);
	
	@GET
	public List<Mstsmvrates>getAll();
	
	@POST
	@Path("getAll/{buyerCode}/{month}/{date}/{year}")
	public List<Object> getAll(@PathParam("buyerCode")String buyerCode, 
			@PathParam("month")String month,@PathParam("date")String date,@PathParam("year")String year);
	
	@POST
	@Path("getsmv/{buyerCode}/{month}/{date}/{year}/{fmv}")
	public List<Object> getAll(@PathParam("buyerCode")String buyerCode, 
			@PathParam("month")String month,@PathParam("date")String date,@PathParam("year")String year,@PathParam("fmv")String fmv);
}