package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mercostsheetcurrency;
import com.excelsoft.model.MercostsheetcurrencyId;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.dao.MercostsheetcurrencyDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mercostsheetcurrencyDao")
public class MercostsheetcurrencyDaoHibernate extends GenericDaoHibernate<Mercostsheetcurrency, MercostsheetcurrencyId> implements MercostsheetcurrencyDao {

    public MercostsheetcurrencyDaoHibernate() {
        super(Mercostsheetcurrency.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetcurrency> getAll(Mercostsheethdr mercostsheethdr) {
		return getSession().createQuery("from Mercostsheetcurrency c where c.mercostsheethdr=:mercostsheethdr ").
				setParameter("mercostsheethdr", mercostsheethdr).list();
	}
}
