package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.Mststylerouteoperationdemmap;
import com.excelsoft.model.MststylerouteoperationdemmapId;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/mststylerouteopdemmap")
public interface MststylerouteoperationdemmapManager extends
		GenericManager<Mststylerouteoperationdemmap, MststylerouteoperationdemmapId> {

	@GET
	public List<Mststylerouteoperationdemmap> getAll();

	@POST
	@Path("getAllOpDemMaps/{opeartionNo}/{styleRouteId}")
	public List<Mststylerouteoperationdemmap> getAllOpDemMaps(
			@PathParam("opeartionNo") String opeartionNo,
			@PathParam("styleRouteId") String styleRouteId);

	public List<Mststylerouteoperationdemmap> getAllOpDemMaps(
			Mststylerouteoperation mststylerouteoperation);

}