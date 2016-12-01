package com.excelsoft.dao.hibernate;

import org.springframework.stereotype.Repository;
import com.excelsoft.dao.MerordersheetdeliveryDao;
import com.excelsoft.model.Merordersheetdelivery;
import com.excelsoft.model.MerordersheetdeliveryId;

@Repository("merordersheetdeliveryDao")
public class MerordersheetdeliveryDaoHibernate extends GenericDaoHibernate<Merordersheetdelivery, MerordersheetdeliveryId> implements MerordersheetdeliveryDao {

    public MerordersheetdeliveryDaoHibernate() {
        super(Merordersheetdelivery.class);
    }
}
