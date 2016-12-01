package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mststyledem;
import com.excelsoft.model.MststyledemId;
import com.excelsoft.model.Mststyleheader;

/**
 * An interface that provides a data management interface to the Mststyledem
 * table.
 */
public interface MststyledemDao extends GenericDao<Mststyledem, MststyledemId> {
	
	public List<Mststyledem> getAll(Mststyleheader mststyleheader);

}