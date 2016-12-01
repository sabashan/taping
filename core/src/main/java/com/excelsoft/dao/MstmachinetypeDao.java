package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstmachinetype;

/**
 * An interface that provides a data management interface to the Mstmachinetype table.
 */
public interface MstmachinetypeDao extends GenericDao<Mstmachinetype, String> {
	public List<Mstmachinetype> getmachintype(String queary);
	
	public List<String> getmachintype();
}