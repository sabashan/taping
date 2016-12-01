package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mststylecomponent;
import com.excelsoft.model.MststylecomponentId;
import com.excelsoft.model.Mststyleheader;

/**
 * An interface that provides a data management interface to the
 * Mststylecomponent table.
 */
public interface MststylecomponentDao extends
		GenericDao<Mststylecomponent, MststylecomponentId> {
	
	/**
	 * 
	 * @param mststyleheader
	 * @return  List<Mststylecomponent>
	 */
	public List<Mststylecomponent> getAll(Mststyleheader mststyleheader);
	public List<String> getAllStrings(Mststyleheader mststyleheader);
	public List<String> getAllStrings(String style,String  location,String  department,String  company,String  buyer) ;
	public List<String> getcode();
	public List<Mststylecomponent> getAll(String style, String location,
			String department, String company, String buyer, String query);

}