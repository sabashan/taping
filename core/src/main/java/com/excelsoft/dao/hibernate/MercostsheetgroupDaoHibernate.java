package com.excelsoft.dao.hibernate;

import java.util.Iterator;
import java.util.List;

import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.MercostsheetgroupId;
import com.excelsoft.model.Mercostsheetgroupdemmap;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.model.MercostsheethdrId;
import com.excelsoft.service.impl.MercostsheethdrManagerImpl;
import com.excelsoft.util.ConvertUtil;
import com.excelsoft.dao.MercostsheetgroupDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mercostsheetgroupDao")
public class MercostsheetgroupDaoHibernate extends GenericDaoHibernate<Mercostsheetgroup, MercostsheetgroupId> implements MercostsheetgroupDao {

    public MercostsheetgroupDaoHibernate() {
        super(Mercostsheetgroup.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetgroup> getAll(String costSheetNo, String versionNo,
			String costSheetType) {

		return getSession().createQuery("from Mercostsheetgroup g where g.id.costSheetNo=:costSheetNo"
				+ " and g.id.versionNo=:versionNo and g.id.costSheetType=:costSheetType "
				+ "Order By g.id.costSheetType")
				.setParameter("costSheetNo", costSheetNo)
				.setParameter("versionNo", ConvertUtil.getDecimal(versionNo))
				.setParameter("costSheetType", costSheetType).list();
	}

	@Override
	public Mercostsheetgroup get(String costSheetNo, String versionNo,
			String costSheetType,String groupName) {

		return (Mercostsheetgroup) getSession().createQuery("from Mercostsheetgroup g where g.id.costSheetNo=:costSheetNo"
				+ " and g.id.versionNo=:versionNo and g.id.costSheetType=:costSheetType and g.groupName=:groupName")
				.setParameter("costSheetNo", costSheetNo)
				.setParameter("versionNo", ConvertUtil.getDecimal(versionNo))
				.setParameter("costSheetType", costSheetType)
				.setParameter("groupName", groupName).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetgroup> getAll(Mercostsheethdr mercostsheethdr) {
		return getSession().createQuery("from Mercostsheetgroup g where g.mercostsheethdr=:mercostsheethdr"
				+ "Order By g.id.costSheetType")
				.setParameter("mercostsheethdr", mercostsheethdr).list();
	}
	
	@Override
	public Mercostsheetgroup get(String groupName){
		return (Mercostsheetgroup) getSession().createQuery("from Mercostsheetgroup g where g.groupName=:groupName"
				+ "")
				.setParameter("groupName", groupName).uniqueResult();
	}

}
