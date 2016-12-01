package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.Mercostsheetgroupsetting;
import com.excelsoft.model.MercostsheetgroupsettingId;
import com.excelsoft.model.Mercostsheethdr;

/**
 * An interface that provides a data management interface to the Mercostsheetgroupsetting table.
 */
public interface MercostsheetgroupsettingDao extends GenericDao<Mercostsheetgroupsetting, MercostsheetgroupsettingId> {

	public List<Mercostsheetgroupsetting> getAll(Mercostsheetgroup mercostsheetgroup);
	
	public List<Mercostsheetgroupsetting> getAll(Mercostsheethdr mercostsheethdr);
	
}