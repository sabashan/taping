package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstitem;
import com.excelsoft.model.MstitemId;

/**
 * An interface that provides a data management interface to the Mstitem table.
 */
public interface MstitemDao extends GenericDao<Mstitem, MstitemId> {
	public List<String> getAllid(String ItemType);
	public List<Mstitem> getAll(String ItemType);
	public List<Mstitem> getAll(String ItemType, String q);
}