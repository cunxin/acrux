/**
 * 
 */
package cc.acrux.core.event;

import java.util.UUID;

/**
 * @author cunxin.gz
 *
 */
public abstract class AbstractGenericEvent<S> implements IEvent<S> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8268049126340130692L;
	
	private String id;
	
	private Long timestamp;
	
	private S source;
	
	public AbstractGenericEvent(S source) {
		id = generateId();
		timestamp = System.currentTimeMillis();
		this.source = source;
		
	}

	/* (non-Javadoc)
	 * @see io.kasa.core.persistence.IEntity#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see io.kasa.core.persistence.IEntity#setId(java.io.Serializable)
	 */
	@Override
	public void setId(String id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see io.kasa.core.event.IEvent#getTimestamp()
	 */
	@Override
	public long getTimestamp() {
		return timestamp;
	}

	/* (non-Javadoc)
	 * @see io.kasa.core.event.IEvent#getEventSource()
	 */
	@Override
	public S getSource() {
		return source;
	}
	
	protected String generateId() {
		return UUID.randomUUID().toString();
	}

}
