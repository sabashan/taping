package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstuser;

/**
 * An interface that provides a data management interface to the Mstuser table.
 */
public interface MstuserDao extends GenericDao<Mstuser, String> {
	public List<String> getAlluserId();
	public List<Mstuser> getAllByq(String query);
}