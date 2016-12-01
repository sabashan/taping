package com.excelsoft.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.excelsoft.model.Mstcompany;
import com.excelsoft.model.Mstcustomer;
import com.excelsoft.model.Mstlocation;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;

@WebService
@Path("/mststyleheader")
public interface MststyleheaderManager extends
		GenericManager<Mststyleheader, MststyleheaderId> {

	/**
	 * @param flag
	 *            style status
	 * @param User
	 *            created of modified user
	 * @return List<Mststyleheader> all the style with Pending state and created
	 *         or modified by logged user
	 */
	@GET
	@Path("PendingStyles/{flag}/{user}")
	public List<Mststyleheader> getPendingStyles(
			@PathParam("flag") String flag, @PathParam("user") String user);

	/**
	 * @return all the style with conform state
	 */
	@GET
	public List<Mststyleheader> getAll();

	/**
	 * 
	 * @param location
	 * @param buyer
	 * @param department
	 * @param Style
	 * @param company
	 * @return List<Mststyleheader> 
	 */
	@POST
	@Path("StylesByparam/{location}/{buyer}/{department}/{Style}/{company}/{need}")
	public List<String> StylesByparam(@PathParam("location") String location, @PathParam("buyer") String buyer,
			@PathParam("department") String department, @PathParam("Style") String Style,
			@PathParam("company") String company,@PathParam("need") String need);
	
	/**
	 * 
	 * @param location
	 * @param buyer
	 * @param department
	 * @param Style
	 * @param company
	 * @return List<Mststyleheader> 
	 */
	@POST
	@Path("locationByparam/{location}/{buyer}/{department}/{Style}/{company}/{need}/{query}")
	public List<Mstlocation> locationByparam(@PathParam("location") String location, @PathParam("buyer") String buyer,
			@PathParam("department") String department, @PathParam("Style") String Style,
			@PathParam("company") String company,@PathParam("need") String need,@PathParam("query")String query);
	@POST
	@Path("MststyleheaderByparam/{location}/{buyer}/{department}/{Style}/{company}/{need}/{query}")
	public List<Mststyleheader> MststyleheaderByparam(@PathParam("location") String location, @PathParam("buyer") String buyer,
			@PathParam("department") String department, @PathParam("Style") String Style,
			@PathParam("company") String company,@PathParam("need") String need,@PathParam("query")String query);
	
	@POST
	@Path("MstcustomerByparam/{location}/{buyer}/{department}/{Style}/{company}/{need}/{query}")
	public List<Mstcustomer> MstcustomerByparam(@PathParam("location") String location, @PathParam("buyer") String buyer,
			@PathParam("department") String department, @PathParam("Style") String Style,
			@PathParam("company") String company,@PathParam("need") String need,@PathParam("query")String query);
	@POST
	@Path("MstcompanyByparam/{location}/{buyer}/{department}/{Style}/{company}/{need}/{query}")
	public List<Mstcompany> MstcompanyByparam(@PathParam("location") String location, @PathParam("buyer") String buyer,
			@PathParam("department") String department, @PathParam("Style") String Style,
			@PathParam("company") String company,@PathParam("need") String need,@PathParam("query")String query);
	
	/**
	 * @param company
	 *            company name
	 * @param buyer
	 *            buyer name (Customer)
	 * @param department
	 *            department name
	 * @param location
	 *            location name
	 * @param style
	 *            style id
	 * @return Mststyleheader the style which have corresponding values in given
	 *         fields
	 */
	@POST
	@Path("StylesAll"
			+ "param/{location}/{company}/{buyer}/{department}/{Style}")
	public Mststyleheader getStyle(@PathParam("company") String company,
			@PathParam("location") String location,
			@PathParam("buyer") String buyer,
			@PathParam("department") String department,
			@PathParam("Style") String style);
	
	 public List<Mststyleheader> getallsearch(String q, String []ids) ;

}