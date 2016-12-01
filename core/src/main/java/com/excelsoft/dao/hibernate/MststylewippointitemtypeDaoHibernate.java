package com.excelsoft.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.model.Mststylewippointitemtype;
import com.excelsoft.model.MststylewippointitemtypeId;
import com.excelsoft.dao.MststylewippointitemtypeDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mststylewippointitemtypeDao")
public class MststylewippointitemtypeDaoHibernate extends GenericDaoHibernate<Mststylewippointitemtype, MststylewippointitemtypeId> implements MststylewippointitemtypeDao {

    public MststylewippointitemtypeDaoHibernate() {
        super(Mststylewippointitemtype.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Mststylewippointitemtype> getAllWippointitemtype(String itemType) {
		// TODO Auto-generated method stub
		List<Mststylewippointitemtype> mststylewippointitemtypes = new ArrayList<Mststylewippointitemtype>();
		try {
			mststylewippointitemtypes = getSession()
					.createQuery(
							"FROM Mststylewippointitemtype w"
							+ " WHERE w.mstitemtype.itemType=:itemType")
						.setParameter("itemType",itemType).list();
			log.debug(mststylewippointitemtypes.toString());
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return mststylewippointitemtypes;
	}

}
