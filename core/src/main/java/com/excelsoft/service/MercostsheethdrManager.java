package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Mststyleheader;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("mercostsheethdr")
public interface MercostsheethdrManager extends GenericManager<Mercostsheethdr, MercostsheethdrId> {
    
	public List<Mercostsheethdr> getAll(Mststyleheader mststyleheader,String season,String query) ;

	public List<Mercostsheethdr> getAlldue(String flag,String UserId);

	public List<Mercostsheethdr> getAll(String flag);
	@GET
	public List<Mercostsheethdr> getAll();
	
	public Mststyleheader getStyle(MercostsheethdrId id);
	
	public Merprecostsheet getprecostsheet(MercostsheethdrId id);
	
	@POST
	@Path("getprecost/{costsheetNo}/{version}/{costsheetType}")
	public Merprecostsheet getprecostsheet(@PathParam("costsheetNo")String costsheetNo,@PathParam("version")String version,@PathParam("costsheetType")String costsheetType);
	
}