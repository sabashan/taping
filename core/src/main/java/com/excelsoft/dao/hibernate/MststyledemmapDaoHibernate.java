package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mststyledemmap;
import com.excelsoft.model.MststyledemmapId;
import com.excelsoft.model.Mststyleheader;
import com.excelsoft.dao.MststyledemmapDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mststyledemmapDao")
public class MststyledemmapDaoHibernate extends
		GenericDaoHibernate<Mststyledemmap, MststyledemmapId> implements
		MststyledemmapDao {

	public MststyledemmapDaoHibernate() {
		super(Mststyledemmap.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mststyledemmap> getAll(Mststyleheader mststyleheader) {
		return getSession()
				.createQuery("from Mststyledemmap c where c.mststyleheader =:mststyleheader ")
				.setParameter("mststyleheader", mststyleheader).list();   
	}
}
