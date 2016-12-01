package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Merprecostsheetcurrency;
import com.excelsoft.model.MerprecostsheetcurrencyId;

/**
 * An interface that provides a data management interface to the Merprecostsheetcurrency table.
 */
public interface MerprecostsheetcurrencyDao extends GenericDao<Merprecostsheetcurrency, MerprecostsheetcurrencyId> {
	public List< Merprecostsheetcurrency> getAll(Merprecostsheet merprecostsheet );
}