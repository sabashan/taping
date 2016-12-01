package com.excelsoft.dao;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.MerordersheethdrId;
import com.excelsoft.model.Merordersheetrawmaterial;
import com.excelsoft.model.MerordersheetrawmaterialId;

/**
 * An interface that provides a data management interface to the Merordersheetrawmaterial table.
 */
public interface MerordersheetrawmaterialDao extends GenericDao<Merordersheetrawmaterial, MerordersheetrawmaterialId> {
	
	public List<Merordersheetrawmaterial> getAll(String planingOrdersheetNo
			,String orderType,String category);
	
	public BigDecimal getNext(MerordersheethdrId id);
	
	public List<Merordersheetrawmaterial> getAll(MerordersheethdrId id);
	
	public Merordersheetrawmaterial get(MerordersheetrawmaterialId id);
	
	public List<Merordersheetrawmaterial> getAll(String planingOrdersheetNo,
			String orderType, String category, String query);
}