package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstcustomer;

/**
 * An interface that provides a data management interface to the Mstcustomer table.
 */
public interface MstcustomerDao extends GenericDao<Mstcustomer, String> {
	public List<String> getCustomerCode();
	
	public List<Mstcustomer> getCustomerCodeq(String query);
}