package com.excelsoft.dao.hibernate;

import com.excelsoft.model.Mstpicture;
import com.excelsoft.dao.MstpictureDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;
import org.springframework.stereotype.Repository;

@Repository("mstpictureDao")
public class MstpictureDaoHibernate extends GenericDaoHibernate<Mstpicture, String> implements MstpictureDao {

    public MstpictureDaoHibernate() {
        super(Mstpicture.class);
    }
}
