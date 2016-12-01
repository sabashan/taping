package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstsupplier;
import com.excelsoft.model.MstsupplierId;

/**
 * An interface that provides a data management interface to the Mstsupplier table.
 */
public interface MstsupplierDao extends GenericDao<Mstsupplier, MstsupplierId> {
	public List<String> getAllid(String location);
	public List<Mstsupplier>  getAll(String location);
	List<Mstsupplier> getAllq(String location,String q);
}