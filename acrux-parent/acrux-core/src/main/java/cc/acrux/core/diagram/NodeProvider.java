/**
 * 
 */
package cc.acrux.core.diagram;

/**
 * @author Alan
 *
 */
public interface NodeProvider {

	/**
	 * 通过ID获得节点
	 * @param id
	 * @return
	 */
	Node get(String id);
	
	/**
	 * 获得所有开始节点
	 * @return
	 */
	Node[] findStartNodes();
}
