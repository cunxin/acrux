package cc.acrux.core.persistence;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<E extends IEntity<I>, I extends Serializable, L> {

	/**
	 * 通过唯一标识获取实体
	 * @param id
	 * @return
	 */
	E get(I id);

	/**
	 * 通过唯一标识获取实体
	 * @param id
	 * @param lockMode
	 * @return
	 */
	E get(I id, L lockMode);

	/**
	 * 通过唯一标识删除实体
	 * @param id
	 */
	void delete(I id);

	/**
	 * 通过唯一标识删除实体
	 * @param id
	 * @param lockMode
	 */
	void delete(I id, L lockMode);

	/**
	 * 删除指定的实体对象
	 * @param entity
	 */
	void delete(E entity);

	/**
	 * 删除指定的实体对象
	 * @param entity
	 * @param lockMode
	 */
	void delete(E entity, L lockMode);

	/**
	 * 保存实体
	 * @param entity
	 */
	void save(E entity);

	/**
	 * 保存或更新实体
	 * @param entity
	 */
	void saveOrUpdate(E entity);

	/**
	 * 通过查询字符串查找集合
	 * @param queryString
	 * @param values
	 * @return
	 */
	List<E> find(String queryString, Object... values);

}