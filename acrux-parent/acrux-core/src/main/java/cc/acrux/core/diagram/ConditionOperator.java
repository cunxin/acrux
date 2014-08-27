/**
 * 
 */
package cc.acrux.core.diagram;

import java.util.function.BiFunction;

/**
 * @author cunxin.gz
 *
 */
public enum ConditionOperator {

	AND("AND", new BiFunction<Boolean, Condition, Boolean>() {

		@Override
		public Boolean apply(Boolean left, Condition right) {
			return left && (right == null || right.check());
		}
		
	}),
	
	OR("OR", new BiFunction<Boolean, Condition, Boolean>() {

		@Override
		public Boolean apply(Boolean left, Condition right) {
			return left || (right == null || right.check());
		}
		
	});
	
	private String key;
	
	private BiFunction<Boolean, Condition, Boolean> operation;
	
	private ConditionOperator(String key, BiFunction<Boolean, Condition, Boolean> operation) {
		this.key = key;
		this.operation = operation;
	}

	public String key() {
		return key;
	}

	public Boolean apply(Boolean left, Condition right) {
		return operation.apply(left, right);
	}

}
