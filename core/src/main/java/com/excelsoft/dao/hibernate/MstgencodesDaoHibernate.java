package com.excelsoft.dao.hibernate;


import java.util.List;

import com.excelsoft.model.Mstgencodes;
import com.excelsoft.model.MstgencodesId;
import com.excelsoft.dao.MstgencodesDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mstgencodesDao")
@SuppressWarnings("unchecked")
public class MstgencodesDaoHibernate extends GenericDaoHibernate<Mstgencodes, MstgencodesId> implements MstgencodesDao {

    public MstgencodesDaoHibernate() {
        super(Mstgencodes.class);
    }

	
	@Override
	public List<Mstgencodes> findByType(String type) {
		return  getSession().createQuery("from Mstgencodes g Where g.id.type=:type").setParameter("type", type).list();
	}

	@Override
	public List<Mstgencodes> findBycode(String code) {
		return  getSession().createQuery("from Mstgencodes g Where g.id.code=:code").setParameter("code", code).list();
	}


	@Override
	public List<Mstgencodes> type_idlike(String type, String code) {
		/**
		 * private String desc;
    private int uomDenom;
    private String locationCode;
    private String createdBy;
    private Date createdOn;
    private String createdAt;
    private String modifiedBy;
    private Date modifiedOn;
    private String modifiedAt;
    private String edit;
    private String remoteLocation;
    private Character gspApprovedCountry;
		 */
		code="%"+code+"%";
		return  getSession().createQuery("from Mstgencodes g Where g.id.type=:type and ( g.desc like :code or g.id.code like :code or g.uomDenom like :code )")
				.setParameter("code", code)
				.setParameter("type", type).list();
	}


	@Override
	public List<String> getcode(String type) {
		return  getSession().createQuery("select g.id.code from Mstgencodes g Where g.id.type=:type").setParameter("type", type).list();
	}
}
