package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.Mststylerouteoperationdemmap;
import com.excelsoft.model.MststylerouteoperationdemmapId;

/**
 * An interface that provides a data management interface to the
 * Mststylerouteoperationdemmap table.
 */
public interface MststylerouteoperationdemmapDao
		extends
		GenericDao<Mststylerouteoperationdemmap, MststylerouteoperationdemmapId> {

	public List<Mststylerouteoperationdemmap> getAllOpDemMaps(
			Mststylerouteoperation mststyleoperation);

}