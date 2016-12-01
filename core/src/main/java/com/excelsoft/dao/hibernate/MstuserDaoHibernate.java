package com.excelsoft.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Table;

import com.excelsoft.model.Mstuser;
import com.excelsoft.dao.MstuserDao;
import com.excelsoft.dao.hibernate.GenericDaoHibernate;

import org.hibernate.criterion.Restrictions;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository("mstuserDao")
@SuppressWarnings("unchecked")
public class MstuserDaoHibernate extends GenericDaoHibernate<Mstuser, String> implements MstuserDao {

    public MstuserDaoHibernate() {
        super(Mstuser.class);
    }
    
    /**
     * {@inheritDoc}
    */
    @SuppressWarnings("rawtypes")
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List users = getSession().createCriteria(Mstuser.class).add(Restrictions.eq("userId", username)).list();
        if (users == null || users.isEmpty()) {
            throw new UsernameNotFoundException("user '" + username + "' not found...");
        } else {
            return (UserDetails) users.get(0);
        }
    }

    /**
     * {@inheritDoc}
    */
    public String getUserPassword(String userId) {
        JdbcTemplate jdbcTemplate =
                new JdbcTemplate(SessionFactoryUtils.getDataSource(getSessionFactory()));
        Table table = AnnotationUtils.findAnnotation(Mstuser.class, Table.class);
        return jdbcTemplate.queryForObject(
                "select user_pw from " + table.name() + " where user_id=?", String.class, userId);
    }

	
	@Override
	public List<String> getAlluserId() {
		return getSession().createQuery("select u.userId from Mstuser u order by u.userId  asc").list();
	}

	@Override
	public List<Mstuser> getAllByq(String query) {
		
		String url="from Mstuser u";
		if(!query.equals("NOT")){
			String url2 ="  "
				+ " u.userId like '%"+query+ "%' or "
				+ " u.EMailAddress like '%"+query+ "%' or "
				+ " u.userGroup like '%"+query+ "%' or "
				+ " u.userName like '%"+query+ "%' or "
				+ " u.userSignature like '%"+query+ "%' or "
				+ " u.userType like '%"+query+ "%' ";
		
			url = url+" where  "+url2;
		}
		url=url+" order by u.userId asc";
		log.debug(url);
		try{
			List<Mstuser> strings=getSession().createQuery(url).list();
		 return strings;
		}catch (Exception e) {
			log.debug(e);
			return new ArrayList <Mstuser>();
		}
	}
}
