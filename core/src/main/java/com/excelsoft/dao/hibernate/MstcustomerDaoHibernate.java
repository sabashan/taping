package com.excelsoft.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.model.Mstcustomer;
import com.excelsoft.dao.MstcustomerDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;
@SuppressWarnings("unchecked")
@Repository("mstcustomerDao")
public class MstcustomerDaoHibernate extends GenericDaoHibernate<Mstcustomer, String> implements MstcustomerDao {

    public MstcustomerDaoHibernate() {
        super(Mstcustomer.class);
    }

	
	@Override
	public List<String> getCustomerCode() {
		return getSession().createQuery("select c.custCode from Mstcustomer c order by c.custCode asc").list();
	}
	
	public List<Mstcustomer> getCustomerCodeq(String query){
		
		String url = "  from Mstcustomer c ";
		if(!query.equals("NOT")){
			String url2 ="  "
				+ " c.custCode like '%"+query+ "%' or "
				+ " c.boiRegno like '%"+query+ "%' or "
				+ " c.buyerEmail like '%"+query+ "%' or "
				+ " c.crTerm like '%"+query+ "%' or "
				+ " c.custAddress like '%"+query+ "%' or "
				+ " c.contactName like '%"+query+ "%' or "
				+ " c.buyerEmail like '%"+query+ "%' ";
			url = url+" where  "+url2;
		}
		url=url+"order by c.custCode asc";
		log.debug(url);
		try{
			List<Mstcustomer> strings=getSession().createQuery(url).list();
		 return strings;
		}catch (Exception e) {
			log.debug(e);
			return new ArrayList <Mstcustomer>();
		}
	}
}
