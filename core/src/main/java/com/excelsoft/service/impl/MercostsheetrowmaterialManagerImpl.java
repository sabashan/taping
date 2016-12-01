package com.excelsoft.service.impl;

import com.excelsoft.dao.MercostsheetrowmaterialDao;
import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;
import com.excelsoft.model.Mercostsheetrowmaterial;
import com.excelsoft.model.MercostsheetrowmaterialId;
import com.excelsoft.service.MercostsheetrowmaterialManager;
import com.excelsoft.service.impl.GenericManagerImpl;
import com.excelsoft.util.ConvertUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

@Service("mercostsheetrowmaterialManager")
@WebService(serviceName = "MercostsheetrowmaterialService", endpointInterface = "com.excelsoft.service.MercostsheetrowmaterialManager")
public class MercostsheetrowmaterialManagerImpl extends GenericManagerImpl<Mercostsheetrowmaterial, MercostsheetrowmaterialId> implements MercostsheetrowmaterialManager {
    MercostsheetrowmaterialDao mercostsheetrowmaterialDao;

    @Autowired
    public MercostsheetrowmaterialManagerImpl(MercostsheetrowmaterialDao mercostsheetrowmaterialDao) {
        super(mercostsheetrowmaterialDao);
        this.mercostsheetrowmaterialDao = mercostsheetrowmaterialDao;
    }
    @Override
	public List<Mercostsheetrowmaterial> getAll(String costSheetNo,
			String versionNo, String costsheetType, String category) {
		MercostsheethdrId id=new MercostsheethdrId(costSheetNo, ConvertUtil.getDecimal(versionNo), costsheetType);
		return this.mercostsheetrowmaterialDao.getAll(id,category);
	}
    
    @Override
	public List<Mercostsheetrowmaterial> getAll(String costSheetNo,
			String versionNo, String costsheetType) {
		MercostsheethdrId id=new MercostsheethdrId(costSheetNo, ConvertUtil.getDecimal(versionNo), costsheetType);
		return this.mercostsheetrowmaterialDao.getAll(id);
	} 
    @Override
    public List<Mercostsheetrowmaterial> getAll(){
    	return this.mercostsheetrowmaterialDao.getAll();
    }
	@Override
	public List<Mercostsheetrowmaterial> getAllShell(
			Mercostsheethdr mercostsheethdr, String category) {
		return this.mercostsheetrowmaterialDao.getAllShell(mercostsheethdr,category);
	}
	
	@Override
	public BigDecimal getNext(
			Mercostsheetgroup mercostsheetgroup) {
		
		return this.mercostsheetrowmaterialDao.getNext(mercostsheetgroup);
	}
	
	public Mercostsheetrowmaterial get(MercostsheetrowmaterialId id){
		return this.mercostsheetrowmaterialDao.get(id);
	}
	
	@Override
	public Mercostsheetrowmaterial getAll(String costSheetNo, String versionNo,
			String costsheetType, String category, String costSheetRowMatCode,
			String component, String groupId) {
		MercostsheetrowmaterialId id=new MercostsheetrowmaterialId(ConvertUtil.getlongs(groupId), costSheetNo, 
				ConvertUtil.getDecimal(versionNo), costsheetType, ConvertUtil.getDecimal(costSheetRowMatCode), component) ;
		return this.mercostsheetrowmaterialDao.get(id);
	}
	
	@Override
	public List<Mercostsheetrowmaterial> getAllCost(String costSheetNo, String versionNo,
			String costsheetType, String category, String groupName) {
		//MercostsheethdrId id=new MercostsheethdrId(costSheetNo, ConvertUtil.getDecimal(versionNo), costsheetType);
		return this.mercostsheetrowmaterialDao.getAllCost(costSheetNo,ConvertUtil.getDecimal(versionNo),costsheetType,category,groupName);
	}
	@Override
	public List<Mercostsheetrowmaterial> getAll(String costSheetNo,
			String versionNo, String costsheetType, String[] types,String[] values) {
		MercostsheethdrId id=new MercostsheethdrId(costSheetNo, ConvertUtil.getDecimal(versionNo), costsheetType);
		return this.mercostsheetrowmaterialDao.getAll(id,types, values);
	}
	@Override
	public List<Object> getAll(String costSheetNo, String versionNo,
			String costsheetType, String category, String fld) {
		return this.mercostsheetrowmaterialDao.getAll( costSheetNo,  versionNo,costsheetType,  category,  fld);
	}
	@Override
	public List<Mercostsheetrowmaterial> getAll(
			Mercostsheethdr Mercostsheethdr, String category, String Itemtype,
			String Itemcode) {
		return this.mercostsheetrowmaterialDao.getAll(Mercostsheethdr,category,Itemtype,Itemcode);
	}
}