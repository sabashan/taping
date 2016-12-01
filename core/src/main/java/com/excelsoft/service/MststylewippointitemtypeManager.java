package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mststylewippointitemtype;
import com.excelsoft.model.MststylewippointitemtypeId;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@WebService
@Path("/wippointitemtype")
public interface MststylewippointitemtypeManager extends GenericManager<Mststylewippointitemtype, MststylewippointitemtypeId> {
    
	@GET
	public List<Mststylewippointitemtype> getAll();
	
	@POST
	@Path("getAllWippointitemtype")
	public List<Mststylewippointitemtype> getAllWippointitemtype();
	
	public List<Mststylewippointitemtype> getAllWippointitemtype(String itemType);

}