package com.excelsoft.dao;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mstnumbers;
import com.excelsoft.model.MstnumbersId;

/**
 * An interface that provides a data management interface to the Mstnumbers table.
 */
public interface MstnumbersDao extends GenericDao<Mstnumbers, MstnumbersId> {

	public String getNextRoute();
	
	public String setNextRoute();

	public Integer getnexttrnNo(String compCode, short programId, String trnType);

	public String getNextWIPId();

	public String setNextWIPId();
}