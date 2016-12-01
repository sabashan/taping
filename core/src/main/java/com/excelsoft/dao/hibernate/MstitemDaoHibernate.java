package com.excelsoft.dao.hibernate;

import java.util.List;

import com.excelsoft.model.Mstitem;
import com.excelsoft.model.MstitemId;
import com.excelsoft.dao.MstitemDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("mstitemDao")
@SuppressWarnings("unchecked")
public class MstitemDaoHibernate extends GenericDaoHibernate<Mstitem, MstitemId> implements MstitemDao {

    public MstitemDaoHibernate() {
        super(Mstitem.class);
    }

	
	@Override
	public List<String> getAllid(String ItemType) {
		return getSession().createQuery("SELECT DISTINCT  i.id.itemCode FROM Mstitem i WHERE i.id.itemType=:itemType")
				.setParameter("itemType", ItemType).list();
	}


	@Override
	public List<Mstitem> getAll(String ItemType) {
		return getSession().createQuery(" FROM Mstitem i WHERE i.id.itemType=:itemType")
				.setParameter("itemType", ItemType).list();
	}


	@Override
	public List<Mstitem> getAll(String ItemType, String q) {
		return getSession().createQuery(" FROM Mstitem i WHERE i.id.itemType=:itemType and "+gettLike())
				.setParameter("itemType", ItemType)
				.setParameter("filed", "%"+q+"%")
				.list();
	}
	
	private String gettLike(){
		String likeq="";
		likeq="( i.id.itemCode like :filed or "
			+"i.id.itemType like :filed or "
			+"i.itemDesc like :filed or "
			+"i.uom like :filed or "
			+"i.designNo like :filed or "
			+"i.userId like :filed or "
			+"i.itemGroup like :filed or "
			+"i.type1Code like :filed or "
			+"i.type2Code like :filed or "
			+"i.type3Code like :filed or "
			+"i.type4Code like :filed or "
			+"i.type5Code like :filed or "
			+"i.type6Code like :filed or "
			+"i.glCodePurch like :filed or "
			+"i.glCodeSales like :filed or "
			+"i.glCodeStock like :filed or "
			+"i.buyerCode like :filed or "
			+"i.styleId like :filed or "
			+"i.createdBy like :filed or "
			+"i.createdAt like :filed or "
			+"i.modifiedBy like :filed or "
			+"i.modifiedAt like :filed or "
			+"i.curCode like :filed ) ";
		return likeq;
	}
}
