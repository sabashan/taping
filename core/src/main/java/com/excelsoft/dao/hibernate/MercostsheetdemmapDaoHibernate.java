package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mercostsheetdemmap;
import com.excelsoft.model.MercostsheetdemmapId;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.dao.MercostsheetdemmapDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mercostsheetdemmapDao")
public class MercostsheetdemmapDaoHibernate extends GenericDaoHibernate<Mercostsheetdemmap, MercostsheetdemmapId> implements MercostsheetdemmapDao {

    public MercostsheetdemmapDaoHibernate() {
        super(Mercostsheetdemmap.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetdemmap> getDemmapsFromCosting(Mercostsheethdr mercostsheethdr) {
		// TODO Auto-generated method stub
		return getSession().createQuery("from Mercostsheetdemmap m  INNER JOIN fetch  m.mercostsheethdr c where m.mercostsheethdr=:mercostsheethdr")
				.setParameter("mercostsheethdr", mercostsheethdr)
				.list();  
	}
}
