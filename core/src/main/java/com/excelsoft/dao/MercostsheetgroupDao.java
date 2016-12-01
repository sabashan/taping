package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.MercostsheetgroupId;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;

/**
 * An interface that provides a data management interface to the Mercostsheetgroup table.
 */
public interface MercostsheetgroupDao extends GenericDao<Mercostsheetgroup, MercostsheetgroupId> {

	public List<Mercostsheetgroup> getAll(String cosrsheetNo, String version,
			String costsheetType);
	
	public List<Mercostsheetgroup> getAll(Mercostsheethdr mercostsheethdr) ;
		Mercostsheetgroup get(String groupName);

	public	Mercostsheetgroup get(String costSheetNo, String versionNo,
				String costSheetType, String groupName);
	
}