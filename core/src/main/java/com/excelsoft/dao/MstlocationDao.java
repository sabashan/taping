package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstlocation;

/**
 * An interface that provides a data management interface to the Mstlocation table.
 */
public interface MstlocationDao extends GenericDao<Mstlocation, String> {
	
	public List<String>getcode();
	public Object get(String Id, String field);
}