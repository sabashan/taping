package com.excelsoft.dao.hibernate;

import com.excelsoft.model.Merordersheetdem;
import com.excelsoft.model.MerordersheetdemId;
import com.excelsoft.dao.MerordersheetdemDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("merordersheetdemDao")
public class MerordersheetdemDaoHibernate extends GenericDaoHibernate<Merordersheetdem, MerordersheetdemId> implements MerordersheetdemDao {

    public MerordersheetdemDaoHibernate() {
        super(Merordersheetdem.class);
    }
}
