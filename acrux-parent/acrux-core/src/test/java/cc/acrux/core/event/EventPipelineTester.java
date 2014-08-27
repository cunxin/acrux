/**
 * 
 */
package cc.acrux.core.event;

import cc.acrux.core.event.EventHandleException;
import cc.acrux.core.event.GenericEventPipeline;
import cc.acrux.core.event.IEventPipeline;
import junit.framework.TestCase;

/**
 * @author cunxin.gz
 *
 */
public class EventPipelineTester extends TestCase {

	public void testAddLast() {
		int count = 10;
		IEventPipeline<EventListenerTest, EventTest, Object> pipeline = new GenericEventPipeline<EventListenerTest, EventTest, Object>();
		
		for(int i = 0; i < count; i++) {
			pipeline.addLast(new EventListenerTest());
		}
		
		try {
			pipeline.execute(new EventTest(new Object()));
		} catch (EventHandleException e) {
			e.printStackTrace();
		}
	}
}
