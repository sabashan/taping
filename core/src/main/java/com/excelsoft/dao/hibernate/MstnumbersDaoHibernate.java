package com.excelsoft.dao.hibernate;

import com.excelsoft.model.Mstnumbers;
import com.excelsoft.model.MstnumbersId;
import com.excelsoft.dao.MstnumbersDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("mstnumbersDao")
public class MstnumbersDaoHibernate extends GenericDaoHibernate<Mstnumbers, MstnumbersId> implements MstnumbersDao {

    public MstnumbersDaoHibernate() {
        super(Mstnumbers.class);
    }

	@Override
	public String getNextRoute() {
		//MSR - Merchandising Style Route; Rout - Route
		String styleRouteId = "1";
		log.debug("******" +styleRouteId);
		try {
			Mstnumbers mstnumbers = new Mstnumbers();
			mstnumbers = (Mstnumbers) getSession()
					.createQuery("FROM Mstnumbers r WHERE  r.id.compCode=:compCode "
							+ "AND r.id.programId=:programId AND r.id.trnType=:trnType ")
					.setParameter("compCode", "MSR")
					.setParameter("programId", (short)4002)
					.setParameter("trnType", "Rout").iterate().next();
			log.debug(mstnumbers.toString());
			styleRouteId = String.valueOf(mstnumbers.getTrnNo());
			log.debug("******" +styleRouteId);
		} catch (Exception e) {
			log.debug(e);
		}
		return styleRouteId;
	}

	@Override
	public String setNextRoute() {
		String styleRouteId = "1";
		try {
			//MSR - Merchandising Style Route; Rout - Route
			Mstnumbers mstnumbers = (Mstnumbers) getSession()
					.createQuery("FROM Mstnumbers r WHERE  r.id.compCode=:compCode "
							+ "AND r.id.programId=:programId AND r.id.trnType=:trnType ")
			.setParameter("compCode", "MSR")
			.setParameter("programId", (short)4002)
			.setParameter("trnType", "Rout").iterate().next();
			
			mstnumbers.setTrnNo(mstnumbers.getTrnNo() + 1 );
			styleRouteId = String.valueOf(mstnumbers.getTrnNo());
			getSession().saveOrUpdate(mstnumbers);
			new MstnumbersDaoHibernate().save(mstnumbers);
		} catch (Exception e) {
			log.debug(e);
		}
		return styleRouteId;
	}
	
	@Override
	public Integer getnexttrnNo(String compCode,short programId,String trnType ){
		
		Integer trnNo=1;
		Session session= getSession();
		//Transaction transaction=session.getTransaction();
		try{
		
		//transaction.begin();
		
		trnNo= (int) session
					.createQuery("SELECT n.trnNo FROM Mstnumbers n WHERE n.id.programId =:programId and n.id.trnType =:trnType and id.compCode =:compCode").
					setParameter("compCode", compCode).
					setParameter("trnType", trnType).
					setParameter("programId", programId).
					uniqueResult();
		MstnumbersId id=new MstnumbersId(compCode, programId, trnType);
		Mstnumbers mstnumbers=new Mstnumbers(id);
		mstnumbers.setTrnNo(trnNo+1);
		mstnumbers.setGenerateNos('y');
		session.update(mstnumbers);
		
		//transaction.commit();
		}
		catch(Exception e){
			//transaction.rollback();
			log.debug(e.getMessage());
			MstnumbersId id=new MstnumbersId(compCode, programId, trnType);
			Mstnumbers mstnumbers=new Mstnumbers(id);
			mstnumbers.setTrnNo(1);
			mstnumbers.setGenerateNos('y');
			session.save(mstnumbers);
		}

		log.debug(trnNo);
		return trnNo;
	}

	@Override
	public String getNextWIPId() {
		// TODO Auto-generated method stub
		String WipPointId = "1";
		try {
			Mstnumbers mstnumbers = new Mstnumbers();
			mstnumbers = (Mstnumbers) getSession()
					.createQuery("FROM Mstnumbers r WHERE  r.id.compCode=:compCode "
							+ "AND r.id.programId=:programId AND r.id.trnType=:trnType ")
					.setParameter("compCode", "MSR")
					.setParameter("programId", (short)4001)
					.setParameter("trnType", "WIP").iterate().next();
			log.debug(mstnumbers.toString());
			WipPointId = String.valueOf(mstnumbers.getTrnNo());
			log.debug("******" +WipPointId);
		} catch (Exception e) {
			log.debug(e);
		}
		return WipPointId;
	}

	@Override
	public String setNextWIPId() {
		// TODO Auto-generated method stub
		String WipPointId = "1";
		try {
			//MSR - Merchandising Style Route; Rout - Route
			Mstnumbers mstnumbers = (Mstnumbers) getSession()
					.createQuery("FROM Mstnumbers r WHERE  r.id.compCode=:compCode "
							+ "AND r.id.programId=:programId AND r.id.trnType=:trnType ")
			.setParameter("compCode", "MSR")
			.setParameter("programId", (short)4001)
			.setParameter("trnType", "WIP").iterate().next();
			
			mstnumbers.setTrnNo(mstnumbers.getTrnNo() + 1 );
			WipPointId = String.valueOf(mstnumbers.getTrnNo());
			getSession().saveOrUpdate(mstnumbers);
			new MstnumbersDaoHibernate().save(mstnumbers);
		} catch (Exception e) {
			log.debug(e);
		}
		return WipPointId;
	}  

}
