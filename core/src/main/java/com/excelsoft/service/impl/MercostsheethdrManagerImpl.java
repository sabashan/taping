package com.excelsoft.service.impl;

import com.excelsoft.dao.MercostsheethdrDao;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;
import com.excelsoft.model.Merprecostsheet;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.service.MercostsheethdrManager;
import com.excelsoft.service.impl.GenericManagerImpl;
import com.excelsoft.util.ConvertUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.jws.WebService;

@Service("mercostsheethdrManager")
@WebService(serviceName = "MercostsheethdrService", endpointInterface = "com.excelsoft.service.MercostsheethdrManager")
public class MercostsheethdrManagerImpl extends GenericManagerImpl<Mercostsheethdr, MercostsheethdrId> implements MercostsheethdrManager {
    MercostsheethdrDao mercostsheethdrDao;

    @Autowired
    public MercostsheethdrManagerImpl(MercostsheethdrDao mercostsheethdrDao) {
        super(mercostsheethdrDao);
        this.mercostsheethdrDao = mercostsheethdrDao;
    }

	@Override
	public List<Mercostsheethdr> getAll(Mststyleheader mststyleheader,
			String season, String query) {
		return mercostsheethdrDao.getAll(mststyleheader, season, query);
	}
	
	@Override
	public List<Mercostsheethdr> getAlldue(String flag,String UserId) {
		return mercostsheethdrDao.getAlldue(flag,UserId);
	}
	
	@Override
	public List<Mercostsheethdr> getAll(String flag) {
		return mercostsheethdrDao.getAll(flag);
	}

	@Override
	public Mststyleheader getStyle(MercostsheethdrId id) {
		return this.mercostsheethdrDao.getStyle(id);
	}

	@Override
	public Merprecostsheet getprecostsheet(MercostsheethdrId id) {
		return this.mercostsheethdrDao.getprecostsheet(id);
	}

	@Override
	public Merprecostsheet getprecostsheet(String costsheetNo, String version,
			String costsheetType) {
		MercostsheethdrId id=new MercostsheethdrId(costsheetNo, ConvertUtil.getDecimal(version), costsheetType);
		return this.mercostsheethdrDao.getprecostsheet(id);
	}
}