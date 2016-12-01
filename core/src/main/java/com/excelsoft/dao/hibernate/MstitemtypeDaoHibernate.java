package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mstitemtype;
import com.excelsoft.dao.MstitemtypeDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mstitemtypeDao")
@SuppressWarnings("unchecked")
public class MstitemtypeDaoHibernate extends GenericDaoHibernate<Mstitemtype, String> implements MstitemtypeDao {

    public MstitemtypeDaoHibernate() {
        super(Mstitemtype.class);
    }
    
    
    
	public List<String> getAllId(String category){
		return getSession()
				 .createQuery("select distinct i.itemType from Mstitemtype i where i.category=:category")
				 .setParameter("category", category)
				.list();
	}



	@Override
	public List<Mstitemtype> getAll(String category, String q) {
		return getSession()
				 .createQuery(" from Mstitemtype i where i.category=:category and "+getLike())
				 .setParameter("category", category)
				 .setParameter("filed", "%"+q+"%")
				.list();
	}
	
	@Override
	public List<Mstitemtype> getAll(String category) {
		return getSession()
				 .createQuery(" from Mstitemtype i where i.category=:category ")
				 .setParameter("category", category)
				.list();
	}
	private String getLike(){
		String likeq="";
		likeq ="( i.itemType like :filed or "
		+"i.itemGroup like :filed or "
		+"i.type1Name like :filed or "
		+"i.type2Name like :filed or "
		+"i.type3Name like :filed or "
		+"i.type4Name like :filed or "
		+"i.type5Name like :filed or "
		+"i.type6Name like :filed or "
		+"i.accCode like :filed or "
		+"i.navisionTaskcode  like :filed or "
		+"i.itemTypeDesc  like :filed ) ";
		return likeq;
	}
}
