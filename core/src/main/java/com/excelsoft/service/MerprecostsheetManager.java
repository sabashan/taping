package com.excelsoft.service;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;
import com.excelsoft.model.Mststyleheader;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/merprecostsheet")
public interface MerprecostsheetManager extends GenericManager<Merprecostsheet, MerprecostsheetId> {
	
	@Override
	@GET
	public List<Merprecostsheet> getAll() ;
	
	@Override
	public Merprecostsheet get(MerprecostsheetId id) ;
	

	public List<Merprecostsheet> getAll(Mststyleheader mststyleheader,String season,String query) ;

	public List<MerprecostsheetId> getAllids(Mststyleheader mststyleheader,String season,String query) ;
	
	@POST
	@Path("getAllVersion/{costSheetTytpe}/{preCostSheetNo}")
	public List<BigDecimal> getAllVersion(@PathParam("costSheetTytpe")String costSheetTytpe,@PathParam("preCostSheetNo")String preCostSheetNo) ;
	
	@POST
	@Path("getAlldue")
	public List<Merprecostsheet> getAllDue(String flag,String User);
	
	@POST
	@Path("getAllids/{compCode}/{locationCode}/{custCode}/{depCode}/{styleId}/{season}/{costsheetType}")
	public List<String> getAllids(@PathParam("compCode")String compCode, 
			@PathParam("locationCode")String locationCode, @PathParam("custCode")String custCode,
			@PathParam("depCode") String depCode, @PathParam("styleId")String styleId, @PathParam("season")String season, @PathParam("costsheetType")String costsheetType) ;
	
	public List<Merprecostsheet> getAll(String flag);
	
	@POST
	@Path("getAll/{compCode}/{locationCode}/{custCode}/{depCode}/{styleId}/{season}/{costsheetType}/{query}")
	public List<Merprecostsheet> getAll(@PathParam("compCode")String compCode, 
			@PathParam("locationCode")String locationCode, @PathParam("custCode")String custCode,
			@PathParam("depCode") String depCode, @PathParam("styleId")String styleId, @PathParam("season")String season,
			@PathParam("costsheetType")String costsheetType, @PathParam("query")String query);
	
	public Mststyleheader getStyle(MerprecostsheetId id);
}