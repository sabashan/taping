package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Mststyleheader;

/**
 * An interface that provides a data management interface to the Mercostsheethdr table.
 */
public interface MercostsheethdrDao extends GenericDao<Mercostsheethdr, MercostsheethdrId> {

	public List<Mercostsheethdr> getAll(Mststyleheader mststyleheader,String season,String query) ;
	
	public List<Mercostsheethdr> getAlldue(String flag,String UserId) ;

	public List<Mercostsheethdr> getAll(String flag);
	
	public Mststyleheader getStyle(MercostsheethdrId id);
	
	public Merprecostsheet getprecostsheet(MercostsheethdrId id);
	
}