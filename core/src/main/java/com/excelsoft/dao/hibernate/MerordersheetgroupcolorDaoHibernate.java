package com.excelsoft.dao.hibernate;

import com.excelsoft.model.Merordersheetgroupcolor;
import com.excelsoft.model.MerordersheetgroupcolorId;
import com.excelsoft.dao.MerordersheetgroupcolorDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("merordersheetgroupcolorDao")
public class MerordersheetgroupcolorDaoHibernate extends GenericDaoHibernate<Merordersheetgroupcolor, MerordersheetgroupcolorId> implements MerordersheetgroupcolorDao {

    public MerordersheetgroupcolorDaoHibernate() {
        super(Merordersheetgroupcolor.class);
    }
}
