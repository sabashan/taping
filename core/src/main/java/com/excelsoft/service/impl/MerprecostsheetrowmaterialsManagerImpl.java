package com.excelsoft.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.dao.MerprecostsheetrowmaterialsDao;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.MerprecostsheetId;
import com.excelsoft.model.Merprecostsheetrowmaterials;
import com.excelsoft.model.MerprecostsheetrowmaterialsId;
import com.excelsoft.service.MerprecostsheetrowmaterialsManager;
import com.excelsoft.service.impl.GenericManagerImpl;
import com.excelsoft.util.ConvertUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("merprecostsheetrowmaterialsManager")
@WebService(serviceName = "MerprecostsheetrowmaterialsService", endpointInterface = "com.excelsoft.service.MerprecostsheetrowmaterialsManager")
public class MerprecostsheetrowmaterialsManagerImpl extends GenericManagerImpl<Merprecostsheetrowmaterials, MerprecostsheetrowmaterialsId> implements MerprecostsheetrowmaterialsManager {
    MerprecostsheetrowmaterialsDao merprecostsheetrowmaterialsDao;

    @Autowired
    public MerprecostsheetrowmaterialsManagerImpl(MerprecostsheetrowmaterialsDao merprecostsheetrowmaterialsDao) {
        super(merprecostsheetrowmaterialsDao);
        this.merprecostsheetrowmaterialsDao = merprecostsheetrowmaterialsDao;
    }
    @Override
    public List<Merprecostsheetrowmaterials> getAll(Merprecostsheet merprecostsheet){
    	return this.merprecostsheetrowmaterialsDao.getAll(merprecostsheet);
    }
    @Override
    public List<Merprecostsheetrowmaterials> getAll(Merprecostsheet merprecostsheet,String category){
    	return this.merprecostsheetrowmaterialsDao.getAll(merprecostsheet,category);
    }
    
    @Override
	public List<Merprecostsheetrowmaterials> getAll() {
		 return this.merprecostsheetrowmaterialsDao.getAll();
	}
    
	@Override
	public Merprecostsheetrowmaterials get(
			MerprecostsheetrowmaterialsId merprecostsheetrowmaterialsId) {
		 return this.merprecostsheetrowmaterialsDao.get(merprecostsheetrowmaterialsId);
	}
	@Override
	public Merprecostsheetrowmaterials get(String preCostSheetNo,
			String versionNo, String costsheetType,
			String precostsheetRowMatCode, String component) {
		MerprecostsheetrowmaterialsId id=new MerprecostsheetrowmaterialsId(preCostSheetNo,ConvertUtil.getDecimal(versionNo), costsheetType, ConvertUtil.getDecimal(precostsheetRowMatCode),component);
		 return this.merprecostsheetrowmaterialsDao.get(id);
	}
	@Override
	public List<Merprecostsheetrowmaterials> getAll(String preCostSheetNo,
			String versionNo, String costsheetType, String category) {
		MerprecostsheetId id=new MerprecostsheetId(preCostSheetNo, ConvertUtil.getDecimal(versionNo), costsheetType);
		return this.merprecostsheetrowmaterialsDao.getAll(id,category);
	}
	
	
	@Override
	public BigDecimal getNext(
			Merprecostsheet merprecostsheet) {
		
		return this.merprecostsheetrowmaterialsDao.getNext(merprecostsheet);
	}
	@Override
	public List<Object> getAllCost(String preCostSheetNo, String versionNo,
			String costsheetType, String category,String fld) {
		MerprecostsheetId id=new MerprecostsheetId(preCostSheetNo, ConvertUtil.getDecimal(versionNo), costsheetType);
		return this.merprecostsheetrowmaterialsDao.getAllCost(id,category,fld);
	}
	@Override
	public List<Merprecostsheetrowmaterials> getAllShell(
			Merprecostsheet merprecostsheet , String category) {
		return this.merprecostsheetrowmaterialsDao.getAllShell(merprecostsheet,category);
	}
	@Override
	public List<Merprecostsheetrowmaterials> getAll(
			Merprecostsheet merprecostsheet, String category, String Itemtype,
			String Itemcode) {
		return this.merprecostsheetrowmaterialsDao.getAll(merprecostsheet,category,Itemtype,Itemcode);
	}
}