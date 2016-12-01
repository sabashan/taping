package com.excelsoft.dao.hibernate;

import java.math.BigDecimal;
import java.util.List;

import com.excelsoft.model.Mercostsheetgroup;
import com.excelsoft.model.Mercostsheetgroupsetting;
import com.excelsoft.model.MercostsheetgroupsettingId;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.dao.MercostsheetgroupsettingDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mercostsheetgroupsettingDao")
public class MercostsheetgroupsettingDaoHibernate extends GenericDaoHibernate<Mercostsheetgroupsetting, MercostsheetgroupsettingId> implements MercostsheetgroupsettingDao {

    public MercostsheetgroupsettingDaoHibernate() {
        super(Mercostsheetgroupsetting.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetgroupsetting> getAll(
			Mercostsheetgroup mercostsheetgroup) {
		return getSession().createQuery("FROM Mercostsheetgroupsetting s INNER JOIN fetch  s.mercostsheetgroup g  WHERE "
				+ "s.mercostsheetgroup=:mercostsheetgroup AND s.id.groupId=:groupId AND s.id.costSheetNo=:costSheetNo AND s.id.versionNo=:versionNo AND s.id.costSheetType=:costSheetType ")
				.setParameter("mercostsheetgroup", mercostsheetgroup)
				.setParameter("groupId", mercostsheetgroup.getId().getGroupId())
				.setParameter("costSheetNo", mercostsheetgroup.getId().getCostSheetNo())
				.setParameter("versionNo", mercostsheetgroup.getId().getVersionNo())
				.setParameter("costSheetType", mercostsheetgroup.getId().getCostSheetType()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetgroupsetting> getAll(Mercostsheethdr mercostsheethdr) {
		return getSession().createQuery("from Mercostsheetgroupsetting gm "
				+ "where gm.id.costSheetNo=:costSheetNo and "
				+ "gm.id.versionNo=:versionNo and "
				+ "gm.id.costSheetType=:costSheetType ")
				.setParameter("costSheetNo", mercostsheethdr.getId().getCostSheetNo())
				.setParameter("versionNo", mercostsheethdr.getId().getVersionNo())
				.setParameter("costSheetType", mercostsheethdr.getId().getCostSheetType()).list();
	}
}
