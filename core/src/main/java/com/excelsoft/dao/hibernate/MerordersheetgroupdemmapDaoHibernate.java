package com.excelsoft.dao.hibernate;

import com.excelsoft.model.Merordersheetgroupdemmap;
import com.excelsoft.model.MerordersheetgroupdemmapId;
import com.excelsoft.dao.MerordersheetgroupdemmapDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("merordersheetgroupdemmapDao")
public class MerordersheetgroupdemmapDaoHibernate extends GenericDaoHibernate<Merordersheetgroupdemmap, MerordersheetgroupdemmapId> implements MerordersheetgroupdemmapDao {

    public MerordersheetgroupdemmapDaoHibernate() {
        super(Merordersheetgroupdemmap.class);
    }
}
