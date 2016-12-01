package com.excelsoft.dao.hibernate;



import java.util.List;

import com.excelsoft.model.Mstmachinetype;
import com.excelsoft.dao.MstmachinetypeDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;
@SuppressWarnings("unchecked")
@Repository("mstmachinetypeDao")
public class MstmachinetypeDaoHibernate extends GenericDaoHibernate<Mstmachinetype, String> implements MstmachinetypeDao {

    public MstmachinetypeDaoHibernate() {
        super(Mstmachinetype.class);
    }
	@Override
	public List<Mstmachinetype> getmachintype(String queary) {
		queary="%"+queary+"%";
		return getSession()
		 .createQuery("from Mstmachinetype s where s.typeCode=:queary or "
		 		+ "	s.description like :queary or s.operationStdLength like :queary or"
		 		+ " s.operationStdLengthUom like :queary or s.userId  like :queary ")
		 .setParameter("queary", queary)
		 .list();
	}
	@Override
	public List<String> getmachintype() {
		return getSession()
				 .createQuery("select s.typeCode from Mstmachinetype s ")
				 .list();
	}
}
