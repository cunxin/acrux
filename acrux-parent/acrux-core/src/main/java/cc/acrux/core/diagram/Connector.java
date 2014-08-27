/**
 * 
 */
package cc.acrux.core.diagram;

/**
 * @author cunxin.gz
 *
 */
public class Connector extends GenericItem<ConnectorKey>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8295837613473745552L;

	private Node upstream;
	
	private Node downstream;

	/**
	 * 获取上游节点
	 * @return
	 */
	public Node getUpstream() {
		return upstream;
	}
	
	/**
	 * 获取下游节点
	 * @return
	 */
	public Node getDownstream() {
		return downstream;
	}

	/**
	 * 设置上游节点
	 * @param downstream
	 */
	public void setDownstream(Node downstream) {
		this.downstream = downstream;
	}

	/**
	 * 设置下游节点
	 * @param upstream
	 */
	public void setUpstream(Node upstream) {
		this.upstream = upstream;
	}
	
}
