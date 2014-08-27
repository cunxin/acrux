/**
 * 
 */
package cc.acrux.core.diagram;

/**
 * @author Alan
 *
 */
public abstract class AbstractCondition implements Condition {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3136305637388415219L;
	
	protected ConditionOperator operator = ConditionOperator.AND;
	
	private String id;

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
	 * @see io.kasa.master.engine.diagram.Condition#getOperator()
	 */
	@Override
	public ConditionOperator getOperator() {
		return operator;
	}

	/*
	 * (non-Javadoc)
	 * @see io.kasa.core.diagram.Condition#setOperator(io.kasa.core.diagram.ConditionOperator)
	 */
	@Override
	public void setOperator(ConditionOperator operator) {
		this.operator = operator;
	}
	
}
