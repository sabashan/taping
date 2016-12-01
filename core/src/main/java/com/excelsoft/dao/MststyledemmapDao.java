package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mststyledemmap;
import com.excelsoft.model.MststyledemmapId;
import com.excelsoft.model.Mststyleheader;

/**
 * An interface that provides a data management interface to the Mststyledemmap
 * table.
 */
public interface MststyledemmapDao extends
		GenericDao<Mststyledemmap, MststyledemmapId> {
	
	public List<Mststyledemmap> getAll(Mststyleheader mststyleheader);

}