package com.excelsoft.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.dao.MerprecostsheetDao;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.service.MerprecostsheetManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("merprecostsheetManager")
@WebService(serviceName = "MerprecostsheetService", endpointInterface = "com.excelsoft.service.MerprecostsheetManager")
public class MerprecostsheetManagerImpl extends GenericManagerImpl<Merprecostsheet, MerprecostsheetId> implements MerprecostsheetManager {
    MerprecostsheetDao merprecostsheetDao;

    @Autowired
    public MerprecostsheetManagerImpl(MerprecostsheetDao merprecostsheetDao) {
        super(merprecostsheetDao);
        this.merprecostsheetDao = merprecostsheetDao;
    }
    @Override
	public List<Merprecostsheet> getallsearch(String q,String [] ids) {
		return this.merprecostsheetDao.getallsearch(q, ids);
	}
	@Override
	public List<Merprecostsheet> getAll(Mststyleheader mststyleheader,
			String season, String query) {
		return merprecostsheetDao.getAll(mststyleheader, season, query);
	}
	@Override
	public List<Merprecostsheet> getAllDue(String flag, String User) {
		return merprecostsheetDao.getAllDue(flag, User);
	}
	@Override
	public List<Merprecostsheet> getAll(String compCode, String locationCode,
			String custCode, String depCode, String styleId, String season,
			String costsheetType,String query) {
	
		return merprecostsheetDao.getAll(compCode, locationCode, custCode, depCode, styleId, season, costsheetType,query);
	}
	
	@Override
	public List<MerprecostsheetId> getAllids(Mststyleheader mststyleheader,
			String season, String query) {
		return merprecostsheetDao.getAllids(mststyleheader, season, query);
	}
	
	public List<BigDecimal> getAllVersion(String costSheetTytpe,String costsheetNO) {
		return this.merprecostsheetDao.getAllVersion( costSheetTytpe, costsheetNO) ;
	}
	@Override
	public List<String> getAllids(String compCode, String locationCode,
			String custCode, String depCode, String styleId, String season,String costsheetType) {
		return merprecostsheetDao.getAllids(compCode, locationCode, custCode, depCode, styleId,season,costsheetType);
	}
	@Override
	public List<Merprecostsheet> getAll(String flag) {
		return merprecostsheetDao.getAll(flag);
	}
	@Override
	public Mststyleheader getStyle(MerprecostsheetId id) {
		// TODO Auto-generated method stub
		return merprecostsheetDao.getStyle(id);
	}
}