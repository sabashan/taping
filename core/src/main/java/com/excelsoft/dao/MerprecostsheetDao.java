package com.excelsoft.dao;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;
import com.excelsoft.model.Mststyleheader;

/**
 * An interface that provides a data management interface to the Merprecostsheet table.
 */
public interface MerprecostsheetDao extends GenericDao<Merprecostsheet, MerprecostsheetId> {

	
	public List<Merprecostsheet> getAll(Mststyleheader mststyleheader,
			String season,String query);
	public List<Merprecostsheet> getAll(String compCode, String locationCode,
			String custCode, String depCode, String styleId, String season,String costsheetType,String query);
	public List<Merprecostsheet> getAllDue(String flag,String User);
	
	public List<MerprecostsheetId> getAllids(Mststyleheader mststyleheader,
			String season,String query);
	
	public List<BigDecimal> getAllVersion(String costSheetTytpe,String costsheetNO) ;
	
	public List<String> getAllids(String compCode, String locationCode,
			String custCode, String depCode, String styleId,String season ,String costsheetType);
	
	public List<Merprecostsheet> getAll(String flag);
	
	public Mststyleheader getStyle(MerprecostsheetId id);
}