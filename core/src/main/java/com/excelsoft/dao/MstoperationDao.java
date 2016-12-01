package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstoperation;

/**
 * An interface that provides a data management interface to the Mstoperation table.
 */
public interface MstoperationDao extends GenericDao<Mstoperation, Integer> {

	public List<Mstoperation> getAllByType(String type);
	
	public List<String> getAllTypes();
	
	public List<String> getAllTypes(String type);
	
	public List<Mstoperation> getAllByTypeAnd(String type, String Qary);
}