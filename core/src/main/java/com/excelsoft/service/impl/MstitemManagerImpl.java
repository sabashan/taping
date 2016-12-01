package com.excelsoft.service.impl;

import java.util.List;

import com.excelsoft.dao.MstitemDao;
import com.excelsoft.model.Mstitem;
import com.excelsoft.model.MstitemId;
import com.excelsoft.service.MstitemManager;
import com.excelsoft.service.impl.GenericManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

@Service("mstitemManager")
@WebService(serviceName = "MstitemService", endpointInterface = "com.excelsoft.service.MstitemManager")
public class MstitemManagerImpl extends GenericManagerImpl<Mstitem, MstitemId> implements MstitemManager {
    MstitemDao mstitemDao;

    @Autowired
    public MstitemManagerImpl(MstitemDao mstitemDao) {
        super(mstitemDao);
        this.mstitemDao = mstitemDao;
    }

    @Override
	public Mstitem get(MstitemId id) {
		return this.mstitemDao.get(id);
	}
	@Override
	public Mstitem get(String itemType, String itemCode) {
		MstitemId id=new MstitemId(itemType, itemCode);
		return this.mstitemDao.get(id);
	}
	@Override
	public List<Mstitem> getAll() {
		return this.mstitemDao.getAll();
	}
	@Override
	public List<String> getAllid(String ItemType) {
		return this.mstitemDao.getAllid(ItemType);
	}

	@Override
	public List<Mstitem> getAll(String ItemType) {
		return this.mstitemDao.getAll(ItemType);
	}

	@Override
	public List<Mstitem> getAll(String ItemType, String q) {
		return this.mstitemDao.getAll(ItemType,  q);
	}
}