package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Merprecostsheetsmv;
import com.excelsoft.model.MerprecostsheetsmvId;

/**
 * An interface that provides a data management interface to the Merprecostsheetsmv table.
 */
public interface MerprecostsheetsmvDao extends GenericDao<Merprecostsheetsmv, MerprecostsheetsmvId> {
	public List<Merprecostsheetsmv> getAll(Merprecostsheet merprecostsheet);
}