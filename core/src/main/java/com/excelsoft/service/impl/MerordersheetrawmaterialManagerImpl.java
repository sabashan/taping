package com.excelsoft.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MerordersheetrawmaterialDao;
import com.excelsoft.model.MerordersheethdrId;
import com.excelsoft.model.Merordersheetrawmaterial;
import com.excelsoft.model.MerordersheetrawmaterialId;
import com.excelsoft.service.MerordersheetrawmaterialManager;
import com.excelsoft.util.ConvertUtil;

@Service("merordersheetrawmaterialManager")
@WebService(serviceName = "MerordersheetrawmaterialService", endpointInterface = "com.excelsoft.service.MerordersheetrawmaterialManager")
public class MerordersheetrawmaterialManagerImpl extends GenericManagerImpl<Merordersheetrawmaterial, MerordersheetrawmaterialId> implements MerordersheetrawmaterialManager {
    MerordersheetrawmaterialDao merordersheetrawmaterialDao;

    @Autowired
    public MerordersheetrawmaterialManagerImpl(MerordersheetrawmaterialDao merordersheetrawmaterialDao) {
        super(merordersheetrawmaterialDao);
        this.merordersheetrawmaterialDao = merordersheetrawmaterialDao;
    }

	@Override
	public Merordersheetrawmaterial get(String planingOrdersheetNo,
			String orderType, String rowMaterialNo) {
		
		MerordersheetrawmaterialId id=new MerordersheetrawmaterialId(planingOrdersheetNo, ConvertUtil.getDecimal(rowMaterialNo), orderType);
		return this.merordersheetrawmaterialDao.get(id) ;
	}

	@Override
	public List<Merordersheetrawmaterial> getAll(String planingOrdersheetNo,
			String orderType, String category){
		return this.merordersheetrawmaterialDao.getAll(planingOrdersheetNo, orderType, category) ;
	}
	
	@Override
	public Merordersheetrawmaterial get(MerordersheetrawmaterialId id) {
		return this.merordersheetrawmaterialDao.get(id) ;
	}
	@Override
	public List<Merordersheetrawmaterial> getAll() {
		return this.merordersheetrawmaterialDao.getAll() ;
	}

	@Override
	public BigDecimal getNext(MerordersheethdrId id) {
		return this.merordersheetrawmaterialDao.getNext(id);
	}

	@Override
	public List<Merordersheetrawmaterial> getAll(String planingOrdersheetNo,
			String orderType) {
		MerordersheethdrId id =new MerordersheethdrId(planingOrdersheetNo, orderType);
		return this.merordersheetrawmaterialDao.getAll(id);
	}

	@Override
	public List<Merordersheetrawmaterial> getAll(MerordersheethdrId id) {
		return this.merordersheetrawmaterialDao.getAll(id);
	}

	@Override
	public List<Merordersheetrawmaterial> getAll(String planingOrdersheetNo,
			String orderType, String category, String query) {
		return this.merordersheetrawmaterialDao.getAll(planingOrdersheetNo, orderType, category,query) ;
	}
}