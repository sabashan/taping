package com.excelsoft.dao;

import java.util.List;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.model.Merordersheethdr;
import com.excelsoft.model.MerordersheethdrId;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Mststyleheader;

/**
 * An interface that provides a data management interface to the Merordersheethdr table.
 */
public interface MerordersheethdrDao extends GenericDao<Merordersheethdr, MerordersheethdrId> {
	
	public List<Merordersheethdr> getAll(String query,Mststyleheader mststyleheader);
	
	public List<Merordersheethdr> getAll(String query,Mststyleheader mststyleheader,Boolean isProcess);
	
	public List<Merordersheethdr> getAll(String query,String status);
	
	public List<Merordersheethdr> getAll(String query,String status,String userid);
	
	public List<Merordersheethdr> getAll(String query,String status,String userid,Boolean isProcess);
	
	public List<String> GetByid(String custCode, String locationCode, String depCode, String styleId,
			String compCode,  String season);
	
	public List<Merordersheethdr> getAll(String compCode,String locationCode,
			String custCode, String depCode, String styleId, String season,String query);
	
	//public List<Merordersheethdr> getAll(String flag);
	
}