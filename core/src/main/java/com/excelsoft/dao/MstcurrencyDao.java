package com.excelsoft.dao;

import java.util.List;


import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstcurrency;

/**
 * An interface that provides a data management interface to the Mstcurrency table.
 */
public interface MstcurrencyDao extends GenericDao<Mstcurrency, String> {
	 
	    public List<String> getAllid();
	    
}