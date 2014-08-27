/**
 * 
 */
package cc.acrux.core.event;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author cunxin.gz
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public abstract class AbstractEventHandleContext implements IEventHandleContext {
	
	protected static Log logger = LogFactory.getLog(IEventHandleContext.class);
	
	private IEventListener listener;
	
	protected boolean ignoreError = true;
	
	public AbstractEventHandleContext(IEventListener listener) {
		this.listener = listener;
	}

	/* (non-Javadoc)
	 * @see io.kasa.core.event.IEventHandleContext#execute(io.kasa.core.event.IEvent)
	 */
	@Override
	public void execute(IEvent<?> event) {
		assert event != null;
		boolean success = true;
		try {
			if(listener.isAllowHandling(event)) {
				listener.handling(event);
			}
		} catch (EventHandleException e) {
			success = false;
			logger.error("Handling event error.", e);
		} finally {
			if(success || ignoreError) {
				IEventHandleContext next = next();
				if(next != null) {
					next.execute(event);
				}
			}
		}
	}
	
	@Override
	public boolean isIgnoreError() {
		return ignoreError;
	}

	@Override
	public void setIgnoreError(boolean ignoreError) {
		this.ignoreError = ignoreError;
	}
	
	@Override
	public IEventListener<IEvent<?>, ?> getEventListener() {
		return listener;
	}

}
