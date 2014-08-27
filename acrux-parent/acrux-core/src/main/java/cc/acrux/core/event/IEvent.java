/**
 * 
 */
package cc.acrux.core.event;

import cc.acrux.core.persistence.IEntity;

/**
 * @author cunxin.gz
 *
 */
public interface IEvent<S> extends IEntity<String> {

	/**
	 * 获得发生时间
	 * @return
	 */
	long getTimestamp();
	
	/**
	 * 获得事件源
	 * @return
	 */
	S getSource();
	
}
