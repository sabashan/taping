package com.excelsoft.service;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.excelsoft.model.MerordersheethdrId;
import com.excelsoft.model.Merordersheetrawmaterial;
import com.excelsoft.model.MerordersheetrawmaterialId;

@WebService
@Path("merordersheetrawmaterial")
public interface MerordersheetrawmaterialManager extends GenericManager<Merordersheetrawmaterial, MerordersheetrawmaterialId> {
	@GET
	public List<Merordersheetrawmaterial> getAll();
	

	public Merordersheetrawmaterial get(MerordersheetrawmaterialId id);
	
	@POST
	@Path("GetByid/{planingOrdersheetNo}/{orderType}/{rowMaterialNo}")
	public Merordersheetrawmaterial get(@PathParam("planingOrdersheetNo")String planingOrdersheetNo,@PathParam("orderType")String orderType,@PathParam("rowMaterialNo")String rowMaterialNo);

	
	@POST
	@Path("GetAllByid/{planingOrdersheetNo}/{orderType}/{category}")
	public List<Merordersheetrawmaterial> getAll(@PathParam("planingOrdersheetNo")String planingOrdersheetNo
			,@PathParam("orderType")String orderType,@PathParam("category")String category);
	
	
	@POST
	@Path("GetAllByidquery/{planingOrdersheetNo}/{orderType}/{category}/{query}")
	public List<Merordersheetrawmaterial> getAll(@PathParam("planingOrdersheetNo")String planingOrdersheetNo
			,@PathParam("orderType")String orderType,@PathParam("category")String category,@PathParam("query")String query);
	
	
	public BigDecimal getNext(MerordersheethdrId id);
	
	
	
	@POST
	@Path("GetAllByid/{planingOrdersheetNo}/{orderType}")
	public List<Merordersheetrawmaterial> getAll(@PathParam("planingOrdersheetNo")String planingOrdersheetNo
			,@PathParam("orderType")String orderType);
	
	
	public List<Merordersheetrawmaterial> getAll(MerordersheethdrId id);

}