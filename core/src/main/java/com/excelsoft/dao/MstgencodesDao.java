package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstgencodes;
import com.excelsoft.model.MstgencodesId;

/**
 * An interface that provides a data management interface to the Mstgencodes table.
 */
public interface MstgencodesDao extends GenericDao<Mstgencodes, MstgencodesId> {
	
	public List<Mstgencodes> findByType(String type);
	
	public  List<Mstgencodes> findBycode(String code);
	
	public List<Mstgencodes> type_idlike(String type,String code);
	
	public List<String> getcode(String type);
}