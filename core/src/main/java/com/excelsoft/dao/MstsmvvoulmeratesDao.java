package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstsmvvoulmerates;
import com.excelsoft.model.MstsmvvoulmeratesId;

/**
 * An interface that provides a data management interface to the Mstsmvvoulmerates table.
 */
public interface MstsmvvoulmeratesDao extends GenericDao<Mstsmvvoulmerates, MstsmvvoulmeratesId> {

	public List<Object> getAll(String buyerCode, String d_Dates,
			String smvCode, String Volume);

}