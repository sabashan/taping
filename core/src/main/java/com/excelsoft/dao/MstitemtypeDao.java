package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstitemtype;

/**
 * An interface that provides a data management interface to the Mstitemtype table.
 */
public interface MstitemtypeDao extends GenericDao<Mstitemtype, String> {
	public List<String> getAllId(String category);
	
	public List<Mstitemtype> getAll(String category,String q);
	public List<Mstitemtype> getAll(String category);
}