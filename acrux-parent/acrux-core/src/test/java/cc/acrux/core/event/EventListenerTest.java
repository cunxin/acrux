/**
 * 
 */
package cc.acrux.core.event;

import cc.acrux.core.event.EventHandleException;
import cc.acrux.core.event.IEventListener;

/**
 * @author cunxin.gz
 *
 */
public class EventListenerTest implements IEventListener<EventTest, Object> {

	/* (non-Javadoc)
	 * @see io.kasa.core.event.IEventListener#handle(io.kasa.core.event.IEvent)
	 */
	@Override
	public void handling(EventTest event) throws EventHandleException {
		System.out.println(event.getId());
	}

	@Override
	public boolean isAllowHandling(EventTest event) {
		return true;
	}

}
