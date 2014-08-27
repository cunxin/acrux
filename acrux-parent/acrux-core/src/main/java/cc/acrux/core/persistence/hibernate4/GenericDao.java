/**
 * 
 */
package cc.acrux.core.persistence.hibernate4;

import java.io.Serializable;
import java.util.List;

import org.hibernate.LockMode;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cc.acrux.core.persistence.IEntity;
import cc.acrux.core.persistence.IGenericDao;
import cc.acrux.core.utils.GenericUtils;

/**
 * @author cunxin.gz
 *
 */
@SuppressWarnings("unchecked")
public class GenericDao<E extends IEntity<I>, I extends Serializable> extends HibernateDaoSupport implements IGenericDao<E, I, LockMode> {

	private Class<E> entityClass;
	
	public GenericDao() {
		entityClass = (Class<E>) GenericUtils.getGenericClass(this.getClass());
	}
	
	/* (non-Javadoc)
	 * @see io.kasa.core.persistence.hibernate4.IGenericDao#get(I)
	 */
	@Override
	public E get(I id) {
		return get(id, LockMode.NONE);
	}
	
	/* (non-Javadoc)
	 * @see io.kasa.core.persistence.hibernate4.IGenericDao#get(I, org.hibernate.LockMode)
	 */
	@Override
	public E get(I id, LockMode lockMode) {
		return getHibernateTemplate().get(entityClass, id, lockMode);
	}
	
	/* (non-Javadoc)
	 * @see io.kasa.core.persistence.hibernate4.IGenericDao#delete(I)
	 */
	@Override
	public void delete(I id) {
		delete(id, LockMode.NONE);
	}
	
	/* (non-Javadoc)
	 * @see io.kasa.core.persistence.hibernate4.IGenericDao#delete(I, org.hibernate.LockMode)
	 */
	@Override
	public void delete(I id, LockMode lockMode) {
		delete(get(id), lockMode);
	}
	
	/* (non-Javadoc)
	 * @see io.kasa.core.persistence.hibernate4.IGenericDao#delete(E)
	 */
	@Override
	public void delete(E entity) {
		getHibernateTemplate().delete(entity, LockMode.NONE);
	}
	
	/* (non-Javadoc)
	 * @see io.kasa.core.persistence.hibernate4.IGenericDao#delete(E, org.hibernate.LockMode)
	 */
	@Override
	public void delete(E entity, LockMode lockMode) {
		getHibernateTemplate().delete(entity, lockMode);
	}
	
	/* (non-Javadoc)
	 * @see io.kasa.core.persistence.hibernate4.IGenericDao#save(E)
	 */
	@Override
	public void save(E entity) {
		getHibernateTemplate().save(entity);
	}
	
	/* (non-Javadoc)
	 * @see io.kasa.core.persistence.hibernate4.IGenericDao#saveOrUpdate(E)
	 */
	@Override
	public void saveOrUpdate(E entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}
	
	/* (non-Javadoc)
	 * @see io.kasa.core.persistence.hibernate4.IGenericDao#find(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<E> find(String queryString, Object...values) {
		return (List<E>) getHibernateTemplate().find(queryString, values);
	}
	
}
