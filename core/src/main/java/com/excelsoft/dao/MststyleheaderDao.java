package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstcompany;
import com.excelsoft.model.Mstcustomer;
import com.excelsoft.model.Mstlocation;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;

/**
 * An interface that provides a data management interface to the Mststyleheader
 * table.
 */
public interface MststyleheaderDao extends
		GenericDao<Mststyleheader, MststyleheaderId> {

	/**
	 * @param flag
	 *            style status
	 * @param User
	 *            created of modified user
	 * @return List<Mststyleheader> all the style with Pending state and created
	 *         or modified by logged user
	 */
	public List<Mststyleheader> getPendingStyles(String flag, String user);

	/**
	 * @return all the style with conform state
	 */
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
	public List<String> StylesByparam(String location,
			String buyer, String department, String Style, String company,String need);

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
	public Mststyleheader getStyle(String company, String location,
			String buyer, String ddepartment, String style);

	public List<Mstlocation> locationByparam(String location, String buyer,
			String department, String Style, String company, String need,String query);

	public List<Mstcompany> MstcompanyByparam(String location, String buyer,
			String department, String Style, String company, String need,
			String query);

	

	public List<Mstcustomer> MstcustomerByparam(String location, String buyer,
			String department, String Style, String company, String need,
			String query);

	public List<Mststyleheader> MststyleheaderByparam(String location, String buyer,
			String department, String Style, String company, String need,
			String query);
	
	public List<Mststyleheader> getallsearch(String q,String []ids);

}