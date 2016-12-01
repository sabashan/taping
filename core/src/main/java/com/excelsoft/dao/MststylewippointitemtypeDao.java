package com.excelsoft.dao;


import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mststylewippointitemtype;
import com.excelsoft.model.MststylewippointitemtypeId;

/**
 * An interface that provides a data management interface to the Mststylewippointitemtype table.
 */
public interface MststylewippointitemtypeDao extends GenericDao<Mststylewippointitemtype, MststylewippointitemtypeId> {

	public List<Mststylewippointitemtype> getAllWippointitemtype(String itemType);
}