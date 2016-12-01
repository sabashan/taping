package com.excelsoft.service;

import com.excelsoft.service.GenericManager;
import com.excelsoft.model.Mststyleroute;
import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.MststylerouteoperationId;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@WebService
@Path("/mststyleoperation")
public interface MststylerouteoperationManager extends
		GenericManager<Mststylerouteoperation, MststylerouteoperationId> {

	@GET
	public List<Mststylerouteoperation> getAll();

	@POST
	@Path("getById/{opeartionNo}/{styleRouteId}")
	public Mststylerouteoperation getbyidparam(
			@PathParam("opeartionNo") String opeartionNo,
			@PathParam("styleRouteId") String styleRouteId);

/**	@POST
	@Path("getByIds/{opeartionNo}/{componentId}/{mainColor}/{styleRouteId}/{styleId}/{locationCode}/{custCode}/{compCode}/{depCode}")
	public Mststylerouteoperation getbyidparam(
			@PathParam("opeartionNo") String opeartionNo,
			@PathParam("componentId") String componentId,
			@PathParam("mainColor") String mainColor,
			@PathParam("styleRouteId") String styleRouteId,
			@PathParam("styleId") String styleId,
			@PathParam("locationCode") String locationCode,
			@PathParam("custCode") String custCode,
			@PathParam("compCode") String compCode,
			@PathParam("depCode") String depCode);
*/
	
	public Mststylerouteoperation get(MststylerouteoperationId id);

	/**
	 * 
	 * @param mststylerouteoperation
	 * @return
	 */
	public List<Mststylerouteoperation> getByRoot(
			Mststylerouteoperation mststylerouteoperation);

	/**
	 * 
	 * @param mststyleroute
	 * @return
	 */
	public List<Mststylerouteoperation> getByRoute(Mststyleroute mststyleroute);

	/**
	 * 
	 * @param StyleComponent
	 * @param mainColor
	 * @param RouteId
	 * @param styleId
	 * @param locationCode
	 * @param custCode
	 * @param depCode
	 * @return next operation id
	 */
	public int getnextopperation(String StyleComponent, String mainColor,
			Long RouteId, String styleId, String locationCode, String custCode,
			String depCode);

	public int getnextopperation(Mststylerouteoperation mststylerouteoperatio);
	
	
	public int getnextopperation(@PathParam("RouteId")Long RouteId);
	
	@POST
	@Path("getnextop/{styleRouteId}")
	public Long getnextsequenceNo(@PathParam("styleRouteId")Long RouteId);

	@POST
	@Path("chkoperation/{styleRouteId}/{sequenceNo}")
	public boolean chkoperation(@PathParam("styleRouteId")Long RouteId,@PathParam("sequenceNo")Long sequenceNo);
	
	/**
	 * 
	 * @param StyleComponent
	 * @param mainColor
	 * @param RouteId
	 * @param styleId
	 * @param locationCode
	 * @param custCode
	 * @param compCode
	 * @param depCode
	 * @return List of operations
	 */
	public List<Mststylerouteoperation> getByRootparam( Long RouteId);

	@POST
	@Path("routeopsch/{styleRouteID}/{styleRouteName}/{schmodelBuyerDip}/{schmodelStyle}/{schmodelBuyer}")
	public List<Mststylerouteoperation> routeopsch(
			@PathParam("styleRouteID") String styleRouteID,
			@PathParam("styleRouteName") String styleRouteName,
			@PathParam("schmodelBuyerDip") String schmodelBuyerDip,
			@PathParam("schmodelStyle") String schmodelStyle,
			@PathParam("schmodelBuyer") String schmodelBuyer);
	
	@POST
	@Path("getSMV/{styleRouteId}")
	public List<BigDecimal> getSMV(@PathParam("styleRouteId")String routeId);
 
	

	public List<Mststylerouteoperation> getByRootparamQ(Long RouteId, String query);
}