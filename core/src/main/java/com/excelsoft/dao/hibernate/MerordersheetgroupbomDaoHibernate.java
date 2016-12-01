package com.excelsoft.dao.hibernate;

import com.excelsoft.model.Merordersheetgroupbom;
import com.excelsoft.model.MerordersheetgroupbomId;
import com.excelsoft.dao.MerordersheetgroupbomDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("merordersheetgroupbomDao")
public class MerordersheetgroupbomDaoHibernate extends GenericDaoHibernate<Merordersheetgroupbom, MerordersheetgroupbomId> implements MerordersheetgroupbomDao {

    public MerordersheetgroupbomDaoHibernate() {
        super(Merordersheetgroupbom.class);
    }
}
