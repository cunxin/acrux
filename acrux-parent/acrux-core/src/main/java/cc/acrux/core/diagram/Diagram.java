/**
 * 
 */
package cc.acrux.core.diagram;

import cc.acrux.core.persistence.IEntity;

/**
 * @author cunxin.gz
 *
 */
public interface Diagram extends IEntity<String> {
	
	/**
	 * 初始化
	 */
	void initialize() throws DiagramInitializeException;
	
	/**
	 * 设置节点提供者
	 * @param nodeProvider
	 */
	void setNodeProvider(NodeProvider nodeProvider);
	
	/**
	 * 设置连接器提供者
	 * @param connectorProvider
	 */
	void setConnectorProvider(ConnectorProvider connectorProvider);
	
	/**
	 * 闭环检查
	 */
	void closedLoopCheck();
	
}
