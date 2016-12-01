package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.MststylechildColor;
import com.excelsoft.model.MststylechildColorId;
import com.excelsoft.model.Mststyleheader;

/**
 * An interface that provides a data management interface to the MststylechildColor table.
 */
public interface MststylechildColorDao extends GenericDao<MststylechildColor, MststylechildColorId> {
	
	public List<MststylechildColor> getAll(Mststyleheader mststyleheader);

}