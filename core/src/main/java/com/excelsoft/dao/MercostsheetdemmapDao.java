package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mercostsheetdemmap;
import com.excelsoft.model.MercostsheetdemmapId;
import com.excelsoft.model.Mercostsheethdr;

/**
 * An interface that provides a data management interface to the Mercostsheetdemmap table.
 */
public interface MercostsheetdemmapDao extends GenericDao<Mercostsheetdemmap, MercostsheetdemmapId> {

	List<Mercostsheetdemmap> getDemmapsFromCosting(Mercostsheethdr mercostsheethdr);

}