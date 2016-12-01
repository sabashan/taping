package com.excelsoft.dao.hibernate;

import com.excelsoft.dao.UserDao;
import com.excelsoft.model.Mstuser;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.SessionFactoryUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * This class interacts with Hibernate session to save/delete and
 * retrieve Mstuser objects.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *   Modified by <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 *   Extended to implement Acegi UserDetailsService interface by David Carter david@carter.net
 *   Modified by <a href="mailto:bwnoll@gmail.com">Bryan Noll</a> to work with
 *   the new BaseDaoHibernate implementation that uses generics.
 *   Modified by jgarcia (updated to hibernate 4)
*/
@SuppressWarnings("unused")
@Repository("userDao")
public class UserDaoHibernate extends GenericDaoHibernate<Mstuser, String> implements UserDao, UserDetailsService {

    /**
     * Constructor that sets the entity to Mstuser.class.
     */
    public UserDaoHibernate() {
        super(Mstuser.class);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Mstuser> getUsers() {
        Query qry = getSession().createQuery("from Mstuser u order by upper(u.user_id)");
        return qry.list();
    }

    /**
     * {@inheritDoc}
     */
    public Mstuser saveUser(Mstuser user) {
        if (log.isDebugEnabled()) {
            log.debug("user's id: " + user.getUserId());
        }
        getSession().saveOrUpdate(user);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return user;
    }

    /**
     * Overridden simply to call the saveUser method. This is happening
     * because saveUser flushes the session and saveObject of BaseDaoHibernate
     * does not.
     *
     * @param user the user to save
     * @return the modified user (with a primary key set if they're new)
     */
    @Override
    public Mstuser save(Mstuser user) {
        return this.saveUser(user);
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

}
