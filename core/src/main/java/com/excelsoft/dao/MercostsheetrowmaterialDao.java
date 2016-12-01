package com.excelsoft.dao;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;
import com.excelsoft.model.Mercostsheetrowmaterial;
import com.excelsoft.model.MercostsheetrowmaterialId;

/**
 * An interface that provides a data management interface to the Mercostsheetrowmaterial table.
 */
public interface MercostsheetrowmaterialDao extends GenericDao<Mercostsheetrowmaterial, MercostsheetrowmaterialId> {

	public List<Mercostsheetrowmaterial> getAll(MercostsheethdrId mercostsheethdrId,String category);
	
	public Mercostsheetrowmaterial get(MercostsheetrowmaterialId id);
	
	public List<Mercostsheetrowmaterial> getAllShell(Mercostsheethdr mercostsheethdr,String category);

	public BigDecimal getNext(Mercostsheetgroup mercostsheetgroup);
	
	public List<Mercostsheetrowmaterial> getAllCost(String costSheetNo, BigDecimal versionNo,
			String costsheetType, String category, String groupName);

	public List<Mercostsheetrowmaterial> getAll(MercostsheethdrId mercostsheethdrId);
	
	public List<Mercostsheetrowmaterial> getAll(MercostsheethdrId mercostsheethdrId,String [] types,String[] values);
	
	public List<Object> getAll(String costSheetNo, String versionNo,String costsheetType, String category, String fld);
	
	public List<Mercostsheetrowmaterial> getAll(
			Mercostsheethdr Mercostsheethdr, String category, String Itemtype,
			String Itemcode) ;
	
}