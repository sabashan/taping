package com.excelsoft.dao.hibernate;

import com.excelsoft.model.Merordersheetgroupsetting;
import com.excelsoft.model.MerordersheetgroupsettingId;
import com.excelsoft.dao.MerordersheetgroupsettingDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("merordersheetgroupsettingDao")
public class MerordersheetgroupsettingDaoHibernate extends GenericDaoHibernate<Merordersheetgroupsetting, MerordersheetgroupsettingId> implements MerordersheetgroupsettingDao {

    public MerordersheetgroupsettingDaoHibernate() {
        super(Merordersheetgroupsetting.class);
    }
}
