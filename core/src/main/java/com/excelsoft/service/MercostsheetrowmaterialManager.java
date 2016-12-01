package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.Mercostsheetrowmaterial;
import com.excelsoft.model.MercostsheetrowmaterialId;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("mercostsheetrowmaterial")
public interface MercostsheetrowmaterialManager extends GenericManager<Mercostsheetrowmaterial, MercostsheetrowmaterialId> {

	@Override
	@GET
	public List<Mercostsheetrowmaterial> getAll();
	
	@POST
	@Path("GetByid/{costSheetNo}/{versionNo}/{costsheetType}/{category}")
	public List<Mercostsheetrowmaterial> getAll(@PathParam("costSheetNo")String costSheetNo,
			@PathParam("versionNo")String versionNo,@PathParam("costsheetType")String costsheetType,@PathParam("category")String category);

	public List<Mercostsheetrowmaterial> getAllShell(Mercostsheethdr mercostsheethdr, String category);
	
	public List<Mercostsheetrowmaterial> getAll(Mercostsheethdr Mercostsheethdr,String category,String Itemtype,String Itemcode);
	
	public Mercostsheetrowmaterial get(MercostsheetrowmaterialId id);
	
	public BigDecimal getNext(Mercostsheetgroup mercostsheetgroup);
	
	@POST
	@Path("get/{costSheetNo}/{versionNo}/{costsheetType}/{costSheetRowMatCode}/{component}/{groupId}")
	public Mercostsheetrowmaterial getAll(@PathParam("costSheetNo")String costSheetNo,
			@PathParam("versionNo")String versionNo,@PathParam("costsheetType")String costsheetType,@PathParam("category")String category,
			@PathParam("costSheetRowMatCode")String costSheetRowMatCode,@PathParam("component")String component,@PathParam("groupId")String groupId);
	@POST
	@Path("GetAllfrmfld/{CostSheetNo}/{versionNo}/{costsheetType}/{category}/{groupName}")
	public List<Mercostsheetrowmaterial> getAllCost(@PathParam("CostSheetNo")String CostSheetNo,
			@PathParam("versionNo")String versionNo,@PathParam("costsheetType")String costsheetType,
			@PathParam("category")String category,@PathParam("groupName")String groupName);
	
	@POST
	@Path("getAll/{costSheetNo}/{versionNo}/{costsheetType}/{costSheetRowMatCode}/{component}")
	public List<Mercostsheetrowmaterial> getAll(@PathParam("costSheetNo")String costSheetNo,@PathParam("versionNo") String versionNo,
			@PathParam("costsheetType") String costsheetType);
	
	public List<Mercostsheetrowmaterial> getAll(String costSheetNo, String versionNo,
			String costsheetType,String[] types,String[] values);
	
	@POST
	@Path("GetAllfrm/{costSheetNo}/{versionNo}/{costsheetType}/{category}/{fld}")
	public List<Object> getAll(@PathParam("costSheetNo")String costSheetNo,
			@PathParam("versionNo")String versionNo,@PathParam("costsheetType")String costsheetType,
			@PathParam("category")String category,@PathParam("fld")String fld);
	
}