package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mercostsheetcountry;
import com.excelsoft.model.MercostsheetcountryId;
import com.excelsoft.model.Mercostsheethdr;

/**
 * An interface that provides a data management interface to the Mercostsheetcountry table.
 */
public interface MercostsheetcountryDao extends GenericDao<Mercostsheetcountry, MercostsheetcountryId> {

	public List<Mercostsheetcountry> getAll(Mercostsheethdr mercostsheethdr);
	
}