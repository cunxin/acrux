/**
 * 
 */
package cc.acrux.core.event;

import cc.acrux.core.event.AbstractGenericEvent;

/**
 * @author cunxin.gz
 *
 */
public class EventTest extends AbstractGenericEvent<Object> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6227427761886521129L;
	
	public EventTest(Object source) {
		super(source);
	}
}
