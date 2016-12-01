package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mercostsheetgroupcolor;
import com.excelsoft.model.MercostsheetgroupcolorId;
import com.excelsoft.model.Mercostsheetgroupsetting;

/**
 * An interface that provides a data management interface to the Mercostsheetgroupcolor table.
 */
public interface MercostsheetgroupcolorDao extends GenericDao<Mercostsheetgroupcolor, MercostsheetgroupcolorId> {

	List<Mercostsheetgroupcolor> getAll(Mercostsheetgroupsetting mercostsheetgroupsetting);

}