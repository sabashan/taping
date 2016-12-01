package com.excelsoft.dao.hibernate;

import com.excelsoft.model.Merordersheetgroup;
import com.excelsoft.model.MerordersheetgroupId;
import com.excelsoft.dao.MerordersheetgroupDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("merordersheetgroupDao")
public class MerordersheetgroupDaoHibernate extends GenericDaoHibernate<Merordersheetgroup, MerordersheetgroupId> implements MerordersheetgroupDao {

    public MerordersheetgroupDaoHibernate() {
        super(Merordersheetgroup.class);
    }
}
