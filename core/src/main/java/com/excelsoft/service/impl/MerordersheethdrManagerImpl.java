package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MerordersheethdrDao;
import com.excelsoft.model.Merordersheethdr;
import com.excelsoft.model.MerordersheethdrId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.service.MerordersheethdrManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("merordersheethdrManager")
@WebService(serviceName = "MerordersheethdrService", endpointInterface = "com.excelsoft.service.MerordersheethdrManager")
public class MerordersheethdrManagerImpl extends GenericManagerImpl<Merordersheethdr, MerordersheethdrId> implements MerordersheethdrManager {
    MerordersheethdrDao merordersheethdrDao;

    @Autowired
    public MerordersheethdrManagerImpl(MerordersheethdrDao merordersheethdrDao) {
        super(merordersheethdrDao);
        this.merordersheethdrDao = merordersheethdrDao;
    }

	@Override
	public List<Merordersheethdr> getAll(String query,
			Mststyleheader mststyleheader) {
		return merordersheethdrDao.getAll(query,mststyleheader);
	}

	@Override
	public List<Merordersheethdr> getAll(String query, String status) {
		return merordersheethdrDao.getAll(query,status);
	}

	@Override
	public List<Merordersheethdr> getAll(String query, String status,
			String userid) {
		return merordersheethdrDao.getAll(query,status,userid);
	}

	@Override
	public List<Merordersheethdr> getAll(String query,
			Mststyleheader mststyleheader, Boolean isProcess) {
		return merordersheethdrDao.getAll(query,mststyleheader,isProcess);
	}

	@Override
	public List<Merordersheethdr> getAll(String query, String status,
			String userid, Boolean isProcess) {
		return merordersheethdrDao.getAll(query,status,userid,isProcess);
	}

	

	@Override
	public List<String> get(String custCode, String locationCode,
			String depCode, String styleId, String compCode, String season) {
		log.debug(custCode);
		log.debug(locationCode);
		log.debug(depCode);
		log.debug(styleId);
		log.debug(compCode);
		log.debug(season);
		
		return merordersheethdrDao.GetByid(custCode, locationCode, depCode, styleId, compCode, season);
	}

	@Override
	public List<Merordersheethdr> getAll(String compCode, String locationCode,
			String custCode, String depCode, String styleId, String season,
			String query) {
		
	
		
		return merordersheethdrDao.getAll(compCode, locationCode, custCode, depCode, styleId, season,query);
	}

	/*public Merordersheethdr get(String custCode, String locationCode,
			String depCode, String styleId, String season) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merordersheethdr get(String custCode,
			String locationCode, String depCode, String styleId, String season) {
		// TODO Auto-generated method stub
		return null;
	}*/
}