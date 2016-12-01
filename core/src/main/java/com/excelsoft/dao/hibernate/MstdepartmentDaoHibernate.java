package com.excelsoft.dao.hibernate;

import com.excelsoft.model.Mstdepartment;
import com.excelsoft.dao.MstdepartmentDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("mstdepartmentDao")
public class MstdepartmentDaoHibernate extends GenericDaoHibernate<Mstdepartment, String> implements MstdepartmentDao {

    public MstdepartmentDaoHibernate() {
        super(Mstdepartment.class);
    }
}
