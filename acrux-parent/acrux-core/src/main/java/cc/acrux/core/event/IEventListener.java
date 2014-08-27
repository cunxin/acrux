/**
 * 
 */
package cc.acrux.core.event;

/**
 * @author cunxin.gz
 *
 */
public interface IEventListener<E extends IEvent<S>, S> {

	/**
	 * 处理事件
	 * @param event
	 * @throws EventHandleException
	 */
	void handling(E event) throws EventHandleException;
	
	/**
	 * 是否可以处理指定的事件
	 * @param event
	 * @return
	 */
	boolean isAllowHandling(E event);
	
}
