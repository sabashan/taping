package com.excelsoft.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.excelsoft.model.Mstcustomer;
import com.excelsoft.model.Mstlocation;
import com.excelsoft.model.Mststylecomponent;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.model.Mststyleroute;

@WebService
@Path("/styleroute")
public interface MststylerouteManager extends GenericManager<Mststyleroute, Long> {

	/**
	 * @return all the style with conform state
	 */
	@GET
	public List<Mststyleroute> getAll();

	/**
	 * @param String
	 *            type means Column name
	 * @param String
	 *            Param means Column value
	 * 
	 * @return Mststyleheader the style which have corresponding values in given
	 *         fields
	 */

	@POST
	@Path("routeByparam/{dep}/{sty}/{cust}/{loc}/{styr}/{main}/{compi}/{compa}/{need}")
	public List<Object> getStyleRout(@PathParam("dep") String dep,
			@PathParam("sty") String sty, @PathParam("cust") String cust,
			@PathParam("loc") String loc, @PathParam("styr") String styr,
			@PathParam("main") String main, @PathParam("compi") String compi,
			@PathParam("compa") String compa, @PathParam("need") String need);

	@POST
	@Path("MstlocationrouteByparamquery/{dep}/{sty}/{cust}/{loc}/{styr}/{main}/{compi}/{compa}/{need}/{query}")
	public List<Mstlocation> locationByparam(@PathParam("dep") String dep,
			@PathParam("sty") String sty, @PathParam("cust") String cust,
			@PathParam("loc") String loc, @PathParam("styr") String styr,
			@PathParam("main") String main, @PathParam("compi") String compi,
			@PathParam("compa") String compa, @PathParam("need") String need,
			@PathParam("query") String query);

	@POST
	@Path("MststyleheaderrouteByparamquery/{dep}/{sty}/{cust}/{loc}/{styr}/{main}/{compi}/{compa}/{need}/{query}")
	public List<Mststyleheader> MststyleheaderByparam(
			@PathParam("dep") String dep, @PathParam("sty") String sty,
			@PathParam("cust") String cust, @PathParam("loc") String loc,
			@PathParam("styr") String styr, @PathParam("main") String main,
			@PathParam("compi") String compi, @PathParam("compa") String compa,
			@PathParam("need") String need, @PathParam("query") String query);

	@POST
	@Path("MstcustomerrouteByparamquery/{dep}/{sty}/{cust}/{loc}/{styr}/{main}/{compi}/{compa}/{need}/{query}")
	public List<Mstcustomer> MstcustomerByparam(@PathParam("dep") String dep,
			@PathParam("sty") String sty, @PathParam("cust") String cust,
			@PathParam("loc") String loc, @PathParam("styr") String styr,
			@PathParam("main") String main, @PathParam("compi") String compi,
			@PathParam("compa") String compa, @PathParam("need") String need,
			@PathParam("query") String query);

	@POST
	@Path("MststylerouteoperationrouteByparamquery/{dep}/{sty}/{cust}/{loc}/{styr}/{main}/{compi}/{compa}/{need}/{query}")
	public List<Mststyleroute> MststylerouteoperationByparam(
			@PathParam("dep") String dep, @PathParam("sty") String sty,
			@PathParam("cust") String cust, @PathParam("loc") String loc,
			@PathParam("styr") String styr, @PathParam("main") String main,
			@PathParam("compi") String compi, @PathParam("compa") String compa,
			@PathParam("need") String need, @PathParam("query") String query);
	
	
	@POST
	@Path("MststylerouteByparamquery/{dep}/{sty}/{cust}/{loc}/{styr}/{main}/{compi}/{compa}/{location}/{need}/{query}")
	public List<Mststyleroute> MststylerouteoperationByparam(
			@PathParam("dep") String dep, @PathParam("sty") String sty,
			@PathParam("cust") String cust, @PathParam("loc") String loc,
			@PathParam("styr") String styr, @PathParam("main") String main,
			@PathParam("compi") String compi, @PathParam("compa") String compa, 
			@PathParam("location") String location,
			@PathParam("need") String need, @PathParam("query") String query);

	@POST
	@Path("MststylecomponentrouteByparamquery/{dep}/{sty}/{cust}/{loc}/{styr}/{main}/{compi}/{compa}/{need}/{query}")
	public List<Mststylecomponent> MststylecomponentByparam(
			@PathParam("dep") String dep, @PathParam("sty") String sty,
			@PathParam("cust") String cust, @PathParam("loc") String loc,
			@PathParam("styr") String styr, @PathParam("main") String main,
			@PathParam("compi") String compi, @PathParam("compa") String compa,
			@PathParam("need") String need, @PathParam("query") String query);

	


	@POST
	@Path("routesch/{dep}/{sty}/{cust}")
	public List<Mststyleroute> routesch(@PathParam("dep") String dep,
			@PathParam("sty") String sty, @PathParam("cust") String cust);

	@POST
	@Path("routeSearchById/{styleRouteId}")
	public Mststyleroute routeSearchById(@PathParam("styleRouteId") String styleRouteId);
	
	public List<Mststyleroute> getAllRoutes(MststyleheaderId mststyleheaderId);

	public List<Mststyleroute> getAllRoutesQ(MststyleheaderId mststyleheaderId,
			String query);
	
}

