package com.excelsoft.dao;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;
import com.excelsoft.model.Merprecostsheetrowmaterials;
import com.excelsoft.model.MerprecostsheetrowmaterialsId;

/**
 * An interface that provides a data management interface to the Merprecostsheetrowmaterials table.
 */
public interface MerprecostsheetrowmaterialsDao extends GenericDao<Merprecostsheetrowmaterials, MerprecostsheetrowmaterialsId> {
	public List<Merprecostsheetrowmaterials> getAll(Merprecostsheet merprecostsheet);
	
	public List<Merprecostsheetrowmaterials> getAll(Merprecostsheet merprecostsheet,String category);

	public List<Merprecostsheetrowmaterials> getAll(MerprecostsheetId id,String category) ;
	
	public BigDecimal getNext(Merprecostsheet merprecostsheet);

	public List<Object> getAllCost(MerprecostsheetId merprecostsheetid, String category,String fld);
	
	public List<Merprecostsheetrowmaterials> getAllShell(Merprecostsheet merprecostsheet,String category);
	public List<Merprecostsheetrowmaterials> getAll( Merprecostsheet merprecostsheet, String category, String Itemtype, String Itemcode);
}