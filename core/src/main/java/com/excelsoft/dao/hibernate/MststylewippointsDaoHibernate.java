package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mststylewippoints;
import com.excelsoft.dao.MststylewippointsDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mststylewippointsDao")
public class MststylewippointsDaoHibernate extends
		GenericDaoHibernate<Mststylewippoints, String> implements
		MststylewippointsDao {

	public MststylewippointsDaoHibernate() {
		super(Mststylewippoints.class);
	}

	@Override
	public Mststylewippoints getWipPointById(String wippointCode) {
		return this.get(wippointCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mststylewippoints> getAllActive() {
		return getSession().createQuery("FROM Mststylewippoints w WHERE w.activeWip = true ORDER BY sequnceNo ASC ").list();
	}
}
