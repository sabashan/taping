package com.excelsoft.dao.hibernate;

import com.excelsoft.model.Mstparameter;
import com.excelsoft.dao.MstparameterDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("mstparameterDao")
public class MstparameterDaoHibernate extends GenericDaoHibernate<Mstparameter, String> implements MstparameterDao {

    public MstparameterDaoHibernate() {
        super(Mstparameter.class);
    }
}
