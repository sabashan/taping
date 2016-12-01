package com.excelsoft.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.excelsoft.dao.MercostsheetgroupcolorDao;
import com.excelsoft.model.Mercostsheetgroupcolor;
import com.excelsoft.model.MercostsheetgroupcolorId;
import com.excelsoft.model.Mercostsheetgroupsetting;

@Repository("mercostsheetgroupcolorDao")
public class MercostsheetgroupcolorDaoHibernate extends GenericDaoHibernate<Mercostsheetgroupcolor, MercostsheetgroupcolorId> implements MercostsheetgroupcolorDao {

    public MercostsheetgroupcolorDaoHibernate() {
        super(Mercostsheetgroupcolor.class);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Mercostsheetgroupcolor> getAll(Mercostsheetgroupsetting mercostsheetgroupsetting) {
		// TODO Auto-generated method stub
		log.debug(mercostsheetgroupsetting.toString());
		return getSession().createQuery("FROM Mercostsheetgroupcolor s INNER JOIN fetch s.mercostsheetgroupsetting g  WHERE "
				+ "s.mercostsheetgroupsetting=:mercostsheetgroupsetting AND s.id.groupSettingId=:groupSettingId AND "
				+ " s.id.groupId=:groupId AND s.id.costSheetNo=:costSheetNo AND s.id.versionNo=:versionNo AND s.id.costSheetType=:costSheetType ")
				.setParameter("mercostsheetgroupsetting", mercostsheetgroupsetting)
				.setParameter("groupSettingId", mercostsheetgroupsetting.getId().getGroupSettingId())
				.setParameter("groupId", mercostsheetgroupsetting.getId().getGroupId())
				.setParameter("costSheetNo", mercostsheetgroupsetting.getId().getCostSheetNo())
				.setParameter("versionNo", mercostsheetgroupsetting.getId().getVersionNo())
				.setParameter("costSheetType", mercostsheetgroupsetting.getId().getCostSheetType()).list();
	}
}
