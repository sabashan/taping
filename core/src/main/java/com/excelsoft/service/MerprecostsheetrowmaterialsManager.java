package com.excelsoft.service;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Merprecostsheetrowmaterials;
import com.excelsoft.model.MerprecostsheetrowmaterialsId;
import com.excelsoft.model.Merprecostsheet;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("merprecostsheetrowmaterial")
public interface MerprecostsheetrowmaterialsManager extends GenericManager<Merprecostsheetrowmaterials, MerprecostsheetrowmaterialsId> {
   
	@GET
	public List<Merprecostsheetrowmaterials> getAll();
	
	
	@POST
	@Path("GetByid/{preCostSheetNo}/{versionNo}/{costsheetType}/{precostsheetRowMatCode}/{component}")
	public Merprecostsheetrowmaterials get(@PathParam("preCostSheetNo")String preCostSheetNo,
			@PathParam("versionNo")String versionNo,@PathParam("costsheetType")String costsheetType,
			@PathParam("precostsheetRowMatCode") String precostsheetRowMatCode, @PathParam("component")String component);
	
	
	@POST
	@Path("GetByid/{preCostSheetNo}/{versionNo}/{costsheetType}/{category}")
	public List<Merprecostsheetrowmaterials> getAll(@PathParam("preCostSheetNo")String preCostSheetNo,
			@PathParam("versionNo")String versionNo,@PathParam("costsheetType")String costsheetType,@PathParam("category")String category);
	
	public Merprecostsheetrowmaterials get(MerprecostsheetrowmaterialsId id);
	
	public BigDecimal getNext(Merprecostsheet merprecostsheet);
	
	public List<Merprecostsheetrowmaterials> getAll(Merprecostsheet merprecostsheet);
	
	public List<Merprecostsheetrowmaterials> getAll(Merprecostsheet merprecostsheet,String category);
	
	public List<Merprecostsheetrowmaterials> getAll(Merprecostsheet merprecostsheet,String category,String Itemtype,String Itemcode);
	
	public List<Merprecostsheetrowmaterials> getAllShell(Merprecostsheet merprecostsheet, String category);
	
	@POST
	@Path("GetAllfrmfld/{preCostSheetNo}/{versionNo}/{costsheetType}/{category}/{fld}")
	public List<Object> getAllCost(@PathParam("preCostSheetNo")String preCostSheetNo,
			@PathParam("versionNo")String versionNo,@PathParam("costsheetType")String costsheetType,
			@PathParam("category")String category,@PathParam("fld")String fld);
}