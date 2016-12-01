package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mercostsheetgroupdemmap;
import com.excelsoft.model.MercostsheetgroupdemmapId;
import com.excelsoft.model.Mercostsheetgroupsetting;
import com.excelsoft.model.Mercostsheethdr;

/**
 * An interface that provides a data management interface to the Mercostsheetgroupdemmap table.
 */
public interface MercostsheetgroupdemmapDao extends GenericDao<Mercostsheetgroupdemmap, MercostsheetgroupdemmapId> {

	List<Mercostsheetgroupdemmap> getAll(Mercostsheetgroupsetting mercostsheetgroupsetting);

}