package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstcompany;
import com.excelsoft.model.Mstcustomer;
import com.excelsoft.model.Mstdepartment;
import com.excelsoft.model.Mstlocation;
import com.excelsoft.model.Mststylecomponent;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.model.Mststyleroute;

/**
 * An interface that provides a data management interface to the Mststyleroute
 * table.
 */
public interface MststylerouteDao extends GenericDao<Mststyleroute, Long> {

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
	 * @return Mststyleheaders the style which have corresponding values in
	 *         given fields
	 */
	public List<Object> getStyleRout(String dep, String sty, String cust,
			String loc, String styr, String main, String compi, String compa,
			String need);

	public List<Mststyleroute> getAllRoutes(MststyleheaderId mststyleheaderId);
	public List<Mststyleroute> getAllRoutesQ(MststyleheaderId mststyleheaderId,String query);

	public List<Mststyleroute> routesch(String dep, String sty, String cust);

	public List<Mstlocation> locationByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query);

	public List<Mstdepartment> MstdepartmentByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query);

	public List<Mststyleheader> MststyleheaderByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query);

	public List<Mstcustomer> MstcustomerByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query);

	public List<Mststyleroute> MststylerouteoperationByparam(
			String dep, String sty, String cust, String loc, String styr,
			String main, String compi, String compa, String need, String query);

	public List<Mststylecomponent> MststylecomponentByparam(String dep,
			String sty, String cust, String loc, String styr, String main,
			String compi, String compa, String need, String query);

	public List<Mstcompany> MstcompanyByparam(String dep, String sty,
			String cust, String loc, String styr, String main, String compi,
			String compa, String need, String query);

	public Mststyleroute routeSearchById(String styleRouteId);
	
	public List<Mststyleroute> MststylerouteoperationByparam(
			String dep, String sty, String cust, String loc, String styr,
			String main, String compi, String compa, String location,
			String need, String query);
	
}