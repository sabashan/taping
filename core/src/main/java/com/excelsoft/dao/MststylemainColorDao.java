package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.MststyleheaderId;
import com.excelsoft.model.MststylemainColor;
import com.excelsoft.model.MststylemainColorId;

/**
 * An interface that provides a data management interface to the
 * MststylemainColor table.
 */
public interface MststylemainColorDao extends
		GenericDao<MststylemainColor, MststylemainColorId> {
	
	public List<MststylemainColor> getAll(Mststyleheader mststyleheader);
	public List<String> getAllStrings(Mststyleheader mststyleheader);
	public List<MststylemainColor> getAll(MststyleheaderId id);
	public List<String> getcode();
	
	public List<String> getAllStrings( String location,
			String buyer, String department, String style,String company);
	
	
	public List<MststylemainColor> getAll(String location, String buyer,
			String department, String style, String company, String query);
}