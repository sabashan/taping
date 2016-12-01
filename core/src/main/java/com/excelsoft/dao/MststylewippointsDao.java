package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mststylewippoints;

/**
 * An interface that provides a data management interface to the Mststylewippoints table.
 */
public interface MststylewippointsDao extends GenericDao<Mststylewippoints, String> {

	public Mststylewippoints getWipPointById(String wippointCode);

	public List<Mststylewippoints> getAllActive();
}