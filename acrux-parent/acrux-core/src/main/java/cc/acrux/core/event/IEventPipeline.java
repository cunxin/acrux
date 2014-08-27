/**
 * 
 */
package cc.acrux.core.event;

/**
 * @author cunxin.gz
 *
 */
public interface IEventPipeline<L extends IEventListener<E, S>, E extends IEvent<S>, S> {
	
	/**
	 * 将监听器插加到最后
	 * @param listener
	 * @return this
	 */
	IEventPipeline<L, E, S> addLast(L listener);
	
	/**
	 * 将监听器加到最前
	 * @param listener
	 * @return this
	 */
	IEventPipeline<L, E, S> addFirst(L listener);
	
	/**
	 * 将监听器插入到指定监听器前
	 * @param listener
	 * @param position
	 * @return this
	 */
	IEventPipeline<L, E, S> insertBefore(L listener, L position);
	
	/**
	 * 将监听器插入到指定监听器后
	 * @param listener
	 * @param position
	 * @return this
	 */
	IEventPipeline<L, E, S> insertAfter(L listener, L position);
	
	/**
	 * 删除监听器
	 * @param listener
	 * @return
	 */
	IEventPipeline<L, E, S> remove(L listener);
	
	/**
	 * 执行管道中的监听器
	 * @param e
	 */
	void execute(E e) throws EventHandleException;
	
}
