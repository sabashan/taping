package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstcompany;

/**
 * An interface that provides a data management interface to the Mstcompany table.
 */
public interface MstcompanyDao extends GenericDao<Mstcompany, String> {
	public List<Mstcompany> getAllbyquery(String query);
	public List<String> getCompanycode();
}