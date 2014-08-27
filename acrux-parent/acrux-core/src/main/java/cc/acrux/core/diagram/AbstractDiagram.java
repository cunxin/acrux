/**
 * 
 */
package cc.acrux.core.diagram;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author cunxin.gz
 *
 */
public abstract class AbstractDiagram implements Diagram {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7932378976076156195L;
	
	protected Log logger = LogFactory.getLog(getClass());

	protected NodeProvider nodeProvider;
	
	protected ConnectorProvider connectorProvider;
	
	protected Map<String, Node> activeNodes = new ConcurrentHashMap<>(0);
	
	private boolean initialized = false;
	
	private String id;

	/* (non-Javadoc)
	 * @see io.kasa.core.diagram.Diagram#initialize()
	 */
	@Override
	public synchronized void initialize() throws DiagramInitializeException {
		if(this.initialized) {
			return;
		}
		
		Node[] startNodes = null;
		
		try {
			startNodes = nodeProvider.findStartNodes();
		} catch (Throwable t) {
			throw new DiagramInitializeException("Load start nodes error.", t);
		}
		
		if(startNodes.length == 0) {
			throw new DiagramInitializeException("No start nodes found.");
		}
		for(Node startNode : startNodes) {
			activateNode(startNode);
		}
		
		initialized = true;
	}

	/* (non-Javadoc)
	 * @see io.kasa.core.diagram.Diagram#setNodeProvider(io.kasa.core.diagram.NodeProvider)
	 */
	@Override
	public void setNodeProvider(NodeProvider nodeProvider) {
		this.nodeProvider = nodeProvider;
	}

	/* (non-Javadoc)
	 * @see io.kasa.core.diagram.Diagram#setConnectorProvider(io.kasa.core.diagram.ConnectorProvider)
	 */
	@Override
	public void setConnectorProvider(ConnectorProvider connectorProvider) {
		this.connectorProvider = connectorProvider;
	}
	
	protected Node activateNode(Node node) {
		Connector[] downstream = connectorProvider.findDownstream(node);
		node.setDownstream(downstream);
		return node;
	}
	
	/*
	 * (non-Javadoc)
	 * @see io.kasa.core.persistence.IEntity#getId()
	 */
	public String getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * @see io.kasa.core.persistence.IEntity#setId(java.io.Serializable)
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object target) {
		if(target instanceof Diagram && id != null) {
			return id.equals(((Diagram) target).getId());
		}
		return false;
	}
	
}
