package com.excelsoft.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import com.excelsoft.model.Mststylerouteoperation;
import com.excelsoft.model.Mststylerouteoperationdemmap;
import com.excelsoft.model.MststylerouteoperationdemmapId;
import com.excelsoft.dao.MststylerouteoperationdemmapDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mststylerouteoperationdemmapDao")
public class MststylerouteoperationdemmapDaoHibernate
		extends
		GenericDaoHibernate<Mststylerouteoperationdemmap, MststylerouteoperationdemmapId>
		implements MststylerouteoperationdemmapDao {

	public MststylerouteoperationdemmapDaoHibernate() {
		super(Mststylerouteoperationdemmap.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mststylerouteoperationdemmap> getAllOpDemMaps(
			Mststylerouteoperation mststyleoperation) {
		// TODO Auto-generated method stub
		List<Mststylerouteoperationdemmap> mststylerouteopdemmaps = new ArrayList<Mststylerouteoperationdemmap>();
		try {
			// mststylerouteopdemmaps =
			// getSession().get(Mststyleoperation.class, mststyleoperation).l;
			mststylerouteopdemmaps = getSession()
					.createQuery(
							"FROM Mststylerouteoperationdemmap m"
							+ " WHERE m.id.opeartionNo=:opeartionNo AND m.id.styleRouteId=:styleRouteId")
						.setParameter("opeartionNo",mststyleoperation.getId().getOpeartionNo())
						.setParameter("styleRouteId", mststyleoperation.getId().getStyleRouteId()).list();
			log.debug(mststylerouteopdemmaps.toString());
					/*
					 * .setParameter("compCode",
					 * mststyleoperation.getId().getCompCode())
					 * .setParameter("componentId",
					 * mststyleoperation.getId().getComponentId())
					 * .setParameter("custCode",
					 * mststyleoperation.getId().getCustCode())
					 * .setParameter("depCode",
					 * mststyleoperation.getId().getDepCode())
					 * .setParameter("locationCode",
					 * mststyleoperation.getId().getLocationCode())
					 * .setParameter("opeartionNo",
					 * Long.valueOf(mststyleoperation.getId().getOpeartionNo()))
					 * .setParameter("styleId",
					 * mststyleoperation.getId().getstyleId())
					 */
					
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
		return mststylerouteopdemmaps;
	}

}
