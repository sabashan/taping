package com.excelsoft.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.model.Mstcompany;
import com.excelsoft.dao.MstcompanyDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mstcompanyDao")
@SuppressWarnings("unchecked")
public class MstcompanyDaoHibernate extends GenericDaoHibernate<Mstcompany, String> implements MstcompanyDao {

    public MstcompanyDaoHibernate() {
        super(Mstcompany.class);
    }

	@Override
	public List<Mstcompany> getAllbyquery(String query) {
		
		String url="from Mstcompany c";
		if(!query.equals("NOT")){
			String url2 ="  "
				+ " c.compCode like '%"+query+ "%' or "
				+ " c.auditCompAddress like '%"+query+ "%' or "
				+ " c.assetIdPrefix like '%"+query+ "%' or "
				+ " c.auditCompName like '%"+query+ "%' or "
				+ " c.compAddress like '%"+query+ "%' or "
				+ " c.emailAddress like '%"+query+ "%' ";
		
			url = url+" where  "+url2;
		}
		url=url+"order by c.compCode asc";
		log.debug(url);
		try{
			List<Mstcompany> strings=getSession().createQuery(url).list();
		 return strings;
		}catch (Exception e) {
			log.debug(e);
			return new ArrayList <Mstcompany>();
		}
	}

	
	@Override
	public List<String> getCompanycode() {
		return getSession().createQuery("select c.compCode from Mstcompany c order by c.compCode  asc").list();
	}
}
