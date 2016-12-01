package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mercostsheetcurrency;
import com.excelsoft.model.MercostsheetcurrencyId;
import com.excelsoft.model.Mercostsheethdr;

/**
 * An interface that provides a data management interface to the Mercostsheetcurrency table.
 */
public interface MercostsheetcurrencyDao extends GenericDao<Mercostsheetcurrency, MercostsheetcurrencyId> {

	public List< Mercostsheetcurrency> getAll(Mercostsheethdr mercostsheethdr );
	
}