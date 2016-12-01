package com.excelsoft.dao.hibernate;

import com.excelsoft.model.Mercostsheetunapprovedloged;
import com.excelsoft.model.MercostsheetunapprovedlogedId;
import com.excelsoft.dao.MercostsheetunapprovedlogedDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mercostsheetunapprovedlogedDao")
public class MercostsheetunapprovedlogedDaoHibernate extends GenericDaoHibernate<Mercostsheetunapprovedloged, MercostsheetunapprovedlogedId> implements MercostsheetunapprovedlogedDao {

    public MercostsheetunapprovedlogedDaoHibernate() {
        super(Mercostsheetunapprovedloged.class);
    }
}
