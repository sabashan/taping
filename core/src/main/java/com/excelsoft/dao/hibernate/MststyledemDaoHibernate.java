package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mststyledem;
import com.excelsoft.model.MststyledemId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.dao.MststyledemDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mststyledemDao")
public class MststyledemDaoHibernate extends
		GenericDaoHibernate<Mststyledem, MststyledemId> implements
		MststyledemDao {

	public MststyledemDaoHibernate() {
		super(Mststyledem.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mststyledem> getAll(Mststyleheader mststyleheader) {
		return getSession()
				.createQuery("from Mststyledem c where c.mststyleheader =:mststyleheader ")
				.setParameter("mststyleheader", mststyleheader).list();   
	}
}
