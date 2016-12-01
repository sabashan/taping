package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mststyleheader;
import com.excelsoft.model.Mststylepicture;
import com.excelsoft.model.MststylepictureId;
import com.excelsoft.dao.MststylepictureDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mststylepictureDao")
public class MststylepictureDaoHibernate extends GenericDaoHibernate<Mststylepicture, MststylepictureId> implements MststylepictureDao {

    public MststylepictureDaoHibernate() {
        super(Mststylepicture.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Mststylepicture> getZero(Mststyleheader mststyleheader) {
		return getSession()
				.createQuery("from Mststylepicture c where c.mststyleheader =:mststyleheader And c.sequenceNo=0 ORDER BY c.sequenceNo ")
				.setParameter("mststyleheader", mststyleheader).list(); 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Mststylepicture> getAll(Mststyleheader mststyleheader) {
		return getSession()
				.createQuery("from Mststylepicture c where c.mststyleheader =:mststyleheader ORDER BY c.sequenceNo ")
				.setParameter("mststyleheader", mststyleheader).list(); 
	}
}
