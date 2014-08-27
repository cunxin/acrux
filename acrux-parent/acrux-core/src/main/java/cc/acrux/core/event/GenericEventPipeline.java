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
public class GenericEventPipeline<L extends IEventListener<E, S>, E extends IEvent<S>, S> implements IEventPipeline<L, E, S> {
	
	protected Log logger = LogFactory.getLog(getClass());
	
	private IEventHandleContext head;
	
	private IEventHandleContext tail;
	
	public GenericEventPipeline() {
		head = new EventHandleContextHead();
		tail = new EventHandleContextTail();
		
		head.next(tail);
		tail.prev(head);
	}
	
	/* (non-Javadoc)
	 * @see io.kasa.core.event.IEventPipeline#addLast(io.kasa.core.event.IEventListener)
	 */
	@Override
	public IEventPipeline<L, E, S> addLast(L listener) {
		insertBefore(new DefaultEventHandleContext(listener), tail);
		return this;
	}

	/* (non-Javadoc)
	 * @see io.kasa.core.event.IEventPipeline#addFirst(io.kasa.core.event.IEventListener)
	 */
	@Override
	public IEventPipeline<L, E, S> addFirst(L listener) {
		insertBefore(new DefaultEventHandleContext(listener), head.next());
		return this;
	}

	/* (non-Javadoc)
	 * @see io.kasa.core.event.IEventPipeline#insertBefore(io.kasa.core.event.IEventListener, io.kasa.core.event.IEventListener)
	 */
	@Override
	public IEventPipeline<L, E, S> insertBefore(L listener, L position) {
		IEventHandleContext context = null;
		while((context = head.next()) != tail) {
			if(context.getEventListener() == position) {
				insertBefore(new DefaultEventHandleContext(listener), context);
				return this;
			}
		}
		return this;
	}

	/* (non-Javadoc)
	 * @see io.kasa.core.event.IEventPipeline#insertAfter(io.kasa.core.event.IEventListener, io.kasa.core.event.IEventListener)
	 */
	@Override
	public IEventPipeline<L, E, S> insertAfter(L listener, L position) {
		IEventHandleContext context = null;
		while((context = tail.prev()) != head) {
			if(context.getEventListener() == position) {
				insertBefore(new DefaultEventHandleContext(listener), context.next());
				return this;
			}
		}
		return this;
	}
	
	/*
	 * (non-Javadoc)
	 * @see io.kasa.core.event.IEventPipeline#fire(io.kasa.core.event.IEvent)
	 */
	@Override
	public void execute(E e) throws EventHandleException {
		head.execute(e);
	}

	@Override
	public IEventPipeline<L, E, S> remove(L listener) {
		IEventHandleContext context = null;
		while((context = head.next()) != tail) {
			if(context.getEventListener() == listener) {
				insertBefore(context.prev(), context.next());
				context.next(null);
				context.prev(null);
				return this;
			}
		}
		return this;
	}
	
	protected void insertBefore(IEventHandleContext insert, IEventHandleContext position) {
		IEventHandleContext temp = position.prev();
		
		position.prev(insert);
		insert.next(position);
		
		temp.next(insert);
		insert.prev(temp);
	}

	private class EventHandleContextHead extends AbstractEventHandleContext {
		
		public EventHandleContextHead() {
			super(null);
		}

		private IEventHandleContext next;

		@Override
		public void execute(IEvent<?> e) {
			GenericEventPipeline.this.logger.debug("Start event handling.");
			IEventHandleContext next = next();
			if(next != null) {
				next().execute(e);
			}
		}

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
			throw new IllegalAccessError("No previous handle context.");
		}

		@Override
		public void prev(IEventHandleContext prev) {
			throw new IllegalAccessError("Cannot set previous handle context for head.");
		}

	}
	
	private class EventHandleContextTail extends AbstractEventHandleContext {
		
		public EventHandleContextTail() {
			super(null);
		}

		private IEventHandleContext prev;

		@Override
		public void execute(IEvent<?> e) {
			GenericEventPipeline.this.logger.debug("End event handling.");
		}

		@Override
		public IEventHandleContext next() {
			throw new IllegalAccessError("No next handle context.");
		}

		@Override
		public void next(IEventHandleContext next) {
			throw new IllegalAccessError("Cannot set next handle context for tail.");
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
	
}
