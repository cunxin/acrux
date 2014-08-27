/**
 * 
 */
package cc.acrux.core.diagram;

import cc.acrux.core.persistence.IEntity;

/**
 * @author cunxin.gz
 *
 */
public interface Condition extends IEntity<String>{
	
	ConditionOperator getOperator();

	boolean check();

	void setOperator(ConditionOperator operator);
	
}
