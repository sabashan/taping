package com.excelsoft.dao.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.excelsoft.dao.GenericDao;
import com.excelsoft.dao.SearchException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.orm.ObjectRetrievalFailureException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.util.Version;
import org.hibernate.HibernateException;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;

/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * <p/>
 * <p>To register this class in your Spring context file, use the following XML.
 * <pre>
 *      &lt;bean id="fooDao" class="com.excelsoft.dao.hibernate.GenericDaoHibernate"&gt;
 *          &lt;constructor-arg value="com.excelsoft.model.Foo"/&gt;
 *      &lt;/bean&gt;
 * </pre>
 *
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 *      Updated by jgarcia: update hibernate3 to hibernate4
 * @author jgarcia (update: added full text search + reindexing)
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 */
@SuppressWarnings({ "unchecked" })
public class GenericDaoHibernate<T, PK extends Serializable> implements GenericDao<T, PK> {
    /**
     * Log variable for all child classes. Uses LogFactory.getLog(getClass()) from Commons Logging
     */
    protected final Log log = LogFactory.getLog(getClass());
    
    private Class<T> persistentClass;
    @Resource
    private SessionFactory sessionFactory;
    private Analyzer defaultAnalyzer;

    /**
     * Constructor that takes in a class to see which type of entity to persist.
     * Use this constructor when subclassing.
     *
     * @param persistentClass the class type you'd like to persist
     */
    public GenericDaoHibernate(final Class<T> persistentClass) {
        this.persistentClass = persistentClass;
        defaultAnalyzer = new StandardAnalyzer(Version.LUCENE_35);
    }

    /**
     * Constructor that takes in a class and sessionFactory for easy creation of DAO.
     *
     * @param persistentClass the class type you'd like to persist
     * @param sessionFactory  the pre-configured Hibernate SessionFactory
     */
    public GenericDaoHibernate(final Class<T> persistentClass, SessionFactory sessionFactory) {
        this.persistentClass = persistentClass;
        this.sessionFactory = sessionFactory;
        defaultAnalyzer = new StandardAnalyzer(Version.LUCENE_35);
    }

    public SessionFactory getSessionFactory() {
        return this.sessionFactory;
    }

    public Session getSession() throws HibernateException {
        Session sess = getSessionFactory().getCurrentSession();
        if (sess == null) {
            sess = getSessionFactory().openSession();
        }
        return sess;
    }

    @Autowired
    @Required
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * {@inheritDoc}
     */
    public List<T> getAll() {
        Session sess = getSession();
        return sess.createCriteria(persistentClass).list();
    }

    /**
     * {@inheritDoc}
     */
    public List<T> getAllDistinct() {
        Collection<T> result = new LinkedHashSet<T>(getAll());
        return new ArrayList<T>(result);
    }

    /**
     * {@inheritDoc}
     */
	public List<T> search(String searchTerm) throws SearchException {
        Session sess = getSession();
        FullTextSession txtSession = Search.getFullTextSession(sess);

        org.apache.lucene.search.Query qry;
        try {
            qry = HibernateSearchTools.generateQuery(searchTerm, this.persistentClass, sess, defaultAnalyzer);
            log.debug(qry);
            log.debug("**************************************************");
        } catch (ParseException ex) {
            throw new SearchException(ex);
        }
        org.hibernate.search.FullTextQuery hibQuery = txtSession.createFullTextQuery(qry,
                this.persistentClass);
        log.debug(hibQuery);
        return hibQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    public T get(PK id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);

        if (entity == null) {
            log.warn("Uh oh, '" + this.persistentClass + "' object with id '" + id + "' not found...");
            throw new ObjectRetrievalFailureException(this.persistentClass, id);
        }

        return entity;
    }

    /**
     * {@inheritDoc}
     */
    public boolean exists(PK id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);
        return entity != null;
    }

    /**
     * {@inheritDoc}
     */
    public T save(T object) {
        Session sess = getSession();
        return (T) sess.merge(object);
    }

    /**
     * {@inheritDoc}
     */
    public void remove(T object) {
        Session sess = getSession();
        sess.delete(object);
    }

    /**
     * {@inheritDoc}
     */
	public void remove(PK id) {
        Session sess = getSession();
        IdentifierLoadAccess byId = sess.byId(persistentClass);
        T entity = (T) byId.load(id);
        sess.delete(entity);
    }

    /**
     * {@inheritDoc}
     */
    public List<T> findByNamedQuery(String queryName, Map<String, Object> queryParams) {
        Session sess = getSession();
        Query namedQuery = sess.getNamedQuery(queryName);

        for (String s : queryParams.keySet()) {
            namedQuery.setParameter(s, queryParams.get(s));
        }

        return namedQuery.list();
    }

    /**
     * {@inheritDoc}
     */
    public void reindex() {
        HibernateSearchTools.reindex(persistentClass, getSessionFactory().getCurrentSession());
    }


    /**
     * {@inheritDoc}
     */
    public void reindexAll(boolean async) {
        HibernateSearchTools.reindexAll(async, getSessionFactory().getCurrentSession());
    }

	@Override
	/**
	 * @author Raminda
	 * @pram String serchable string
	 * @return object list
	 */
	public List<T> getFildsearch(String q) {
		q="%"+q+"%";
		ClassMetadata classMetadata = sessionFactory.getClassMetadata(persistentClass);
		
		String[] propertyNames = classMetadata.getPropertyNames();
		String query="from "+persistentClass.getSimpleName() +" s where ";
		String filed ="  like :filed  ";
		for(int i=0;i<propertyNames.length;i++){
			query+=" s."+propertyNames[i]+" "+filed;
			if(i<propertyNames.length-1){
				query+=" or ";
			}
		}	
		log.debug(query);
		return getSession()
		 .createQuery(query)
		 .setParameter("filed", q).list();
	}
	@Override
	public List<T> getallsearch(String q,String [] ids) {
		q="%"+q+"%";
		ClassMetadata classMetadata = sessionFactory.getClassMetadata(persistentClass);
		
		String[] propertyNames = classMetadata.getPropertyNames();
		String query="from "+persistentClass.getSimpleName() +" s where ";
		String filed =" like :filed ";
		for(int i=0;i<propertyNames.length;i++){
			query+=" s."+propertyNames[i]+filed;
			if(i<propertyNames.length-1){
				query+=" or ";
			}
		}	
		for(int i=0;i<ids.length;i++){
			query+=" or s.id."+ids[i]+filed;	
		}
		log.debug(query);
		List<T> obj =getSession()
				 .createQuery(query)
				 .setParameter("filed", q).list();
		
		return obj;
	}
	@Override
	public List<T> getColomnsearch(String q,String colomn) {

		q="%"+q+"%";
		String query="from "+persistentClass.getSimpleName() +" s where ";
		String filed ="  like :filed ";
		query+=" s."+colomn+filed;

		log.debug(query);

		return getSession()
				 .createQuery(query)
				 .setParameter("filed", q).list();
	}
	
	
	/**
	 * 
	 * @param ids String
	 * @param id checking id
	 * @return {@link Boolean} check the sending type are correct id
	 */
	protected boolean checkids(String[] ids,String id){
		Boolean idstus=false;
		for(int i=0;i<ids.length;i++){
			if(id.equals(ids[i])){
				idstus= true;
				i=ids.length+1;
			}
			else{
				idstus= false;
			}
		}
		return idstus;
	}
	
	
}
