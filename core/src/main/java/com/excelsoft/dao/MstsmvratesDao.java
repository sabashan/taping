package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstsmvrates;
import com.excelsoft.model.MstsmvratesId;

/**
 * An interface that provides a data management interface to the Mstsmvrates table.
 */
public interface MstsmvratesDao extends GenericDao<Mstsmvrates, MstsmvratesId> {
	
	
	public List<Object> getAll(String buyerCode,
			String d_Date );
	
	public List<Object> getAll(String buyerCode,
			String d_Date,String fmv );

}