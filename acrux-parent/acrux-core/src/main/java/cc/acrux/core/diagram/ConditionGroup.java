/**
 * 
 */
package cc.acrux.core.diagram;

import java.util.List;

/**
 * @author cunxin.gz
 *
 */
public class ConditionGroup extends AbstractCondition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3722799544422419400L;
	
	private List<Condition> children;

	@Override
	public boolean check() {
		boolean result = true;
		for(int i = 0; i < children.size() && result; i++) {
			Condition c = children.get(i);
			result = c.getOperator().apply(result, c);
		}
		return result;
	}
	
}
