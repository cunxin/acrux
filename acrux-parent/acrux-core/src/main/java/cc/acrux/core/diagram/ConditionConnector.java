/**
 * 
 */
package cc.acrux.core.diagram;

/**
 * @author Alan
 *
 */
public class ConditionConnector extends Connector {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4556816199276071364L;
	
	private Condition condition;
	
	private boolean ignoreCondition = false;

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	public boolean isIgnoreCondition() {
		return ignoreCondition;
	}

	public void setIgnoreCondition(boolean ignoreCondition) {
		this.ignoreCondition = ignoreCondition;
	}
	
	@Override
	public Node getDownstream() throws ConditionCheckException {
		if(ignoreCondition || condition == null || condition.check()) {
			return super.getDownstream();
		}
		// TODO: 是否可行？
		throw new ConditionCheckException("Condition check failed - " + condition);
	}
	
}
