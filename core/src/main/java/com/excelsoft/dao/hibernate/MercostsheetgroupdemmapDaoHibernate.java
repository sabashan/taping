package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mercostsheetgroupdemmap;
import com.excelsoft.model.MercostsheetgroupdemmapId;
import com.excelsoft.model.Mercostsheetgroupsetting;
import com.excelsoft.model.Mercostsheethdr;
import com.excelsoft.dao.MercostsheetgroupdemmapDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mercostsheetgroupdemmapDao")
public class MercostsheetgroupdemmapDaoHibernate extends GenericDaoHibernate<Mercostsheetgroupdemmap, MercostsheetgroupdemmapId> implements MercostsheetgroupdemmapDao {

    public MercostsheetgroupdemmapDaoHibernate() {
        super(Mercostsheetgroupdemmap.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetgroupdemmap> getAll(Mercostsheetgroupsetting mercostsheetgroupsetting) {
		// TODO Auto-generated method stub
		return getSession().createQuery("FROM Mercostsheetgroupdemmap s INNER JOIN fetch s.mercostsheetgroupsetting g WHERE "
				+ "s.mercostsheetgroupsetting=:mercostsheetgroupsetting AND s.id.groupSettingId=:groupSettingId AND "
				+ "s.id.groupId=:groupId AND s.id.costSheetNo=:costSheetNo AND s.id.versionNo=:versionNo AND s.id.costSheetType=:costSheetType")
				.setParameter("mercostsheetgroupsetting", mercostsheetgroupsetting)
				.setParameter("groupSettingId", mercostsheetgroupsetting.getId().getGroupSettingId())
				.setParameter("groupId", mercostsheetgroupsetting.getId().getGroupId())
				.setParameter("costSheetNo", mercostsheetgroupsetting.getId().getCostSheetNo())
				.setParameter("versionNo", mercostsheetgroupsetting.getId().getVersionNo())
				.setParameter("costSheetType", mercostsheetgroupsetting.getId().getCostSheetType())
				.list();
	}
}

/* */