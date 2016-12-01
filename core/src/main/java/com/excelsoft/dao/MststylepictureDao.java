package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.Mststylepicture;
import com.excelsoft.model.MststylepictureId;

/**
 * An interface that provides a data management interface to the Mststylepicture table.
 */
public interface MststylepictureDao extends GenericDao<Mststylepicture, MststylepictureId> {
	
	public List<Mststylepicture> getAll(Mststyleheader mststyleheader);

	public List<Mststylepicture> getZero(Mststyleheader mststyleheader);

}