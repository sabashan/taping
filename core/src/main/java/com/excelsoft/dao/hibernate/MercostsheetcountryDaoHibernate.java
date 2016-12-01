package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mercostsheetcountry;
import com.excelsoft.model.MercostsheetcountryId;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.dao.MercostsheetcountryDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mercostsheetcountryDao")
public class MercostsheetcountryDaoHibernate extends GenericDaoHibernate<Mercostsheetcountry, MercostsheetcountryId> implements MercostsheetcountryDao {

    public MercostsheetcountryDaoHibernate() {
        super(Mercostsheetcountry.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetcountry> getAll(Mercostsheethdr mercostsheethdr) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Mercostsheetcountry c where c.mercostsheethdr=:mercostsheethdr ").
				setParameter("mercostsheethdr", mercostsheethdr).list();
	}
}
