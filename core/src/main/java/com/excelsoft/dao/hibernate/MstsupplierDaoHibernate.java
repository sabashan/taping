package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mstsupplier;
import com.excelsoft.model.MstsupplierId;
import com.excelsoft.dao.MstsupplierDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mstsupplierDao")
@SuppressWarnings("unchecked")
public class MstsupplierDaoHibernate extends GenericDaoHibernate<Mstsupplier, MstsupplierId> implements MstsupplierDao {

    public MstsupplierDaoHibernate() {
        super(Mstsupplier.class);
    }

	
	@Override
	public List<String> getAllid(String location) {
		return getSession().createQuery("select s.id.suppCode from Mstsupplier s").list();
	}


	@Override
	public List<Mstsupplier> getAll(String location) {
		return getSession().createQuery("from Mstsupplier s where s.id.compCode=:compCode")
				.setParameter("compCode", location).list();
	}


	@Override
	public List<Mstsupplier> getAllq(String location, String q) {
		return getSession().createQuery("from Mstsupplier s where s.id.compCode=:compCode and "+likeq())
		.setParameter("compCode", location)
		.setParameter("filed", "%"+q+"%").list();
	}
	
	private String likeq(){
		String div="( s.id.compCode like :filed or "
		+	"s.id.suppCode like :filed or "
		+	"s.suppName like :filed or "
		+	"s.suppAddress like :filed or "
		+	"s.telNo like :filed or "
		+	"s.faxNo like :filed or "
		+	"s.tlxNo like :filed or "
		+	"s.emailAddr like :filed or "
		+	"s.contactName like :filed or "
		+	"s.purchGlCode like :filed or "
		+	"s.glCtrlAcc like :filed or "
		+	"s.crTerm like :filed or "
		+	"s.recType like :filed or "
		+	"s.supType like :filed or "
		+	"s.suppGstNumber like :filed or "
		+	"s.bankName like :filed )";
		return div;
	}
}
