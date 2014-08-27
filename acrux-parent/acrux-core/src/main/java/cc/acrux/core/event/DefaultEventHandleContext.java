/**
 * 
 */
package cc.acrux.core.event;

/**
 * @author cunxin.gz
 *
 */
@SuppressWarnings("rawtypes")
public class DefaultEventHandleContext extends AbstractEventHandleContext {
	
	public DefaultEventHandleContext(IEventListener listener) {
		super(listener);
	}

	private IEventHandleContext next;
	
	private IEventHandleContext prev;

	@Override
	public IEventHandleContext next() {
		return next;
	}

	@Override
	public void next(IEventHandleContext next) {
		this.next = next;
	}

	@Override
	public IEventHandleContext prev() {
		return prev;
	}

	@Override
	public void prev(IEventHandleContext prev) {
		this.prev = prev;
	}

}
