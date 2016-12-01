package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.Mercostsheetsmv;
import com.excelsoft.model.MercostsheetsmvId;

/**
 * An interface that provides a data management interface to the Mercostsheetsmv table.
 */
public interface MercostsheetsmvDao extends GenericDao<Mercostsheetsmv, MercostsheetsmvId> {
	public List<Mercostsheetsmv> getAll(Mercostsheethdr mercostsheethdr);
}