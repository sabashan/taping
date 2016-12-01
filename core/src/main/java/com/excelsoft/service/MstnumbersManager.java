package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mstnumbers;
import com.excelsoft.model.MstnumbersId;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/mstnumbers")
public interface MstnumbersManager extends GenericManager<Mstnumbers, MstnumbersId> {
    
	@GET
	public List<Mstnumbers> getAll();
	
	@GET
	@Path("getNextRoute")
	public String getNextRoute();
	
	@GET
	@Path("setNextRoute")
	public String setNextRoute();

	public Integer getnexttrnNo(String compCode, short programId, String trnType);
	
	@POST
	@Path("getnexttrnNo/{compCode}/{programId}/{trnType}")
	public Integer getnexttrnNo(@PathParam("compCode")String compCode,@PathParam("programId") String programId,@PathParam("trnType") String trnType);

	@GET
	@Path("getNextWIPId")
	public String getNextWIPId();

	@GET
	@Path("setNextWIPId")
	public String setNextWIPId();
	
}