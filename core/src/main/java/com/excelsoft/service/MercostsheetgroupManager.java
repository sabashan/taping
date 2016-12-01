package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.MercostsheetgroupId;
import com.excelsoft.model.Mercostsheethdr;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/mercostsheetgroup")
public interface MercostsheetgroupManager extends GenericManager<Mercostsheetgroup, MercostsheetgroupId> {

	@GET
	public List<Mercostsheetgroup> getAll();

	public Mercostsheetgroup get(String groupName);

	@POST
	@Path("getAll/{cosrsheetno}/{version}/{costsheetType}")
	public List<Mercostsheetgroup> getAll(
			@PathParam("cosrsheetno") String cosrsheetNo,
			@PathParam("version") String version,
			@PathParam("costsheetType") String costsheetType);

	public List<Mercostsheetgroup> getAll(Mercostsheethdr mercostsheethdr);
	
	@POST
	@Path("get/{cosrsheetno}/{version}/{costsheetType}/{groupName}")
	public	Mercostsheetgroup get(@PathParam("cosrsheetno")String costSheetNo,
			@PathParam("version")String versionNo,
			@PathParam("costsheetType")String costSheetType, 
			@PathParam("groupName")String groupName);

}