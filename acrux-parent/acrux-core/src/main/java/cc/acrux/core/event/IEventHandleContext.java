/**
 * 
 */
package cc.acrux.core.event;

/**
 * @author cunxin.gz
 *
 */
public interface IEventHandleContext {

	/**
	 * 执行
	 * @param e
	 */
	void execute(IEvent<?> e);
	
	/**
	 * 获得下一个IEventHandleContext
	 * @return
	 */
	IEventHandleContext next();
	
	/**
	 * 设置下一个IEventHandleContext
	 * @param next
	 */
	void next(IEventHandleContext next);
	
	/**
	 * 获得上一个IEventHandleContext
	 * @return
	 */
	IEventHandleContext prev();
	
	/**
	 * 设置上一个IEventHandleContext
	 * @param prev
	 */
	void prev(IEventHandleContext prev);
	
	/**
	 * 是否忽略错误
	 * @return
	 */
	boolean isIgnoreError();
	
	/**
	 * 设置是否忽略错误<br/>
	 * 当该属性为<code>true</code>在当前节点的<code>IEventListener</code>对象抛出异常也会继续触发下一个节点
	 * @param ignoreError
	 * @see IEventListener
	 */
	void setIgnoreError(boolean ignoreError);
	
	/**
	 * 获得监听器
	 * @return
	 */
	IEventListener<IEvent<?>, ?> getEventListener();

}
