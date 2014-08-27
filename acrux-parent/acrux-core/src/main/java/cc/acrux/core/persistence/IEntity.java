/**
 * 
 */
package cc.acrux.core.persistence;

import java.io.Serializable;

/**
 * @author cunxin.gz
 * 数据实体类
 */
public interface IEntity<I extends Serializable> extends Serializable {

	/**
	 * 设置ID
	 * @return
	 */
	I getId();
	
	/**
	 * 获得ID
	 * @param id
	 */
	void setId(I id);
}
