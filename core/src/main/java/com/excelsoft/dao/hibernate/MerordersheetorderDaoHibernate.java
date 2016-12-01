package com.excelsoft.dao.hibernate;

import com.excelsoft.model.Merordersheetorder;
import com.excelsoft.model.MerordersheetorderId;
import com.excelsoft.dao.MerordersheetorderDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("merordersheetorderDao")
public class MerordersheetorderDaoHibernate extends GenericDaoHibernate<Merordersheetorder, MerordersheetorderId> implements MerordersheetorderDao {

    public MerordersheetorderDaoHibernate() {
        super(Merordersheetorder.class);
    }
}
