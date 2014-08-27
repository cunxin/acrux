/**
 * 
 */
package cc.acrux.core.diagram;

/**
 * @author Alan
 *
 */
public interface ConnectorProvider {

	/**
	 * 获得指定节点的所有下游链接器
	 * @param node
	 * @return
	 */
	public Connector[] findDownstream(Node node);
}
