package com.excelsoft.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.excelsoft.dao.MstoperationDao;
import com.excelsoft.model.Mstoperation;

@Repository("mstoperationDao")
@SuppressWarnings("unchecked")
public class MstoperationDaoHibernate extends GenericDaoHibernate<Mstoperation, Integer> implements MstoperationDao {

    public MstoperationDaoHibernate() {
        super(Mstoperation.class);
    }

	
	@Override
	public List<Mstoperation> getAllByType(String type) {
		return getSession()
				 .createQuery("from Mstoperation s where s.operationType=:operationType ")
				 .setParameter("operationType", type)
				 .list();
		           
	}


	@Override
	public List<String> getAllTypes(String type) {
		return getSession()
				 .createQuery("select distinct s.operationType from Mstoperation s  where s.operationType=:operationType ")
				 .setParameter("operationType", type)
				 .list();
	}
	
	@Override
	public List<String> getAllTypes() {
		return getSession()
				 .createQuery("select distinct s.operationType from Mstoperation s ")
				 .list();
	}

	@Override
	public List<Mstoperation> getAllByTypeAnd(String type, String Qary) {
		Qary="%"+Qary+"%";
		return getSession()
				 .createQuery("from Mstoperation s where s.operationType=:operationType and "
				 		+ "(locationCode like :Qary or operationDesc like :Qary "
				 		+ " operationDescBref like :Qary or machineTypeDefault "
				 		+ "like :Qary or sewingOperation like :Qary )")
				 .setParameter("operationType", type)
				 .setParameter("operationType", Qary)
				 .list();
	}
}
