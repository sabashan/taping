package com.excelsoft.service.impl;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelsoft.dao.MercostsheetdemmapDao;
import com.excelsoft.model.Mercostsheetdemmap;
import com.excelsoft.model.MercostsheetdemmapId;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.service.MercostsheetdemmapManager;

@Service("mercostsheetdemmapManager")
@WebService(serviceName = "MercostsheetdemmapService", endpointInterface = "com.excelsoft.service.MercostsheetdemmapManager")
public class MercostsheetdemmapManagerImpl extends GenericManagerImpl<Mercostsheetdemmap, MercostsheetdemmapId> implements MercostsheetdemmapManager {
    MercostsheetdemmapDao mercostsheetdemmapDao;

    @Autowired
    public MercostsheetdemmapManagerImpl(MercostsheetdemmapDao mercostsheetdemmapDao) {
        super(mercostsheetdemmapDao);
        this.mercostsheetdemmapDao = mercostsheetdemmapDao;
    }

	@Override
	public List<Mercostsheetdemmap> getDemmapsFromCosting(
			Mercostsheethdr mercostsheethdr) {
		// TODO Auto-generated method stub
		return mercostsheetdemmapDao.getDemmapsFromCosting(mercostsheethdr);
	}
}